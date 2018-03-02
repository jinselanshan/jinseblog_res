package com.jinse.blog.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class CustomDateConverter  implements Converter<String, Date>{

    public Date convert(String source) {
        
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
        }
        
        return null;
    }

}


