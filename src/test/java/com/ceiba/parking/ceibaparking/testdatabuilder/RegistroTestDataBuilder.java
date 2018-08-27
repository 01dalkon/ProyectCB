package com.ceiba.parking.ceibaparking.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.parking.domain.Registro;

public class RegistroTestDataBuilder {
	
	//private static final String String = null;
	private static final String PLACA = "HIS-63E";
	private static final String TIPO = "MOTO";
	private  static final String TIPO_REGISTRO = "ENTRADA";
	private static final int CILINDRAJE = 200;
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static final double VALOR = 2000;
	
	
	private String placa;
	private String tipo;
	private String tipoRegistro;
	private int cilindraje;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private double valor;
	
	public RegistroTestDataBuilder() {
		this.placa= PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
		this.tipoRegistro = TIPO_REGISTRO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.valor = VALOR;
	}
	
	public RegistroTestDataBuilder(String tipo) {
		this.placa= PLACA;
		this.tipo = TIPO;
		this.fechaEntrada = FECHA_ENTRADA;
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
	
	public Registro build() {
		
		if (this.tipo.equals("MOTO")) {
			return new Registro(this.placa, this.tipo, this.tipoRegistro, this.cilindraje, this.fechaEntrada,
					this.fechaSalida, this.valor);
		}
		
		if (this.tipo.equals("CARRO")) {
			return new Registro(this.placa, this.tipo, this.tipoRegistro, this.fechaEntrada,
					this.fechaSalida, this.valor);
		}
		return new Registro(this.placa, this.tipo, this.tipoRegistro, this.fechaEntrada, this.fechaSalida,
				this.valor);
	}
		
}
