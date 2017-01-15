package br.com.toyoda.elo7.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.toyoda.elo7.business.SondaAction;
import br.com.toyoda.elo7.controller.model.SondaActionModel;
import br.com.toyoda.elo7.controller.model.SondaResult;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

@Controller
public class IndexController {
	
	@Autowired
	private SondaAction sondaActionBusiness;
	
	@ModelAttribute("planaltos")
	public List<String> getPlanaltos(){
		List<String> planaltos = Arrays.asList("Júpiter", "Marte", "Netuno", "Saturno", "Urano", "Plutão","Vênus");
		return planaltos;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Model model){
		model.addAttribute("sondaAction", new SondaActionModel());
		model.addAttribute("hasError", false);
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/sendIntructions")	
	public ModelAndView sendIntructions(HttpServletRequest request, @ModelAttribute("sondaAction") final SondaActionModel sondaAction){				
		ModelAndView modelAndView = null;
		try{
			Planalto planalto = new Planalto(sondaAction.getPlanaltoNome(), sondaAction.getPlanaltoCoordenadaLimitX(), sondaAction.getPlanaltoCoordenadaLimitY());		
			
			Sonda sonda1 = new Sonda(sondaAction.getIdentificacaoSonda1(), sondaAction.getCoordinateXSonda1(), sondaAction.getCoordinateYSonda1(), sondaAction.getDirectionSonda1());
			sonda1 = sondaActionBusiness.executeComands(planalto, sonda1 , StringUtils.upperCase(sondaAction.getComandSonda1()));
			
			Sonda sonda2 = new Sonda(sondaAction.getIdentificacaoSonda2(), sondaAction.getCoordinateXSonda2(), sondaAction.getCoordinateYSonda2(), sondaAction.getDirectionSonda2());
			sonda2 = sondaActionBusiness.executeComands(planalto, sonda2 , StringUtils.upperCase(sondaAction.getComandSonda2()));
			
			SondaResult sondaResult = new SondaResult(sonda1, sonda2);
			modelAndView = new ModelAndView("result");
			modelAndView.addObject("planalto", planalto);
			modelAndView.addObject("sondaResult", sondaResult);
			return modelAndView;
		}catch (Exception e) {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("sondaAction", sondaAction);
			modelAndView.addObject("hasError", true);
			modelAndView.addObject("message", "Ocorreu um erro ao processar sondas");
			return modelAndView;
		}
		
	}
}
