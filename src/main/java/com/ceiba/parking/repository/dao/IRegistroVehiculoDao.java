package com.ceiba.parking.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.repository.entity.RegistroVigilanteEntity;

public interface IRegistroVehiculoDao extends CrudRepository<RegistroVigilanteEntity, Long>{
}
