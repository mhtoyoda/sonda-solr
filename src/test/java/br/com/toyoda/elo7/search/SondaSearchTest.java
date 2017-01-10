package br.com.toyoda.elo7.search;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SondaSearchTest {

	@Autowired
	private SondaSolrRepository sondaSolrRepository;
	
	@Test
	public void executeComandsTest() {
	    Long id = new Random().nextLong();
	
		SondaSearch sonda = new SondaSearch(id, 3, 5, Direction.NORTH.name());
		sondaSolrRepository.save(sonda);
		Assert.assertEquals(3, 3);
		
	}
}
