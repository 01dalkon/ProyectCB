package com.ceiba.parking.domain;

public class Excepcion extends RuntimeException{
	
	public static String TIPO_CARRO = "CARRO";
	public static String TIPO_MOTO = "MOTO";
	public static int TOTAL_CARROS = 20;
	public static int TOTAL_MOTOS = 10;

	public static String MENSAJE_CUPOS_CARRO = "Total de cupos agotados para carro";
	public static String MENSAJE_CUPOS_MOTO = "Total de cupos agotados para moto";
	public static String VALIDA_PLACA = "La placa con letra A no es permitida este día";
	public static String VEHICULO_EXISTE = "El vehiculo esta registrado";
	
	private static final long serialVersionUID = 1L;

	public Excepcion(String msg) {
		super(msg);
	}
}
