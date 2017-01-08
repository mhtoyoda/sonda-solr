package br.com.toyoda.elo7.business;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

@Component
public class SondaAction {
	
	public Sonda executeComands(Planalto planalto, Sonda sonda, String comand){
		String comands = StringUtils.trimAllWhitespace(comand).toUpperCase();
		for(int index = 0; index < comands.length(); index++){
			String instruction = String.valueOf(comands.charAt(index));
			sonda = move(planalto, sonda, instruction);
		}
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
}