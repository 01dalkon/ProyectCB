package com.ceiba.parking.ceibaparking.testdatabuilder;

import java.time.LocalDateTime;

public class RegistroTestDataBuilder {
	
	private static String PLACA = "HIS-63E";
	private static String TIPO = "MOTO";
	private  static String TIPO_REGISTRO = "ENTRADA";
	private static int CILINDRAJE = 200;
	private static LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static double VALOR = 2000;
	
	
	private String placa;
	private String tipo;
	private String tipoRegistro;
	private int cilindraje;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private double valor;
	
	public RegistroTestDataBuilder() {
		this.placa= PLACA;
		this.fechaEntrada = FECHA_ENTRADA;
	}
	
	public RegistroTestDataBuilder(String tipoRegistro) {
		this.placa = PLACA;
		this.fechaEntrada = FECHA_ENTRADA;
		this.tipoRegistro = TIPO_REGISTRO;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	

		
}
