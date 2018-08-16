package com.ceiba.parking.service;

import java.util.List;

import com.ceiba.parking.repository.entity.RegistroVigilanteEntity;

//Contratos
public interface IRegistroVehiculoService {

		public List<RegistroVigilanteEntity> findAll();
		
		public RegistroVigilanteEntity findById(Long id);
		
		public RegistroVigilanteEntity save(RegistroVigilanteEntity registroVigilanteEntity);
		
		public void fntDeleteRegistroVigilanteEntity(Long id);
		
}
