package com.ceiba.parking.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.registrodto.DTO;
import com.ceiba.parking.repository.IRegistroRepository;
import com.ceiba.parking.services.IRegistroService;

@Service
public class RegistroImpl implements IRegistroService{

	@Autowired
	private IRegistroRepository registroRepository;
	
	@Override
	@Transactional
	public List<RegistroEntity> findAll() {
		return (List<RegistroEntity>) registroRepository.findAll();
	}

	@Override
	@Transactional
	public RegistroEntity findById(Long id) {
		return registroRepository.findById(id).orElse(null);
	}
	
	
	@Override
	@Transactional
	public RegistroEntity findByPlaca(String placa) {
		return registroRepository.findByplaca(placa);
	}

	@Override
	@Transactional
	public RegistroEntity save(RegistroEntity registro) {
		return registroRepository.save(registro);
	}

	@Override
	@Transactional
	public void fntDeleteRegistro(Long id) {
		registroRepository.deleteById(id);
	}

	@Override
	public long contarCupos(String tipo, String tipoRegistro) {
		return registroRepository.countByTipoAndTipoRegistro(tipo, tipoRegistro);
	}

	@Override
	public void registrarEntrada(Registro registro) {
		RegistroEntity registroEntidad = DTO.convertirAEntidad(registro);
		registroEntidad.setTipoRegistro("ENTRADA");
		registroRepository.save(registroEntidad);
	}
	
}
