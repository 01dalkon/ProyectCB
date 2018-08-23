package com.ceiba.parking.domain;

import java.time.DayOfWeek;
import java.time.Duration;


import org.springframework.stereotype.Service;

import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.services.impl.RegistroImpl;

@Service
public class VigilanteParqueadero {

	private String TIPO_CARRO = "CARRO";
	private String TIPO_MOTO = "MOTO";
	private int TOTAL_CARROS = 20;
	private int TOTAL_MOTOS = 10;

	private String MENSAJE_CUPOS_CARRO = "Total de cupos agotados para carro";
	private String MENSAJE_CUPOS_MOTO = "Total de cupos agotados para moto";
	private String VALIDA_PLACA = "La placa con letra A no es permitida este día";
	private String VEHICULO_EXISTE = "El vehiculo esta registrado";

	
	
	private RegistroImpl registroImpl;

	public VigilanteParqueadero(RegistroImpl registroImpl) {
		this.registroImpl = registroImpl;
	}
	
	
	// Funciones 
	
	public void fntEntraVehiculo(Registro registro) {
		registroImpl.registrarEntrada(registro);
	}

	public void fntCalcularCobro(Registro registro, double valorDia, double valorHora, double valorAdicional) {
		
		double valorCobrar = valorAdicional;
		double horas = Duration.between(registro.getFechaEntrada(), registro.getFechaSalida()).toHours();

		if (horas == 0) {
			horas++;
		}
		double dias = Math.round(horas / 24);
		int diasCompletos = (int) dias;
		int horasRestantes = (int) (horas - (diasCompletos * 24));

		if (horasRestantes >= 9) {
			diasCompletos++;
			horasRestantes = 0;
		}
		valorCobrar += diasCompletos * valorDia;
		valorCobrar += horasRestantes * valorHora;

		registro.setValor(valorCobrar);
	}

	public void fntValidacionCupos(Registro registro) {
		long cantidadVehiculos = registroImpl.contarCupos(registro.getTipo(), registro.getTipoRegistro());

		if (registro.getTipo().equals(TIPO_CARRO) && cantidadVehiculos >= TOTAL_CARROS) {
			throw new Excepcion(MENSAJE_CUPOS_CARRO);
		}

		if (registro.getTipo().equals(TIPO_MOTO) && cantidadVehiculos >= TOTAL_MOTOS) {
			throw new Excepcion(MENSAJE_CUPOS_MOTO);
		}
	}

	public void fntValidaPlaca(Registro registro) {

		if (registro.getPlaca().toUpperCase().startsWith("A")
				&& registro.getFechaEntrada().getDayOfWeek() == DayOfWeek.SUNDAY
				|| registro.getFechaEntrada().getDayOfWeek() == DayOfWeek.MONDAY) {
			throw new Excepcion(VALIDA_PLACA);

		}
	}

	public void fntBuscarVehiculo(Registro registro) {
		if (registroImpl.findByPlaca(registro.getPlaca()) != null) {
			throw new Excepcion(VEHICULO_EXISTE);
		}
	}
}