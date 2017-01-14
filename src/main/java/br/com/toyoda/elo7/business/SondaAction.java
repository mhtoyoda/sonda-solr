package br.com.toyoda.elo7.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;
import br.com.toyoda.elo7.search.document.SondaSearch;
import br.com.toyoda.elo7.search.exception.SearchException;
import br.com.toyoda.elo7.search.indexer.SondaIndexer;

@Component
public class SondaAction {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SondaIndexer sondaIndexer;
	
	public Sonda executeComands(Planalto planalto, Sonda sonda, String comand){		
		String comands = StringUtils.trimAllWhitespace(comand).toUpperCase();
		SondaSearch sondaSearch = new SondaSearch(planalto.getNome(), sonda.getIdentificacao(), sonda.toString(), StringUtils.split(comands, ""));
		for(int index = 0; index < comands.length(); index++){
			String instruction = String.valueOf(comands.charAt(index));
			sonda = move(planalto, sonda, instruction);
		}
		
		indexaSonda(sondaSearch, sonda.getCoordinateX(), sonda.getCoordinateY(), sonda.getDirection().name());
		
		return sonda;
	}
	
	public Sonda move(Planalto planalto, Sonda sonda, String comando){
		if(comando.equalsIgnoreCase("R")){
			sonda.moveRight();
		}else if(comando.equalsIgnoreCase("L")){
			sonda.moveLeft();
		}else if(comando.equalsIgnoreCase("M")){
			sonda.moveOn(planalto);
		}
		
		return sonda;
	}
	
	private void indexaSonda(SondaSearch sondaSearch, Integer coordinateX, Integer coordinateY, String direction){
		try {
			sondaIndexer.indexerSonda(sondaSearch, coordinateX, coordinateY, direction);
		} catch (SearchException e) {
			log.error("Erro ao indexar dados de sonda "+e.getMessage());			
		}
	}
}