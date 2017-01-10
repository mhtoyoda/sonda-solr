package br.com.toyoda.elo7.model;

public class Planalto {

	private int coordenadaMinimoX;
	private int coordenadaMinimoY;
	private int coordenadaLimitX;
	private int coordenadaLimitY;

	public Planalto(int coordenadaLimitX, int coordenadaLimitY) {
		this.coordenadaMinimoX = 0;
		this.coordenadaLimitX = coordenadaLimitX;
		this.coordenadaMinimoY = 0;
		this.coordenadaLimitY = coordenadaLimitY;
	}

	public int getCoordenadaMinimoX() {
		return coordenadaMinimoX;
	}

	public int getCoordenadaMinimoY() {
		return coordenadaMinimoY;
	}

	public int getCoordenadaLimitX() {
		return coordenadaLimitX;
	}

	public int getCoordenadaLimitY() {
		return coordenadaLimitY;
	}
}