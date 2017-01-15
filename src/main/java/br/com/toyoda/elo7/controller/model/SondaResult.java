package br.com.toyoda.elo7.controller.model;

import java.io.Serializable;

import br.com.toyoda.elo7.model.Sonda;

public class SondaResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Sonda sonda1;
	
	private Sonda sonda2;

	public SondaResult(Sonda sonda1, Sonda sonda2) {
		this.sonda1 = sonda1;
		this.sonda2 = sonda2;
	}

	public Sonda getSonda1() {
		return sonda1;
	}

	public void setSonda1(Sonda sonda1) {
		this.sonda1 = sonda1;
	}

	public Sonda getSonda2() {
		return sonda2;
	}

	public void setSonda2(Sonda sonda2) {
		this.sonda2 = sonda2;
	}
	
}
