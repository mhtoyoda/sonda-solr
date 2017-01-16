package br.com.toyoda.elo7.search.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import br.com.toyoda.elo7.search.document.SondaSearch;

public interface SondaSolrRepository extends SolrCrudRepository<SondaSearch, Long>{

	@Facet(fields = {"direction"}, minCount= 1, limit = 5)	
    @Query(value="*:*", filters="direction:(?0)")
	public FacetPage<SondaSearch> findSondaDirectionFacet(List<String> directions, Pageable page);
		
    @Query(value="*:*", filters="direction:(?0)")
	public FacetPage<SondaSearch> findSondaDirection(String direction, Pageable page);
	
    @Query(value="*:*", filters="sondaPositionCurrent_txt:(?0)")
	public Page<SondaSearch> findSondaPositionText(String term, Pageable page);
    
    @Query(value="searchField:(?0)")
    @Highlight(prefix = "<term-highlight>", postfix = "</term-highlight>")
    public HighlightPage<SondaSearch> findSondaHighLightTerm(String termo, Pageable pageable);
    
}
