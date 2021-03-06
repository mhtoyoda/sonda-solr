package br.com.toyoda.elo7.search.document;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.common.util.DateUtil;
import org.springframework.data.annotation.Id;

import br.com.toyoda.elo7.model.Sonda;

public class SondaSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432093062178327871L;

	@Id
	@Field(value = "id")
	private Long id;
	
	@Field(value = "sonda")
	private String sonda;
	
	@Field(value = "sondaPositionCurrent_txt")
	private String positionCurrent;
	
	@Field(value = "planalto")
	private String planalto;
	
	@Field(value = "orientation_ss")
	private String[] orientation;
	
	@Field(value = "coordinateX")
	private Integer coordinateX;
	
	@Field(value = "coordinateY")
	private Integer coordinateY;
	
	@Field(value = "direction")
	private String direction;
	
	@Field(value = "dateAction_dt")
	private String dateAction;
	
	public SondaSearch(){}
		
	public SondaSearch(String planalto, Sonda sonda, String positionCurrent, String[] orientation) {
		this.id = new Random().nextLong();
		this.planalto = planalto;
		this.sonda = sonda.getIdentificacao();
		this.positionCurrent = positionCurrent;
		this.coordinateX = sonda.getCoordinateX();
		this.coordinateY = sonda.getCoordinateY();
		this.direction = sonda.getDirection().name();
		this.orientation = orientation;
		this.dateAction = DateUtil.getThreadLocalDateFormat().format(new Date());
	}

	public Long getId() {
		return id;
	}

	public String getSonda() {
		return sonda;
	}

	public String getPlanalto() {
		return planalto;
	}

	public String[] getOrientation() {
		return orientation;
	}

	public Integer getCoordinateX() {
		return coordinateX;
	}

	public Integer getCoordinateY() {
		return coordinateY;
	}

	public String getDirection() {
		return direction;
	}

	public String getDateAction() {
		return dateAction;
	}

	public String getPositionCurrent() {
		return positionCurrent;
	}

}