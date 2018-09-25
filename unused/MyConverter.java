package com.admir.demiraj.springbootfuultutorial2.unused;

import com.admir.demiraj.springbootfuultutorial2.unused.Int4RangeConverter;
import org.jooq.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyConverter implements Converter<Object, String> {
    private static final Pattern PATTERN = Pattern.compile("\\[(.*?),(.*?)\\)");
    SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-M-dd hh:mm");
    String bothDates;

    @Override
    public String from(Object t) {
        if (t == null)
            return null;

        Matcher m = PATTERN.matcher("" + t);
        if (m.find())

            try {
                bothDates = dateformater.parse(m.group(1)).toString();
                bothDates = bothDates + "," + dateformater.parse(m.group(2)).toString();

            } catch (ParseException ex) {
                Logger.getLogger(Int4RangeConverter.class.getName()).log(Level.SEVERE, null, ex);
            }


        return  bothDates;


    }

    @Override
    public Object to(String bothDates) {
        String result[] = bothDates.split(",");
        return bothDates == null ? null : "[" + result[0] + "," + result[1]+ ")";
    }

    @Override
    public Class<Object> fromType() {
        return Object.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Class<String> toType() {
        return String.class;
    }
}
