package br.com.toyoda.elo7.parse;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ParseUtil<T> {
	
	public String toJson(T value){
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
