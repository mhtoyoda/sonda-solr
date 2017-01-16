package br.com.toyoda.elo7.search.indexer;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Component;

import br.com.toyoda.elo7.search.document.SondaSearch;
import br.com.toyoda.elo7.search.document.SondaSearchResult;
import br.com.toyoda.elo7.search.exception.SearchException;
import br.com.toyoda.elo7.search.repository.SondaSolrRepository;

@Component
public class SondaIndexer {

	@Autowired
	private SondaSolrRepository sondaSolrRepository;

	public boolean indexerSonda(SondaSearch dados)
			throws SearchException {
		try {			
			sondaSolrRepository.save(dados);
		} catch (Exception e) {
			throw new SearchException("Error ao Indexar [" + dados.getPositionCurrent() + "] - " + e.getMessage());
		}
		return true;
	}

	public SondaSearchResult findSondaDirectionFacet(List<String> directions, Pageable page) {
		SondaSearchResult sondaSearchResult = new SondaSearchResult();
		FacetPage<SondaSearch> findSondaDirectionFacet = sondaSolrRepository.findSondaDirectionFacet(directions, page);
		sondaSearchResult.setResults(findSondaDirectionFacet.getContent());
		for (Page<? extends FacetEntry> facet : findSondaDirectionFacet.getAllFacets()) {
			for (FacetEntry facetEntry : facet.getContent()) {
				if(directions.contains(StringUtils.upperCase(facetEntry.getValue()))){
					sondaSearchResult.addMapFacet(facetEntry.getValue(), facetEntry.getValueCount());
				}				
			}
		}
		return sondaSearchResult;
	}
	
	public SondaSearchResult findSondaDirection(String direction, Pageable page) {
		SondaSearchResult sondaSearchResult = new SondaSearchResult();
		Page<SondaSearch> results = sondaSolrRepository.findSondaDirection(direction, page);
		sondaSearchResult.setResults(results.getContent());
		return sondaSearchResult;
	}
	
	public SondaSearchResult findSondaPositionText(String term, Pageable page) {
		SondaSearchResult sondaSearchResult = new SondaSearchResult();
		Page<SondaSearch> results = sondaSolrRepository.findSondaPositionText(term, page);
		sondaSearchResult.setResults(results.getContent());
		return sondaSearchResult;
	}

	public SondaSearchResult findSondaHighLightTerm(String termo, Pageable pageable) {
		SondaSearchResult sondaSearchResult = new SondaSearchResult();
		HighlightPage<SondaSearch> highlightPage = sondaSolrRepository.findSondaHighLightTerm(termo, pageable);
		sondaSearchResult.setResults(highlightPage.getContent());

		for (HighlightEntry<SondaSearch> he : highlightPage.getHighlighted()) {
			for (Highlight highlight : he.getHighlights()) {
				for (String highlightTerm : highlight.getSnipplets()) {
					sondaSearchResult.addHighLight(highlightTerm);
				}
			}
		}
		return sondaSearchResult;
	}

	public void indexaFullList(List<SondaSearch> list) throws SearchException{
		try{
			sondaSolrRepository.save(list);
		}catch (Exception e) {
			throw new SearchException(e.getMessage());
		}
	}
}