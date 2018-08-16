package com.ceiba.parking.service;

import java.util.List;

import com.ceiba.parking.repository.entity.*;

public interface IVehiculoService {
	
	public List<VehiculoEntity> findAll();

}
