package com.ceiba.parking.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.repository.entity.RegistroVigilante;

public interface IRegistroVehiculoDao extends CrudRepository<RegistroVigilante, Long>{
}
