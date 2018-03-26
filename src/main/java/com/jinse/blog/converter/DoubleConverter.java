package com.jinse.blog.converter;

import java.text.DecimalFormat;

import org.springframework.core.convert.converter.Converter;

public class DoubleConverter implements Converter<Double, Double> {
	@Override
	public Double convert(Double source) {

		DecimalFormat df = new DecimalFormat("######0.00");

		return Double.parseDouble(df.format(source));

	}
}
