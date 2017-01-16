package br.com.toyoda.elo7.business;

import java.util.List;

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
	
	public Sonda executeComands(Planalto planalto, Sonda sonda, String comand) throws SearchException{		
		String comands = StringUtils.trimAllWhitespace(comand).toUpperCase();
		String currentPosition = sonda.toString();
		for(int index = 0; index < comands.length(); index++){
			String instruction = String.valueOf(comands.charAt(index));
			sonda = move(planalto, sonda, instruction);
		}
		SondaSearch sondaSearch = new SondaSearch(planalto.getNome(), sonda, currentPosition, comands.split(""));
		indexaSonda(sondaSearch);
		
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
	
	private void indexaSonda(SondaSearch sondaSearch) throws SearchException{
		try {
			sondaIndexer.indexerSonda(sondaSearch);
		} catch (SearchException e) {
			log.error("Erro ao indexar dados de sonda "+e.getMessage());
			throw e;
		}
	}
	
	protected void indexaSondaList(List<SondaSearch> list) throws SearchException{
		try {
			sondaIndexer.indexaFullList(list);
		} catch (SearchException e) {
			log.error("Erro ao indexar dados de sonda "+e.getMessage());
			throw e;
		}
	}
}