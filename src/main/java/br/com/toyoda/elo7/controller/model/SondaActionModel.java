package br.com.toyoda.elo7.controller.model;

import java.io.Serializable;

import br.com.toyoda.elo7.direction.Direction;

public class SondaActionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014562187415403869L;

	private String planaltoNome;
	private int planaltoCoordenadaLimitX;
	private int planaltoCoordenadaLimitY;

	private String identificacaoSonda1;
	private int coordinateXSonda1;
	private int coordinateYSonda1;
	private Direction directionSonda1;
	private String comandSonda1;

	private String identificacaoSonda2;
	private int coordinateXSonda2;
	private int coordinateYSonda2;
	private Direction directionSonda2;
	private String comandSonda2;

	public String getPlanaltoNome() {
		return planaltoNome;
	}

	public void setPlanaltoNome(String planaltoNome) {
		this.planaltoNome = planaltoNome;
	}

	public int getPlanaltoCoordenadaLimitX() {
		return planaltoCoordenadaLimitX;
	}

	public void setPlanaltoCoordenadaLimitX(int planaltoCoordenadaLimitX) {
		this.planaltoCoordenadaLimitX = planaltoCoordenadaLimitX;
	}

	public int getPlanaltoCoordenadaLimitY() {
		return planaltoCoordenadaLimitY;
	}

	public void setPlanaltoCoordenadaLimitY(int planaltoCoordenadaLimitY) {
		this.planaltoCoordenadaLimitY = planaltoCoordenadaLimitY;
	}

	public String getIdentificacaoSonda1() {
		return identificacaoSonda1;
	}

	public void setIdentificacaoSonda1(String identificacaoSonda1) {
		this.identificacaoSonda1 = identificacaoSonda1;
	}

	public int getCoordinateXSonda1() {
		return coordinateXSonda1;
	}

	public void setCoordinateXSonda1(int coordinateXSonda1) {
		this.coordinateXSonda1 = coordinateXSonda1;
	}

	public int getCoordinateYSonda1() {
		return coordinateYSonda1;
	}

	public void setCoordinateYSonda1(int coordinateYSonda1) {
		this.coordinateYSonda1 = coordinateYSonda1;
	}

	public Direction getDirectionSonda1() {
		return directionSonda1;
	}

	public void setDirectionSonda1(Direction directionSonda1) {
		this.directionSonda1 = directionSonda1;
	}

	public String getComandSonda1() {
		return comandSonda1;
	}

	public void setComandSonda1(String comandSonda1) {
		this.comandSonda1 = comandSonda1;
	}

	public String getIdentificacaoSonda2() {
		return identificacaoSonda2;
	}

	public void setIdentificacaoSonda2(String identificacaoSonda2) {
		this.identificacaoSonda2 = identificacaoSonda2;
	}

	public int getCoordinateXSonda2() {
		return coordinateXSonda2;
	}

	public void setCoordinateXSonda2(int coordinateXSonda2) {
		this.coordinateXSonda2 = coordinateXSonda2;
	}

	public int getCoordinateYSonda2() {
		return coordinateYSonda2;
	}

	public void setCoordinateYSonda2(int coordinateYSonda2) {
		this.coordinateYSonda2 = coordinateYSonda2;
	}

	public Direction getDirectionSonda2() {
		return directionSonda2;
	}

	public void setDirectionSonda2(Direction directionSonda2) {
		this.directionSonda2 = directionSonda2;
	}

	public String getComandSonda2() {
		return comandSonda2;
	}

	public void setComandSonda2(String comandSonda2) {
		this.comandSonda2 = comandSonda2;
	}

}