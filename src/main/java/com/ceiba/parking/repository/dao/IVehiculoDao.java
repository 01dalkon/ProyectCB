package com.ceiba.parking.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.repository.entity.VehiculoEntity;

public interface IVehiculoDao extends CrudRepository<VehiculoEntity, Long> {

}
