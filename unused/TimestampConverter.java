/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package com.admir.demiraj.springbootfuultutorial2.unused;



import org.jooq.Converter;


public class TimestampConverter implements Converter<Object, String> {

    @Override
    public String from(Object obj) {
        return obj == null ? null : obj.toString();
        
    }

    @Override
    public Object to(String str) {
        return str == null ? null :(Object) str;
    }

    @Override
    public Class<Object> fromType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Object.class;
    }

    @Override
    public Class<String> toType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return String.class;
    }

    

    
}