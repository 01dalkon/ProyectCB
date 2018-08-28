package com.ceiba.parking.domain;

public class Excepcion extends RuntimeException{
	
	private static String TIPO_CARRO = "CARRO";
	private static String TIPO_MOTO = "MOTO";
	private static int TOTAL_CARROS = 20;
	private static int TOTAL_MOTOS = 10;

	private static String MENSAJE_CUPOS_CARRO = "Total de cupos agotados para carro";
	private static String MENSAJE_CUPOS_MOTO = "Total de cupos agotados para moto";
	private static String VALIDA_PLACA = "La placa con letra A no es permitida este día";
	private static String VEHICULO_EXISTE = "El vehiculo esta registrado";


	private static final long serialVersionUID = 1L;

	public Excepcion(String msg) {
		super(msg);
	}
	
	public static String getTIPO_CARRO() {
		return TIPO_CARRO;
	}

	public static void setTIPO_CARRO(String tIPO_CARRO) {
		TIPO_CARRO = tIPO_CARRO;
	}

	public static String getTIPO_MOTO() {
		return TIPO_MOTO;
	}

	public static void setTIPO_MOTO(String tIPO_MOTO) {
		TIPO_MOTO = tIPO_MOTO;
	}

	public static int getTOTAL_CARROS() {
		return TOTAL_CARROS;
	}

	public static void setTOTAL_CARROS(int tOTAL_CARROS) {
		TOTAL_CARROS = tOTAL_CARROS;
	}

	public static int getTOTAL_MOTOS() {
		return TOTAL_MOTOS;
	}

	public static void setTOTAL_MOTOS(int tOTAL_MOTOS) {
		TOTAL_MOTOS = tOTAL_MOTOS;
	}

	public static String getMENSAJE_CUPOS_CARRO() {
		return MENSAJE_CUPOS_CARRO;
	}

	public static void setMENSAJE_CUPOS_CARRO(String mENSAJE_CUPOS_CARRO) {
		MENSAJE_CUPOS_CARRO = mENSAJE_CUPOS_CARRO;
	}

	public static String getMENSAJE_CUPOS_MOTO() {
		return MENSAJE_CUPOS_MOTO;
	}

	public static void setMENSAJE_CUPOS_MOTO(String mENSAJE_CUPOS_MOTO) {
		MENSAJE_CUPOS_MOTO = mENSAJE_CUPOS_MOTO;
	}

	public static String getVALIDA_PLACA() {
		return VALIDA_PLACA;
	}

	public static void setVALIDA_PLACA(String vALIDA_PLACA) {
		VALIDA_PLACA = vALIDA_PLACA;
	}

	public static String getVEHICULO_EXISTE() {
		return VEHICULO_EXISTE;
	}

	public static void setVEHICULO_EXISTE(String vEHICULO_EXISTE) {
		VEHICULO_EXISTE = vEHICULO_EXISTE;
	}
}
