package com.ceiba.parking.domain;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ceiba.parking.services.impl.RegistroImpl;

@Service
public class VigilanteParqueadero {

	private static final String  TIPO_CARRO = "CARRO";
	private static final String TIPO_MOTO = "MOTO";
	private static final int TOTAL_CARROS = 20;
	private static final int TOTAL_MOTOS = 10;

	private static final String MENSAJE_CUPOS_CARRO = "Total de cupos agotados para carro";
	private static final String MENSAJE_CUPOS_MOTO = "Total de cupos agotados para moto";
	private static final String VALIDA_PLACA = "La placa con letra A no es permitida este día";
	private static final String VEHICULO_EXISTE = "El vehiculo esta registrado";

	private double valorDiaCarro = 8000;
	private double valorHoraCarro = 1000;

	private double valorDiaMoto = 4000;
	private double valorHoraMoto = 500;

	private double valorAdicional = 2000;

	private static final int TOTAL_HORAS_DEL_DIA = 24;
	private static final int TOTAL_HORAS_COBRO_X_DIA = 9;


	private RegistroImpl registroImpl;
	
	public VigilanteParqueadero(RegistroImpl registroImpl) {
		this.registroImpl = registroImpl;
	}

	public void fntEntraVehiculo(Registro registro) {

			try {
				
				fntBuscarVehiculoExiste(registro);

				fntValidacionCupos(registro);

				fntValidaPlaca(registro);

				registroImpl.registrarEntrada(registro);
				
			} catch (Exception e) {
				throw e;
			}

	}

	public void fntSalidaVehiculo(String placa) {

		try {
		Registro registro = registroImpl.buscarPorPlacaTipoRegistro(placa, "ENTRADA");
		registro.setFechaSalida(LocalDateTime.now());

		if (registro.getTipo().equals(TIPO_CARRO)) {
			fntCalcularCobro(registro, valorDiaCarro, valorHoraCarro, 0);
		} else {
			fntCalcularCobro(registro, valorDiaMoto, valorHoraMoto, valorAdicional);
		}

		registroImpl.registrarSalida(registro);

		} catch (Exception e) {
			throw e;
		}
	}

	public void fntCalcularCobro(Registro registro, double valorDia, double valorHora, double valorAdicional) {

		double valorCobrar = 0;
		double horas = Duration.between(registro.getFechaEntrada(), registro.getFechaSalida()).toHours();

		if (horas == 0) {
			horas++;
		}

		double dias = Math.round(horas / TOTAL_HORAS_DEL_DIA);
		int diasCompletos = (int) dias;
		int horasRestantes = (int) (horas - (diasCompletos * TOTAL_HORAS_DEL_DIA));

		if (horasRestantes >= TOTAL_HORAS_COBRO_X_DIA) {
			diasCompletos++;
			horasRestantes = 0;
		}
		valorCobrar += diasCompletos * valorDia;
		valorCobrar += horasRestantes * valorHora;
		
		if (registro.getCilindraje()>=500) {
			valorCobrar += valorAdicional;
		}
		
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
				&& registro.getFechaEntrada().getDayOfWeek() != DayOfWeek.SUNDAY
				&& registro.getFechaEntrada().getDayOfWeek() != DayOfWeek.MONDAY) {
			throw new Excepcion(VALIDA_PLACA);
		}
	}

	public void fntBuscarVehiculoExiste(Registro registro) {
		if (registroImpl.registroExiste(registro.getPlaca(), "ENTRADA") != null) {
			throw new Excepcion(VEHICULO_EXISTE);
		}
	}

	public String getVehiculoExiste() {
		return VEHICULO_EXISTE;
	}

	public double getValorDiaCarro() {
		return valorDiaCarro;
	}

	public double getValorHoraCarro() {
		return valorHoraCarro;
	}

	public double getValorDiaMoto() {
		return valorDiaMoto;
	}

	public double getValorHoraMoto() {
		return valorHoraMoto;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public String getMensajeCuposCarro() {
		return MENSAJE_CUPOS_CARRO;
	}

	public String getMensajeCuposMoto() {
		return MENSAJE_CUPOS_MOTO;
	}

	public String getValidaPlaca() {
		return VALIDA_PLACA;
	}

	public void setValorDiaCarro(double valorDiaCarro) {
		this.valorDiaCarro = valorDiaCarro;
	}

	public void setValorHoraCarro(double valorHoraCarro) {
		this.valorHoraCarro = valorHoraCarro;
	}

	public void setValorDiaMoto(double valorDiaMoto) {
		this.valorDiaMoto = valorDiaMoto;
	}

	public void setValorHoraMoto(double valorHoraMoto) {
		this.valorHoraMoto = valorHoraMoto;
	}

	
	
}