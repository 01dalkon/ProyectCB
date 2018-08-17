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
	public RegistroVigilanteEntity listarbyid(@PathVariable Long id) {
		return iRegistroVehiculoServicesInterfaz.buscarPorId(id);
	}
	
	@PostMapping("nuevoregistro")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVigilanteEntity nuevoRegistro(@RequestBody RegistroVigilanteEntity registro) {
		return iRegistroVehiculoServicesInterfaz.guardarRegistroNuevo(registro);
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
		
		return iRegistroVehiculoServicesInterfaz.guardarRegistroNuevo(registroVehiculoActual);
	}
	
	@DeleteMapping("/eliminaregistro/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void registroVigilanteEntity(@PathVariable Long id) {
		iRegistroVehiculoServicesInterfaz.fntEliminaRegistroVigilanteEntity(id);
	}
	
	@GetMapping(value = "/buscarplaca/{placa}", produces= {"application/json"})
	public RegistroVigilanteEntity buscarByplaca(@PathVariable String placa) {
		return iRegistroVehiculoServicesInterfaz.buscarPorPlaca(placa);
	}
	
	@GetMapping("/cantidadvehiculo/{tipo}")
	public long cantidaVehiculo(@PathVariable String tipo) {
		return iRegistroVehiculoServicesInterfaz.cantidadVehiculo(tipo);
	}
}
