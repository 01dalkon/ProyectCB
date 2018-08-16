package com.ceiba.parking.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.parking.models.service.IVehiculoService;
import com.ceiba.parking.repository.dao.IVehiculoDao;
import com.ceiba.parking.repository.entity.Vehiculo;

@Service
public class VehiculoServiceImplement implements IVehiculoService {

	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}
}
