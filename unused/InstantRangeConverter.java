package com.admir.demiraj.springbootfuultutorial2.unused;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

/**
 * Maps Postgres' TimestampTZ ranges as Java objects.
 */
public class InstantRangeConverter implements Binding<Object, Interval> {
    private static final String DATE_OR_EMPTY = "(?:(?:'([^']+)')?)";
    private static final Pattern PATTERN = Pattern.compile("[(\\[(]" + DATE_OR_EMPTY + "," + DATE_OR_EMPTY + "[\\])]");
    private static final DateTimeFormatter PG_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(ISO_LOCAL_TIME)
            .appendOffset("+HHmm", "+00")
            .toFormatter();
    @Override
    public Converter<Object, Interval> converter() {
        return new Converter<Object, Interval>() {
            @Override
            public Interval from(Object t) {
                if (t == null) return null;
                if ("empty".equals(t)) return Interval.EMPTY;
                Matcher m = PATTERN.matcher("" + t);
                if (m.find()) {
                    String fromStr = m.group(1);
                    String toStr = m.group(2);
                    Instant from = (fromStr == null || "".equals(fromStr)) ? null : PG_TIME_FORMATTER.parse(fromStr, OffsetDateTime::from).toInstant();
                    Instant to = (toStr == null || "".equals(toStr)) ? null : PG_TIME_FORMATTER.parse(toStr, OffsetDateTime::from).toInstant();
                    return new Interval(from, to);
                } else {
                    throw new IllegalArgumentException("Unsupported range : " + t);
                }
            }
            @Override
            public Object to(Interval u) {
                if (u == null) return null;
                if (u == null) return "empty";
                if (u.from == null && u.to == null) return "(,)";
                String fromStr = u.from != null ? Timestamp.from(u.from).toString() : "";
                String toStr = u.to != null ? Timestamp.from(u.to).toString() : "";
                return "[" + fromStr + "," + toStr + "]";
            }
            @Override
            public Class<Object> fromType() {
                return Object.class;
            }
            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public Class<Interval> toType() {
                return Interval.class;
            }
        };
    }
    @Override
    public void register(BindingRegisterContext<Interval> ctx) throws SQLException {
        ctx.statement().registerOutParameter(ctx.index(), Types.VARCHAR);
    }
    @Override
    public void sql(BindingSQLContext<Interval> ctx) throws SQLException {
        ctx.render()
                .visit(DSL.val(ctx.convert(converter()).value()))
                .sql("::tstzrange");
    }
    @Override
    public void get(BindingGetResultSetContext<Interval> ctx) throws SQLException {
        ctx.convert(converter()).value(ctx.resultSet().getString(ctx.index()));
    }
    // Getting a String value from a JDBC CallableStatement and converting that to a String
    @Override
    public void get(BindingGetStatementContext<Interval> ctx) throws SQLException {
        ctx.convert(converter()).value(ctx.statement().getString(ctx.index()));
    }
    @Override
    public void set(BindingSetStatementContext<Interval> ctx) throws SQLException {
        ctx.statement().setString(ctx.index(), Objects.toString(ctx.convert(converter()).value(), null));
    }
    // Setting a value on a JDBC SQLOutput (useful for Oracle OBJECT types)
    @Override
    public void set(BindingSetSQLOutputContext<Interval> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }
    // Getting a value from a JDBC SQLInput (useful for Oracle OBJECT types)
    @Override
    public void get(BindingGetSQLInputContext<Interval> ctx) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }
}