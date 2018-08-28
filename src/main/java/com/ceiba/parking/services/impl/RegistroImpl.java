package com.ceiba.parking.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.dto.DTO;
import com.ceiba.parking.entity.RegistroEntity;
import com.ceiba.parking.repository.IRegistroRepository;
import com.ceiba.parking.services.IRegistroService;

@Service
public class RegistroImpl implements IRegistroService{
	

	@Autowired
	private IRegistroRepository registroRepository;
	
	@Autowired
	private DTO dto;
	
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
	public void fntDeleteRegistro(Long id) {
		registroRepository.deleteById(id);
	} 

	@Override
	@Transactional
	public long contarCupos(String tipo, String tipoRegistro) {
		return registroRepository.countByTipoAndTipoRegistro(tipo, tipoRegistro);
	}
	
	@Override
	@Transactional
	public Registro buscarPorPlaca(String placa) {
		RegistroEntity registroEntidad = registroRepository.findByplaca(placa);
		return dto.convertirADominio(registroEntidad);
	}
	
	@Override
	@Transactional
	public RegistroEntity registroExiste(String placa, String tipoRegistro) {
		return registroRepository.findByPlacaAndTipoRegistro(placa, tipoRegistro);
	}
	
	@Override
	@Transactional
	public Registro buscarPorPlacaTipoRegistro(String placa, String tipoRegistro) {
		RegistroEntity registroEntidad = registroRepository.findByPlacaAndTipoRegistro(placa, tipoRegistro);
		return dto.convertirADominio(registroEntidad);
	}

	@Override
	@Transactional
	public void registrarEntrada(Registro registro) {
		RegistroEntity registroEntidad = dto.convertirAEntidad(registro);
		registroEntidad.setTipoRegistro("ENTRADA");
		registroRepository.save(registroEntidad);
	}

	@Override
	@Transactional
	public void registrarSalida(Registro registro) {
		RegistroEntity registroEntidad = registroRepository.findByPlacaAndTipoRegistro(registro.getPlaca(), registro.getTipoRegistro());
		registroEntidad.setTipoRegistro("SALIDA");
		registroEntidad.setFechaSalida(registro.getFechaSalida());
		registroEntidad.setValor(registro.getValor());
		registroRepository.save(registroEntidad);
		
	}

}
