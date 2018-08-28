package com.ceiba.parking.domain;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

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

	private double valorDiaCarro = 8000;
	private double valorHoraCarro = 1000;

	private double valorDiaMoto = 4000;
	private double valorHoraMoto = 500;

	private double valorAdicional = 2000;

	private int totalHorasDia = 24;
	private int totalHorasCobroDia = 9;


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

		double dias = Math.round(horas / totalHorasDia);
		int diasCompletos = (int) dias;
		int horasRestantes = (int) (horas - (diasCompletos * totalHorasDia));

		if (horasRestantes >= totalHorasCobroDia) {
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

	public String getTIPO_CARRO() {
		return TIPO_CARRO;
	}

	public void setTIPO_CARRO(String tIPO_CARRO) {
		TIPO_CARRO = tIPO_CARRO;
	}

	public String getTIPO_MOTO() {
		return TIPO_MOTO;
	}

	public void setTIPO_MOTO(String tIPO_MOTO) {
		TIPO_MOTO = tIPO_MOTO;
	}

	public int getTOTAL_CARROS() {
		return TOTAL_CARROS;
	}

	public void setTOTAL_CARROS(int tOTAL_CARROS) {
		TOTAL_CARROS = tOTAL_CARROS;
	}

	public int getTOTAL_MOTOS() {
		return TOTAL_MOTOS;
	}

	public void setTOTAL_MOTOS(int tOTAL_MOTOS) {
		TOTAL_MOTOS = tOTAL_MOTOS;
	}

	public String getMENSAJE_CUPOS_CARRO() {
		return MENSAJE_CUPOS_CARRO;
	}

	public void setMENSAJE_CUPOS_CARRO(String mENSAJE_CUPOS_CARRO) {
		MENSAJE_CUPOS_CARRO = mENSAJE_CUPOS_CARRO;
	}

	public String getMENSAJE_CUPOS_MOTO() {
		return MENSAJE_CUPOS_MOTO;
	}

	public void setMENSAJE_CUPOS_MOTO(String mENSAJE_CUPOS_MOTO) {
		MENSAJE_CUPOS_MOTO = mENSAJE_CUPOS_MOTO;
	}

	public String getVALIDA_PLACA() {
		return VALIDA_PLACA;
	}

	public void setVALIDA_PLACA(String vALIDA_PLACA) {
		VALIDA_PLACA = vALIDA_PLACA;
	}

	public String getVEHICULO_EXISTE() {
		return VEHICULO_EXISTE;
	}

	public void setVEHICULO_EXISTE(String vEHICULO_EXISTE) {
		VEHICULO_EXISTE = vEHICULO_EXISTE;
	}

	public double getValorDiaCarro() {
		return valorDiaCarro;
	}

	public void setValorDiaCarro(double valorDiaCarro) {
		this.valorDiaCarro = valorDiaCarro;
	}

	public double getValorHoraCarro() {
		return valorHoraCarro;
	}

	public void setValorHoraCarro(double valorHoraCarro) {
		this.valorHoraCarro = valorHoraCarro;
	}

	public double getValorDiaMoto() {
		return valorDiaMoto;
	}

	public void setValorDiaMoto(double valorDiaMoto) {
		this.valorDiaMoto = valorDiaMoto;
	}

	public double getValorHoraMoto() {
		return valorHoraMoto;
	}

	public void setValorHoraMoto(double valorHoraMoto) {
		this.valorHoraMoto = valorHoraMoto;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public int getTotalHorasDia() {
		return totalHorasDia;
	}

	public void setTotalHorasDia(int totalHorasDia) {
		this.totalHorasDia = totalHorasDia;
	}

	public int getTotalHorasCobroDia() {
		return totalHorasCobroDia;
	}

	public void setTotalHorasCobroDia(int totalHorasCobroDia) {
		this.totalHorasCobroDia = totalHorasCobroDia;
	}
	
	

	
}