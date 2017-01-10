package br.com.toyoda.elo7.search;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.search.document.SondaSearch;
import br.com.toyoda.elo7.search.exception.SearchException;
import br.com.toyoda.elo7.search.indexer.SondaIndexer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SondaSearchTest {

	@Autowired
	private SondaIndexer sondaIndexer;
	
	@Test
	public void mustIndexerDocumentSonda() throws SearchException {
		String[] orientation = {"L","M","L","M","L","M","L","M","M"};
		SondaSearch sonda = new SondaSearch("Marte", "Sonda01", "A Sonda01 estava inicialmente localizada em 1,2 na direcao North", orientation);
		boolean indexerSonda = sondaIndexer.indexerSonda(sonda, 1, 3, Direction.NORTH.name());
		Assert.assertTrue(indexerSonda);		
	}
	
	@Test(expected = SearchException.class)
	public void mustThrowErrorFieldRequiredNullIndexerSonda() throws SearchException {
		String[] orientation = {"L","M","L","M","L","M","L","M","M"};
		SondaSearch sonda = new SondaSearch("Marte", "Sonda01", "A Sonda01 estava inicialmente localizada em 1,2 na direcao North", orientation);
		boolean indexerSonda = sondaIndexer.indexerSonda(sonda, null, null, null);
		Assert.assertFalse(indexerSonda);
	}
}
