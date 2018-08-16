package com.ceiba.parking.models.service;

import java.util.List;

import com.ceiba.parking.repository.entity.RegistroVigilante;

//Contrato
public interface IRegistroVehiculoService {

		public List<RegistroVigilante> findAll();
		
}
