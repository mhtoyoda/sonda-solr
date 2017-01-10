package br.com.toyoda.elo7.search.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import br.com.toyoda.elo7.search.document.SondaSearch;

public interface SondaSolrRepository extends SolrCrudRepository<SondaSearch, Long>{

}
