package com.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.entity.RegistroVigilanteEntity;

public interface IRegistroVehiculoRepository extends CrudRepository<RegistroVigilanteEntity, Long>{
	
	public RegistroVigilanteEntity findByPlaca(String placa);
	
	long countByTipo(String tipo);
}
