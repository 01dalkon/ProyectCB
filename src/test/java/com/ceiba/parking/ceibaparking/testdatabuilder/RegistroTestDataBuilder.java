package com.ceiba.parking.ceibaparking.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.parking.domain.Registro;

public class RegistroTestDataBuilder {
	
	//private static final String String = null;
	private static final String PLACA = "LFJ-63B";
	private static final String TIPO = "MOTO";
	private  static final String TIPO_REGISTRO = "ENTRADA";
	private static final int CILINDRAJE = 200;
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static final double VALOR = 2000;
	
	
	 String placa;
	 String tipo;
	 String tipoRegistro;
	 int cilindraje;
	 LocalDateTime fechaEntrada;
	 LocalDateTime fechaSalida;
	 double valor;
	
	public RegistroTestDataBuilder() {
		this.placa= PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
		this.tipoRegistro = TIPO_REGISTRO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.valor = VALOR;
	}
		

	public RegistroTestDataBuilder setPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public RegistroTestDataBuilder setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public RegistroTestDataBuilder setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
		return this;
	}

	public RegistroTestDataBuilder setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public RegistroTestDataBuilder setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public RegistroTestDataBuilder setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public RegistroTestDataBuilder setValor(double valor) {
		this.valor = valor;
		return this;
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
