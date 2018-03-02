package com.jinse.blog.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class CustomDateConverter2  implements Converter<String, Date>{

    public Date convert(String source) {
        
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
        }
        
        return null;
    }

}


