package com.ceiba.parking.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.parking.entity.RegistroVigilanteEntity;
import com.ceiba.parking.repository.IRegistroVehiculoRepository;
import com.ceiba.parking.services.RegistroVehiculoServiceImpl;

import excepcion.ExceptionVehiculoRegistro;

public class VigilanteParqueadero {

	private String VALIDAR_LETAR_A = "La Placa ingresada inicia por la letra A";

	private String moto = "M";
	private String carro = "C";
	private int valorHoraCarro = 1000;
	private int valorHoraMoto = 500;
	private int valorDiaCarro = 8000;
	private int valorDiaMoto = 4000;
	private int totalCapacidadMoto = 10;
	private int totalCapacidadCarro = 20;
	private String letraPlacaA = "A";
	private String tipoVehiculo;

	@Autowired
	private RegistroVehiculoServiceImpl registroVehiculoServiceImpl;
	
	private IRegistroVehiculoRepository repositoryRegistroVehiculo;
		
	//public VigilanteParqueadero(IRegistroVehiculoRepository repositoryRegistroVehiculo) {
	//	this.repositoryRegistroVehiculo = repositoryRegistroVehiculo;
	//}

	// Metodooooo
	public void fntGuardarRegistroVigilante(RegistroVigilanteEntity registroVigilanteEntity) {
	}

	public void fntRegistrarEntradaSalida() {

	}

	public void fntCalcularTiempo() {

	}

	public void fntCalcularValor() {

	}

	public void fntValidarCapacidad() {

	}

	public void fntValidarLetraPlaca(String placa) {
		char letra = placa.charAt(0);
		if (String.valueOf(letra).equals(letraPlacaA)) {
			throw new ExceptionVehiculoRegistro(VALIDAR_LETAR_A);
		}
	}

	public boolean fntValidarCilindrajeMoto() {
		int cilindraje = 0;
		if (cilindraje >= 500 && tipoVehiculo.equals(moto)) {
			return true;
		} else {
			return false;
		}
	}

	// Getters and Setters

	public int getValorHoraCarro() {
		return valorHoraCarro;
	}

	public void setValorHoraCarro(int valorHoraCarro) {
		this.valorHoraCarro = valorHoraCarro;
	}

	public int getValorHoraMoto() {
		return valorHoraMoto;
	}

	public void setValorHoraMoto(int valorHoraMoto) {
		this.valorHoraMoto = valorHoraMoto;
	}

	public int getValorDiaCarro() {
		return valorDiaCarro;
	}

	public void setValorDiaCarro(int valorDiaCarro) {
		this.valorDiaCarro = valorDiaCarro;
	}

	public int getValorDiaMoto() {
		return valorDiaMoto;
	}

	public void setValorDiaMoto(int valorDiaMoto) {
		this.valorDiaMoto = valorDiaMoto;
	}

	public int getTotalCapacidadMoto() {
		return totalCapacidadMoto;
	}

	public void setTotalCapacidadMoto(int totalCapacidadMoto) {
		this.totalCapacidadMoto = totalCapacidadMoto;
	}

	public int getTotalCapacidadCarro() {
		return totalCapacidadCarro;
	}

	public void setTotalCapacidadCarro(int totalCapacidadCarro) {
		this.totalCapacidadCarro = totalCapacidadCarro;
	}

	public RegistroVehiculoServiceImpl getRegistroVehiculoServiceImpl() {
		return registroVehiculoServiceImpl;
	}

	public void setRegistroVehiculoServiceImpl(RegistroVehiculoServiceImpl registroVehiculoServiceImpl) {
		this.registroVehiculoServiceImpl = registroVehiculoServiceImpl;
	}

	public String getLetraPlacaA() {
		return letraPlacaA;
	}

	public void setLetraPlacaA(String letraPlacaA) {
		this.letraPlacaA = letraPlacaA;
	}
}
