package com.ceiba.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.domain.VigilanteParqueadero;
import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.services.IRegistroService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class RegistroRestController {

	@Autowired
	private IRegistroService registroService;

	@Autowired
	VigilanteParqueadero vigilante;

	@GetMapping(value = "/listavehiculo")
	public List<RegistroEntity> index() {
		return registroService.findAll();
	}

	@GetMapping("/listavehiculo/{id}")
	public RegistroEntity show(@PathVariable Long id) {
		return registroService.findById(id);
	}

	@PostMapping("/ingresovehiculo")
	@ResponseStatus
	public ResponseEntity<Void> ingresaRegistro(@RequestBody Registro registro) {
		vigilante.fntEntraVehiculo(registro);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/salidavehiculo")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> salidaRegistro(@RequestBody Registro registro) {
		vigilante.fntSalidaVehiculo(registro.getPlaca());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
