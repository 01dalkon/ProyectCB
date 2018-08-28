package com.ceiba.parking.ceibaparking.integracion;

import static org.junit.Assert.*;

import java.time.LocalDateTime;


import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ceiba.parking.CeibaParkingApplication;
import com.ceiba.parking.ceibaparking.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parking.controllers.RegistroRestController;
import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.repository.IRegistroRepository;
import com.ceiba.parking.services.impl.RegistroImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { VigilanteParqueadero.class, CeibaParkingApplication.class })
public class VigilanteParqueaderoTest {

	@Autowired
	RegistroRestController registroRestController;
	
	@Autowired
	RegistroImpl registroImpl;

	@Autowired
	IRegistroRepository iRegistroRepository;

	@Test
	public void testIngresarNuevaCarro() {

		Registro registro = new RegistroTestDataBuilder().setPlaca("CVA-123").setTipo("CARRO")
				.setTipoRegistro("ENTRADA").build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntEntraVehiculo(registro);

		assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro()));
	}

	@Test
	public void testIngresarNuevaMoto() {

		Registro registro = new RegistroTestDataBuilder().setPlaca("FFP-424").setTipo("MOTO").setTipoRegistro("ENTRADA")
				.build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntEntraVehiculo(registro);

		assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro()));
	}

	@Test
	public void testSalidaVehiculoCarro() {

		Registro registro = new RegistroTestDataBuilder().setTipo("CARRO").setPlaca("CBA-123")
				.setFechaEntrada(LocalDateTime.parse("2018-08-01T07:00:00")).build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntSalidaVehiculo(registro.getPlaca());

		assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), "SALIDA"));
	}

	@Test
	public void testSalidaVehiculoMoto() {

		Registro registro = new RegistroTestDataBuilder().setTipo("MOTO").setPlaca("FFG-424")
				.setFechaEntrada(LocalDateTime.parse("2018-08-01T07:00:00")).build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntSalidaVehiculo(registro.getPlaca());

		assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), "SALIDA"));
	}

	@Test
	public void testRegistroEntradaCarroExiste() {
		
		Registro registro = new RegistroTestDataBuilder().setTipo("CARRO").setPlaca("CBA-123").build();
		
		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);
		
		try {
			vigilanteParqueadero.fntBuscarVehiculoExiste(registro);
		} catch (Exception e) {
			assertEquals(vigilanteParqueadero.getVEHICULO_EXISTE(), e.getMessage());
		}
		
	}
	
	@Test
	public void testConsultarRegistros() {

	int valorEsperado = 3;
	int resultado = registroRestController.index().size();
	assertEquals(resultado, valorEsperado);
	}
	
	@Test
	public void testConsulId() {
		
		RegistroEntity registroEntity = new RegistroEntity();
		registroEntity = registroRestController.show(1L);
		
		assertNotNull(registroEntity);
	}

/*	
	@Test
	public void testEntradaVehiculo() {
		
		Registro registro = new RegistroTestDataBuilder().build();
		
		ResponseEntity<Void> entradaVehiculo = registroRestController.ingresaRegistro(registro);	
		
		assertNotNull(registro);
	}
*/
}
