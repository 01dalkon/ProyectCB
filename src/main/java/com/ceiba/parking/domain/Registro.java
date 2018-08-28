package com.ceiba.parking.domain;

import java.time.LocalDateTime;

public class Registro {

	private String placa;
	private String tipo;
	private String tipoRegistro;
	private int cilindraje;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private double valor;
	
	public Registro() {
	}
	
	public Registro(String placa, String tipo, String tipoRegistro, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, double valor) {
		this.placa = placa;
		this.tipo = tipo;
		this.tipoRegistro = tipoRegistro;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		
	}

	public Registro(String placa, String tipo, String tipoRegistro, int cilindraje, LocalDateTime fechaEntrada, LocalDateTime fechaSalida,
			double valor) {
		this.placa = placa;
		this.tipo = tipo;
		this.tipoRegistro = tipoRegistro;
		this.cilindraje = cilindraje;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
	}

	// Method Setters and Getters
	
	public String getPlaca() {
		return placa;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
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
