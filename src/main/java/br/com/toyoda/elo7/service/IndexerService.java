package br.com.toyoda.elo7.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class IndexerService {

	@RequestMapping(value = "planalto", method = RequestMethod.GET)
	public String planalto(){
		return "teste";
	}
}
