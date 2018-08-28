package com.ceiba.parking.domain;

public class Excepcion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public Excepcion(String msg) {
		super(msg);
	}

}
