package com.ceiba.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.services.IRegistroService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class RegistroRestController {

	@Autowired
	private IRegistroService registroService;
	
	@Autowired
	VigilanteParqueadero vigilante;
	
	@GetMapping(value = "/listavehiculo")
	public List<RegistroEntity> index(){
		return registroService.findAll();
	}
	
	@GetMapping("/buscarid/{id}")
	public RegistroEntity show(@PathVariable Long id) {
		return registroService.findById(id);
	}
	
	@GetMapping("/buscarplaca/{placa}")
	public RegistroEntity buscarPorPlaca(@PathVariable String placa) {
		return registroService.findByPlaca(placa);
	}
	
	@PostMapping("/ingresovehiculo")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroEntity ingresaRegistro(@RequestBody RegistroEntity registro) {
		return registroService.save(registro);		
	}
	
	@PutMapping("/salidavehiculo/{placa}")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroEntity salidaVehiculo(@PathVariable String placa) {
		RegistroEntity registroVehiculoActual = registroService.findByPlaca(placa);
		return registroService.save(registroVehiculoActual);		
	}
	
	@PutMapping("/actualizaregistro/{id}")
	public RegistroEntity actualizaRegistro(@RequestBody RegistroEntity registroVigilanteEntity,@PathVariable Long id ) {
		
		RegistroEntity registroVehiculoActual = registroService.findById(id);
		
		registroVehiculoActual.setPlaca(registroVigilanteEntity.getPlaca());
		registroVehiculoActual.setTipo(registroVigilanteEntity.getTipo());
		registroVehiculoActual.setCilindraje(registroVigilanteEntity.getCilindraje());
		registroVehiculoActual.setEspacio(registroVigilanteEntity.getEspacio());	
		registroVehiculoActual.setFechaEntrada(registroVigilanteEntity.getFechaEntrada());
		registroVehiculoActual.setFechaSalida(registroVigilanteEntity.getFechaSalida());
		
		return registroService.save(registroVehiculoActual);
	}
	
	@DeleteMapping("/eliminaregistro/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void registroVigilanteEntity(@PathVariable Long id) {
		registroService.fntDeleteRegistro(id);
	}
}
