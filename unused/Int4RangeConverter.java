/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admir.demiraj.springbootfuultutorial2.unused;

/**
 *
 * * @author root
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jooq.Converter;


public class Int4RangeConverter implements Converter<Object, Date[]> {
    private static final Pattern PATTERN = Pattern.compile("\\[(.*?),(.*?)\\)");
    SimpleDateFormat dateformater = new SimpleDateFormat("yyyy-M-dd hh:mm");
    Date date1,date2 = new Date();
    Date [] dateArray = new Date[2];

    @Override
    public Date[] from(Object t) {
        if (t == null)
            return null;

        Matcher m = PATTERN.matcher("" + t);
        if (m.find())
            
        try {
            date1 = dateformater.parse(m.group(1));
            date2 = dateformater.parse(m.group(2));
        } catch (ParseException ex) {
            Logger.getLogger(Int4RangeConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
            dateArray[0] = date1;
            dateArray[1] = date2;
      
            return  dateArray;

       
    }

    @Override
    public Object to(Date[] dateArray) {
        return dateArray == null ? null : "[" + dateArray[0] + "," + dateArray[1]+ ")";
    }

    @Override
    public Class<Object> fromType() {
        return Object.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Class<Date[]> toType() {
        return (Class) Date[].class;
    }
}
 