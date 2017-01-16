package br.com.toyoda.elo7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.toyoda.elo7.business.IndexBatch;
import br.com.toyoda.elo7.search.exception.SearchException;

@SpringBootApplication
public class SondaSolrApplication {
	
	private final static Logger log = LoggerFactory.getLogger(SondaSolrApplication.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SondaSolrApplication.class, args);
		try {
			context.getBean(IndexBatch.class).generateDataRandom(1000);
		} catch (BeansException | SearchException e) {
			log.error("Erro ao indexar full: "+e.getMessage());
		}
	}
}
