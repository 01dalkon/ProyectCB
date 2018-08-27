package com.ceiba.parking.ceibaparking.unitarias;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.parking.ceibaparking.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.services.impl.RegistroImpl;

public class VigilanteParqueaderoTest {

	private static String PLACA = "HIS-63E";
	private static String TIPO = "MOTO";
	private static String TIPO_REGISTRO = "ENTRADA";
	private static int CILINDRAJE = 200;
	private static LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static double VALOR = 2000;

	
	@Test
	public void testFntCrearRegistroTest() {

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
	public void testFntCalcularCobro() {
		Registro registro = new RegistroTestDataBuilder().setTipo("CARRO").setFechaEntrada(LocalDateTime.parse("2018-08-27T07:00:00")).setFechaSalida(LocalDateTime.parse("2018-08-27T08:00:00")).build();
		
		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero();
		
		vigilanteParqueadero.fntCalcularCobro(registro, 8000, 1000, 0);
		Assert.assertEquals(1000, (long)registro.getValor());
	}
	
	@Test
	public void testFntCalcularCobroMayor9Horas() {
		Registro registro = new RegistroTestDataBuilder().setTipo("CARRO").setFechaEntrada(LocalDateTime.parse("2018-08-27T07:00:00")).setFechaSalida(LocalDateTime.parse("2018-08-27T18:00:00")).build();
		
		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero();
		
		vigilanteParqueadero.fntCalcularCobro(registro, 8000, 1000, 0);
		Assert.assertEquals(8000, (long)registro.getValor());
	}

	@Test
	public void testFntValidacionCuposCarro() {
		
		Registro registro = new RegistroTestDataBuilder().setTipo("CARRO").build();

		RegistroImpl registroImp = mock(RegistroImpl.class);

		when(registroImp.contarCupos(registro.getTipo(), registro.getTipoRegistro())).thenReturn((long)21);

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImp);
		
		try {
			vigilanteParqueadero.fntValidacionCupos(registro);
		} catch (Exception e) {
			assertEquals(vigilanteParqueadero.MENSAJE_CUPOS_CARRO, e.getMessage());
		}
		
	}
	
	@Test
	public void testFntValidacionCuposMoto() {
		
		Registro registro = new RegistroTestDataBuilder().setTipo("MOTO").build();

		RegistroImpl registroImp = mock(RegistroImpl.class);

		when(registroImp.contarCupos(registro.getTipo(), registro.getTipoRegistro())).thenReturn((long)11);

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImp);

		try {
			vigilanteParqueadero.fntValidacionCupos(registro);
		} catch (Exception e) {
			Assert.assertEquals(vigilanteParqueadero.MENSAJE_CUPOS_MOTO, e.getMessage());
		}
	}
	
}
