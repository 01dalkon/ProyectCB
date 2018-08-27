package com.ceiba.parking.ceibaparking.unitarias;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import com.ceiba.parking.ceibaparking.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.services.impl.RegistroImpl;

public class VigilanteParqueaderoTest {
	
	private static String PLACA = "HIS-63E";
	private static String TIPO = "MOTO";
	private  static String TIPO_REGISTRO = "ENTRADA";
	private static int CILINDRAJE = 200;
	private static LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static double VALOR = 2000;
	
	
	@Test
	public void fntCrearRegistroTest() {
		
		RegistroTestDataBuilder builder = new RegistroTestDataBuilder();
		builder.setPlaca(PLACA);
		builder.setTipo(TIPO);
		builder.setTipoRegistro(TIPO_REGISTRO);
		builder.setCilindraje(CILINDRAJE);
		builder.setFechaEntrada(FECHA_ENTRADA);
		builder.setFechaSalida(FECHA_SALIDA);
		builder.setValor(VALOR);
		
		Registro registro = builder.build();
		
		assertEquals(PLACA, registro.getPlaca());	
	}

	@Test
	public void testVigilanteParqueadero() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntEntraVehiculo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntSalidaVehiculo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntCalcularCobro() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntValidacionCupos() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntValidaPlaca() {
		fail("Not yet implemented");
	}

	@Test
	public void testFntBuscarVehiculoExisteCarro() {
		Registro registro = new RegistroTestDataBuilder("CARRO").build();
		
		RegistroImpl registroImp = mock (RegistroImpl.class);
		
		when(registroImp.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro())).thenReturn(registro);
		
		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImp);
		
		vigilanteParqueadero.fntBuscarVehiculoExiste(registro);
		
	}
	
	@Test
	public void testFntBuscarVehiculoExisteMoto() {
		Registro registro = new RegistroTestDataBuilder("MOTO").build();
		
		RegistroImpl registroImp = mock (RegistroImpl.class);
		
		when(registroImp.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro())).thenReturn(registro);
		
		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImp);
		
		vigilanteParqueadero.fntBuscarVehiculoExiste(registro);
		
	}

}
