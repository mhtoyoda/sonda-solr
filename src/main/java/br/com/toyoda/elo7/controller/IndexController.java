package br.com.toyoda.elo7.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Model model){
		//model.addAttribute("username", "Marcelo");
		List<String> planaltos = Arrays.asList("Júpiter", "Marte", "Netuno", "Saturno", "Urano", "Plutão","Vênus");
		model.addAttribute("planaltos", planaltos);
		return "index";
	}
}
