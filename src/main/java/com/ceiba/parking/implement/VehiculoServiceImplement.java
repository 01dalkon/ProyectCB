package com.ceiba.parking.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.parking.repository.dao.IVehiculoDao;
import com.ceiba.parking.repository.entity.VehiculoEntity;
import com.ceiba.parking.service.IVehiculoService;

@Service
public class VehiculoServiceImplement implements IVehiculoService {

	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	@Transactional(readOnly = true)
	public List<VehiculoEntity> findAll() {
		return (List<VehiculoEntity>) vehiculoDao.findAll();
	}
}
