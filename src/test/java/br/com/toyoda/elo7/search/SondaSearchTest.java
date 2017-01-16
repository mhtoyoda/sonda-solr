package br.com.toyoda.elo7.search;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.search.document.SondaSearch;
import br.com.toyoda.elo7.search.document.SondaSearchResult;
import br.com.toyoda.elo7.search.exception.SearchException;
import br.com.toyoda.elo7.search.indexer.SondaIndexer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SondaSearchTest {

	@Autowired
	private SondaIndexer sondaIndexer;
	
	@Before
	public void initBefore() throws SearchException{
		String[] orientation = {"L","M","L","M","L","M","L","M","M"};
		SondaSearch sonda = new SondaSearch("Marte", "Sonda01", "A Sonda01 estava inicialmente localizada em 1,2 na direcao North", orientation);
		sondaIndexer.indexerSonda(sonda, 1, 3, Direction.NORTH.name());
	}
	
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
	
	@Test
	public void mustReturnDocumentSondaFacetDirectionFinal() throws SearchException {
		List<String> directions = Arrays.asList(Direction.EAST.name(), Direction.WEST.name(),Direction.NORTH.name(), Direction.SOUTH.name());
		SondaSearchResult sondaSearchResult = sondaIndexer.findSondaDirectionFacet(directions, new PageRequest(0, 10));
		Assert.assertTrue(sondaSearchResult.getResults().size() > 0);
		Assert.assertTrue(sondaSearchResult.getFacetMap().containsKey(Direction.NORTH.name().toLowerCase()));		
	}
	
	@Test
	public void mustReturnDocumentSondaDirectionFinal() throws SearchException {
		String direction = Direction.NORTH.name();
		SondaSearchResult sondaSearchResult = sondaIndexer.findSondaDirection(direction, new PageRequest(0, 10));
		Assert.assertTrue(sondaSearchResult.getResults().size() > 0);
		Assert.assertTrue(sondaSearchResult.getResults().get(0).getDirection().equalsIgnoreCase(Direction.NORTH.name()));		
	}
	
	@Test
	public void findTermOnTextPositionSonda(){
		SondaSearchResult result = sondaIndexer.findSondaPositionText("direcao", new PageRequest(0, 10));
		Assert.assertTrue(result.getResults().size() > 0);	
	}
	
	@Test
	public void findTermOnHighLightSonda(){
		SondaSearchResult result = sondaIndexer.findSondaHighLightTerm("Sonda01", new PageRequest(0, 10));
		Assert.assertTrue(result.getResults().size() > 0);
		result.getHighlights().forEach(item-> {
			Assert.assertTrue(StringUtils.contains(item, "<term-highlight>"));			
		});
	}
}
