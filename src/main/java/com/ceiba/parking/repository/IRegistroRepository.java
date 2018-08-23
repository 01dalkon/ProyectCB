package com.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.entity.RegistroEntity;

public interface IRegistroRepository extends CrudRepository<RegistroEntity, Long>{
	
	RegistroEntity findByplaca(String placa); 
	
	long countByTipoAndTipoRegistro(String tipo, String tipoRegistro);
}
