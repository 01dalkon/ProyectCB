package com.ceiba.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.repository.entity.RegistroVigilanteEntity;
import com.ceiba.parking.service.IRegistroVehiculoService;

@RestController
@RequestMapping("/api")
public class RegistroVehiculoRestController {

	@Autowired
	private IRegistroVehiculoService registroVehiculoService;
	
	@GetMapping(value = "/listavigilante")
	public List<RegistroVigilanteEntity> index(){
		return registroVehiculoService.findAll();
	}
	
	@GetMapping("/listavigilante/{id}")
	public RegistroVigilanteEntity show(@PathVariable Long id) {
		return registroVehiculoService.findById(id);
	}
	
	@PostMapping("/listavigilante/")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVigilanteEntity create(@RequestBody RegistroVigilanteEntity registroVigilanteEntity) {
		return registroVehiculoService.save(registroVigilanteEntity);		
	}
	
	@PutMapping("/listavigilante/{id}")
	public RegistroVigilanteEntity update(@RequestBody RegistroVigilanteEntity registroVigilanteEntity,@PathVariable Long id ) {
		RegistroVigilanteEntity registroVehiculoActual = registroVehiculoService.findById(id);
		
		registroVehiculoActual.setPlaca(registroVigilanteEntity.getPlaca());
		registroVehiculoActual.setTipo(registroVigilanteEntity.getTipo());
		registroVehiculoActual.setCilindraje(registroVigilanteEntity.getCilindraje());
		registroVehiculoActual.setEspacio(registroVigilanteEntity.getEspacio());	
		registroVehiculoActual.setFechaEntrada(registroVigilanteEntity.getFechaEntrada());
		registroVehiculoActual.setFechaSalida(registroVigilanteEntity.getFechaSalida());
		
		return registroVehiculoService.save(registroVehiculoActual);
	}
	
	@DeleteMapping("/listavigilante/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void registroVigilanteEntity(@PathVariable Long id) {
		registroVehiculoService.fntDeleteRegistroVigilanteEntity(id);
	}
}
