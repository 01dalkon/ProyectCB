package com.ceiba.parking.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.repository.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

}
