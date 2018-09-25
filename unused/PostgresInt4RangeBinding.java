
import com.admir.demiraj.springbootfuultutorial2.unused.Int4RangeConverter;
import java.sql.SQLException;
import java.util.Date;
import org.jooq.Binding;
import org.jooq.BindingGetResultSetContext;
import org.jooq.BindingGetSQLInputContext;
import org.jooq.BindingGetStatementContext;
import org.jooq.BindingRegisterContext;
import org.jooq.BindingSQLContext;
import org.jooq.BindingSetSQLOutputContext;
import org.jooq.BindingSetStatementContext;
import org.jooq.Converter;
import org.jooq.impl.DSL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class PostgresInt4RangeBinding implements Binding<Object, Date[]> {

    @Override
    public Converter<Object, Date[]> converter() {
        return new Int4RangeConverter();
    }

    @Override
    public void sql(BindingSQLContext<Date[]> ctx) throws SQLException {
        ctx.render()
           .visit(DSL.val(ctx.convert(converter()).value()))
           .sql("::tstzrange");
    }

    @Override
    public void register(BindingRegisterContext<Date[]> brc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(BindingSetStatementContext<Date[]> bssc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(BindingSetSQLOutputContext<Date[]> bsqlc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void get(BindingGetResultSetContext<Date[]> bgrsc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void get(BindingGetStatementContext<Date[]> bgsc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void get(BindingGetSQLInputContext<Date[]> bgsqlc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
