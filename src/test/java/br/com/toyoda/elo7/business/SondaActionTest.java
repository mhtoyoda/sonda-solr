package br.com.toyoda.elo7.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SondaActionTest {

	@Autowired
	private SondaAction sondaAction;
	
	@Test
	public void executeComandsTest() {
		Planalto marte = new Planalto(5, 5);
		Sonda sondaA = new Sonda("sondaA", 1, 2, Direction.NORTH);
		Sonda sondaB = new Sonda("sondaB", 3, 3, Direction.EAST);
		
		String comandToSondaA = "LMLMLMLMM";
		String comandToSondaB = "MMRMMRMRRM";
		
		sondaA = sondaAction.executeComands(marte, sondaA, comandToSondaA);
		sondaB = sondaAction.executeComands(marte, sondaB, comandToSondaB);
		
		Assert.assertEquals(1, sondaA.getCoordinateX());
		Assert.assertEquals(3, sondaA.getCoordinateY());
		Assert.assertEquals(Direction.NORTH, sondaA.getDirection());
		
		Assert.assertEquals(5, sondaB.getCoordinateX());
		Assert.assertEquals(1, sondaB.getCoordinateY());
		Assert.assertEquals(Direction.EAST, sondaB.getDirection());
		
	}
}
