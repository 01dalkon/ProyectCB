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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.entity.RegistroVigilanteEntity;
import com.ceiba.parking.serviceinterfaz.IRegistroVehiculoServicesInterfaz;

@RestController
@RequestMapping("/api")
public class RegistroVehiculoRestController {

	@Autowired
	private IRegistroVehiculoServicesInterfaz iRegistroVehiculoServicesInterfaz;
	
	@GetMapping("/listaregistro")
	public List<RegistroVigilanteEntity> index(){
		return iRegistroVehiculoServicesInterfaz.buscarTotalRegistros();
	}
	
	@GetMapping("/listarid/{id}")
	public RegistroVigilanteEntity show(@PathVariable Long id) {
		return iRegistroVehiculoServicesInterfaz.buscarPorId(id);
	}
	
	//Guardar Registro del Vigilante
	@PostMapping("/guardaregistro/")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVigilanteEntity create(@RequestBody RegistroVigilanteEntity registroVigilanteEntity) {
		return iRegistroVehiculoServicesInterfaz.guardarRegistroVigilanteEntity(registroVigilanteEntity);		
	}
	
	@PutMapping("/actualizaregistro/{id}")
	public RegistroVigilanteEntity update(@RequestBody RegistroVigilanteEntity registroVigilanteEntity,@PathVariable Long id ) {
		RegistroVigilanteEntity registroVehiculoActual = iRegistroVehiculoServicesInterfaz.buscarPorId(id);
		
		registroVehiculoActual.setPlaca(registroVigilanteEntity.getPlaca());
		registroVehiculoActual.setTipo(registroVigilanteEntity.getTipo());
		registroVehiculoActual.setCilindraje(registroVigilanteEntity.getCilindraje());
		registroVehiculoActual.setEspacio(registroVigilanteEntity.getEspacio());	
		registroVehiculoActual.setFechaEntrada(registroVigilanteEntity.getFechaEntrada());
		registroVehiculoActual.setFechaSalida(registroVigilanteEntity.getFechaSalida());
		registroVehiculoActual.setTipoRegistro(registroVigilanteEntity.getTipoRegistro());
		registroVehiculoActual.setValor(registroVigilanteEntity.getValor());
		
		return iRegistroVehiculoServicesInterfaz.guardarRegistroVigilanteEntity(registroVehiculoActual);
	}
	
	@DeleteMapping("/eliminaregistro/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void registroVigilanteEntity(@PathVariable Long id) {
		iRegistroVehiculoServicesInterfaz.fntEliminaRegistroVigilanteEntity(id);
	}
	
	@GetMapping(value = "/buscarplaca/{placa}", produces= {"application/json"})
	public @ResponseBody RegistroVigilanteEntity show(@PathVariable String placa) {
		return iRegistroVehiculoServicesInterfaz.buscarPorPlaca(placa);
	}
}
