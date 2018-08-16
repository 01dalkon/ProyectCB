package com.ceiba.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parking.repository.entity.VehiculoEntity;
import com.ceiba.parking.service.IVehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoController {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<VehiculoEntity> index(){
		return vehiculoService.findAll();
	}

}
