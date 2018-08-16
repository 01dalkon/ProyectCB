package com.ceiba.parking.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parking.repository.dao.IRegistroVehiculoDao;
import com.ceiba.parking.repository.entity.RegistroVigilanteEntity;
import com.ceiba.parking.service.IRegistroVehiculoService;

@Service
public class RegistroVehiculoServiceImplement implements IRegistroVehiculoService{

	@Autowired
	private IRegistroVehiculoDao registroVehiculoDao;
	
	@Override
	@Transactional
	public List<RegistroVigilanteEntity> findAll() {
		return (List<RegistroVigilanteEntity>) registroVehiculoDao.findAll();
	}

	@Override
	@Transactional
	public RegistroVigilanteEntity findById(Long id) {
		// validarEspacio()
		return registroVehiculoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public RegistroVigilanteEntity save(RegistroVigilanteEntity registroVigilanteEntity) {
		return registroVehiculoDao.save(registroVigilanteEntity);
	}

	@Override
	@Transactional
	public void fntDeleteRegistroVigilanteEntity(Long id) {
		registroVehiculoDao.deleteById(id);
	}
	
}
