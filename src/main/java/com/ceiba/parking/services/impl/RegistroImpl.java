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
	private DTO dto;
	
	public RegistroImpl () {
		dto = new DTO();
	}

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
	public Registro buscarPorPlaca(String placa) {
		RegistroEntity registroEntidad = registroRepository.findByplaca(placa);
		return dto.convertirADominio(registroEntidad);
	}

	@Override
	public void registrarEntrada(Registro registro) {
		RegistroEntity registroEntidad = dto.convertirAEntidad(registro);
		registroEntidad.setTipoRegistro("ENTRADA");
		registroRepository.save(registroEntidad);
	}

	@Override
	public void registrarSalida(Registro registro) {
		
		RegistroEntity registroEntidad = registroRepository.findByplaca(registro.getPlaca());
		registroEntidad.setTipoRegistro("SALIDA");
		registroEntidad.setFechaSalida(registro.getFechaSalida());
		registroEntidad.setValor(registro.getValor());
		registroRepository.save(registroEntidad);
		
	}
	
}
