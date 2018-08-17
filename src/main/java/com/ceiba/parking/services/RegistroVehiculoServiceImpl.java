package com.ceiba.parking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parking.entity.RegistroVigilanteEntity;
import com.ceiba.parking.repository.IRegistroVehiculoRepository;
import com.ceiba.parking.serviceinterfaz.IRegistroVehiculoServicesInterfaz;

@Service
public class RegistroVehiculoServiceImpl implements IRegistroVehiculoServicesInterfaz{

	@Autowired
	private IRegistroVehiculoRepository registroVehiculoRepository;
	
	//Construct
	public RegistroVehiculoServiceImpl() {
	}
	
	@Override
	@Transactional
	public List<RegistroVigilanteEntity> buscarTotalRegistros() {
		return (List<RegistroVigilanteEntity>) registroVehiculoRepository.findAll();
	}

	@Override
	@Transactional
	public RegistroVigilanteEntity buscarPorId(Long id) {
		return registroVehiculoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void fntEliminaRegistroVigilanteEntity(Long id) {
		registroVehiculoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public RegistroVigilanteEntity buscarPorPlaca(String placa) {
		return registroVehiculoRepository.findByPlaca(placa);
	}

	@Override
	@Transactional
	public long cantidadVehiculo(String tipo) {
		return registroVehiculoRepository.countByTipo(tipo);
	}

	@Override
	@Transactional
	public RegistroVigilanteEntity guardarRegistroNuevo(RegistroVigilanteEntity registro) {
		return registroVehiculoRepository.save(registro);
	}

}
