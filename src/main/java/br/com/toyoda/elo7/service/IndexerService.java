package br.com.toyoda.elo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.toyoda.elo7.search.document.SondaSearchResult;
import br.com.toyoda.elo7.search.indexer.SondaIndexer;

@RestController
@RequestMapping("service")
public class IndexerService {

	@Autowired
	private SondaIndexer sondaIndexer;
	
	@RequestMapping(value = "direction/{name}", method = RequestMethod.GET, produces = "application/json")
	public SondaSearchResult planalto(@PathVariable("name") String name){
		SondaSearchResult facetResult = sondaIndexer.findSondaDirection(name, new PageRequest(0, 10));
		return facetResult;
	}
}
