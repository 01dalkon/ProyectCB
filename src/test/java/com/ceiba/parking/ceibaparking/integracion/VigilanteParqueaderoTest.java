package com.ceiba.parking.ceibaparking.integracion;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.parking.CeibaParkingApplication;
import com.ceiba.parking.ceibaparking.testdatabuilder.RegistroTestDataBuilder;
import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.repository.IRegistroRepository;
import com.ceiba.parking.services.impl.RegistroImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { VigilanteParqueadero.class, CeibaParkingApplication.class })
public class VigilanteParqueaderoTest {

	@Autowired
	RegistroImpl registroImpl;

	@Autowired
	IRegistroRepository iRegistroRepository;

	@Before
	public void before() {
		iRegistroRepository.deleteAll();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIngresarNuevoCarro() {
		
		Registro registro = new RegistroTestDataBuilder().setPlaca("CBA-123").setTipo("CARRO").setTipoRegistro("ENTRADA").build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntEntraVehiculo(registro);
		
		Assert.assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro()));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIngresarNuevaMoto() {
		
		Registro registro = new RegistroTestDataBuilder().setPlaca("CBA-123").setTipo("MOTO").setTipoRegistro("ENTRADA").build();

		VigilanteParqueadero vigilanteParqueadero = new VigilanteParqueadero(registroImpl);

		vigilanteParqueadero.fntEntraVehiculo(registro);
		
		Assert.assertNotNull(registroImpl.buscarPorPlacaTipoRegistro(registro.getPlaca(), registro.getTipoRegistro()));
	}
		
}
