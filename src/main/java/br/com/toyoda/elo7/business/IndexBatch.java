package br.com.toyoda.elo7.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;
import br.com.toyoda.elo7.search.document.SondaSearch;
import br.com.toyoda.elo7.search.exception.SearchException;

@Component
public class IndexBatch {
	
	@Autowired
	private SondaAction sondaAction;
	
	public void generateDataRandom(int qtd) throws SearchException{		
		List<SondaSearch> list = new ArrayList<SondaSearch>();
		for(int index = 0; index < qtd; index++){
			Planalto planalto = generatePlanaltoRandom();
			Sonda sonda = generateSondaRandom(index, planalto.getCoordenadaLimitX(), planalto.getCoordenadaLimitY());
			String currentPosition = sonda.toString();
			String comands = generateComandsRandom();			
			for(int comandIndex = 0; comandIndex < comands.length(); comandIndex++){
				String instruction = String.valueOf(comands.charAt(comandIndex));
				sonda = sondaAction.move(planalto, sonda, instruction);
			}
			SondaSearch sondaSearch = new SondaSearch(planalto.getNome(), sonda, currentPosition, comands.split(""));			
			list.add(sondaSearch);
		}	
		if(list.size() > 0){
			sondaAction.indexaSondaList(list);
		}		
	}
	
	private String generateComandsRandom(){
		String comands = "LRM";
		StringBuilder comand = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 6; i++){			
			int indice = random.nextInt(3);
			comand.append(String.valueOf(comands.charAt(indice)));
		}
		return StringUtils.trimAllWhitespace(comand.toString()).toUpperCase();
	}
	
	private String chooseRandomPlanalto(){
		Random random = new Random();
		List<String> planaltos = Arrays.asList("Júpiter", "Marte", "Netuno", "Saturno", "Urano", "Plutão","Vênus");
		return planaltos.get(random.nextInt(7));
	}
	
	private Direction chooseRandomDirection(){
		Random random = new Random();
		Direction[] directions = Direction.values();
		return directions[random.nextInt(4)];
	}
	
	private Planalto generatePlanaltoRandom(){
		Random random = new Random();
		int coordenadaLimitY = random.nextInt(10);
		int coordenadaLimitX = random.nextInt(10);
		Planalto planalto = new Planalto(chooseRandomPlanalto(), coordenadaLimitX, coordenadaLimitY);		
		return planalto;
	}
	
	private Sonda generateSondaRandom(int index, int maxCoordinateX, int maxCoordinateY){
		Random random = new Random();
		int coordinateX  = random.nextInt(maxCoordinateX+1);
		int coordinateY = random.nextInt(maxCoordinateY+1);		
		Sonda sonda = new Sonda("Sonda"+index, coordinateX, coordinateY, chooseRandomDirection());				
		return sonda;
	}
}