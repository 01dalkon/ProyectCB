package com.ceiba.parking.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.parking.models.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

}
