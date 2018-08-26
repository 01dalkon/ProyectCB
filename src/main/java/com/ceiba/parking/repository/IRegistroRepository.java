package com.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.entity.RegistroEntity;

public interface IRegistroRepository extends CrudRepository<RegistroEntity, Long>{
	
	public RegistroEntity findByplaca(String placa); 
	
	public RegistroEntity findByPlacaAndTipoRegistro(String placa, String tipoRegistro); 
	
	public long countByTipoAndTipoRegistro(String tipo, String tipoRegistro);
}
