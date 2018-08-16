package com.ceiba.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.models.service.IRegistroVehiculoService;
import com.ceiba.parking.repository.entity.RegistroVigilante;

@RestController
@RequestMapping("/api")
public class RegistroVehiculoController {

	@Autowired
	private IRegistroVehiculoService registroVehiculoService;
	
	@GetMapping(value = "/listavigilante")
	public List<RegistroVigilante> index(){
		return registroVehiculoService.findAll();
	}
}
