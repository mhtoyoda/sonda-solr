package br.com.toyoda.elo7.search.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SondaSearchResult {

	private List<SondaSearch> results = new ArrayList<>();
	private Map<String, Long> facetMap;
	private List<String> highlights;
	
	public List<SondaSearch> getResults() {
		return results;
	}
	
	public void setResults(List<SondaSearch> results) {
		this.results = results;
	}
	
	public Map<String, Long> getFacetMap() {
		return facetMap;
	}
	
	public void addMapFacet(String category, Long count){
		if( null == facetMap ){
			facetMap = new HashMap<>();
		}
		facetMap.put(category, count);
	}
	
	public List<String> getHighlights() {
		return highlights;
	}
	
	public void addHighLight(String highlightTerm){
		if( null == highlights ){
			highlights = new ArrayList<String>();
		}
		highlights.add(highlightTerm);
	}
}
