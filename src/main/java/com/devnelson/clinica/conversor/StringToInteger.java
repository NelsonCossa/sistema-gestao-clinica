package com.devnelson.clinica.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToInteger implements Converter<String,Integer> {

	@Override
	public Integer convert(String text) {
		text=text.strip();
		if(text.matches("[0-9]+")) {
		return Integer.valueOf(text);	
		}
		return null;
	}

}
