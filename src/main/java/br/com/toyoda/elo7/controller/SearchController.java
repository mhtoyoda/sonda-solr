package br.com.toyoda.elo7.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.search.document.SondaSearchResult;
import br.com.toyoda.elo7.search.indexer.SondaIndexer;

@Controller
public class SearchController {
	
	@Autowired
	private SondaIndexer sondaIndexer;
	
	@ModelAttribute("planaltos")
	public List<String> getPlanaltos(){
		List<String> planaltos = Arrays.asList("Júpiter", "Marte", "Netuno", "Saturno", "Urano", "Plutão","Vênus");
		return planaltos;
	}
	
	private List<String> getDirections(){
		List<String> directions = Arrays.asList(Direction.EAST.name(), Direction.WEST.name(),Direction.NORTH.name(), Direction.SOUTH.name());
		return directions;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public String index(Model model){				
		getFacetDirection(model);
		return "search";
	}

	private void getFacetDirection(Model model) {
		SondaSearchResult facetResult = sondaIndexer.findSondaDirectionFacet(getDirections(), new PageRequest(0, 10));
		model.addAttribute("directions", facetResult.getFacetMap());
	}
}
