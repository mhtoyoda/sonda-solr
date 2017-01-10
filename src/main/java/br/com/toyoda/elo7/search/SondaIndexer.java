package br.com.toyoda.elo7.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SondaIndexer {

	@Autowired
	private SondaSolrRepository sondaSolrRepository;
	
	public boolean indexerSonda(SondaSearch dados, Integer coordinateX, Integer coordinateY, String direction) throws SearchException{
		try{
			dados.setCoordinateX(coordinateX);
			dados.setCoordinateY(coordinateY);
			dados.setDirection(direction);
			sondaSolrRepository.save(dados);
		}catch (Exception e) {
			throw new SearchException("Error ao Indexar ["+dados.getPositionCurrent()+"] - "+e.getMessage());
		}
		return true;
	}
}
