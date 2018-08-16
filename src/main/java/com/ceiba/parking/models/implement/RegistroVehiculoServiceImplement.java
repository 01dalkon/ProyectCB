package com.ceiba.parking.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parking.models.service.IRegistroVehiculoService;
import com.ceiba.parking.repository.dao.IRegistroVehiculoDao;
import com.ceiba.parking.repository.entity.RegistroVigilante;

@Service
public class RegistroVehiculoServiceImplement implements IRegistroVehiculoService{

	@Autowired
	private IRegistroVehiculoDao registroVehiculoDao;
	
	@Override
	public List<RegistroVigilante> findAll() {
		return (List<RegistroVigilante>) registroVehiculoDao.findAll();
	}

}
