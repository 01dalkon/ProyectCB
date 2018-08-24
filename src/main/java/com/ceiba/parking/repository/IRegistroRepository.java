package com.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.entity.RegistroEntity;

public interface IRegistroRepository extends CrudRepository<RegistroEntity, Long>{
	
	RegistroEntity findByplaca(String placa); 
	
	boolean findByPlacaAndTipoRegistro(String placa, String tipoRegistro); 
	
	long countByTipoAndTipoRegistro(String tipo, String tipoRegistro);
}
