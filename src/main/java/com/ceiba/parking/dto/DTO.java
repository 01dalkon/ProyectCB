package com.ceiba.parking.dto;

import org.springframework.stereotype.Service;

import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.entity.RegistroEntity;

@Service
public class DTO {

	public Registro convertirADominio(RegistroEntity registroEntity) {
		Registro registro = null;
		

			if ("CARRO".equals(registroEntity.getTipo())) {
				registro = new Registro(registroEntity.getPlaca(), registroEntity.getTipo(), registroEntity.getTipoRegistro(),
						registroEntity.getFechaEntrada(), registroEntity.getFechaSalida(),
						registroEntity.getValor());
			}
			if ("MOTO".equals(registroEntity.getTipo())) {
				registro = new Registro(registroEntity.getPlaca(), registroEntity.getTipo(),registroEntity.getTipoRegistro(),
						registroEntity.getCilindraje(), registroEntity.getFechaEntrada(),
						registroEntity.getFechaSalida(), registroEntity.getValor());
			}
		
		return registro;
	}

	public RegistroEntity convertirAEntidad(Registro registro) {
		RegistroEntity registroEntity = new RegistroEntity();
		registroEntity.setPlaca(registro.getPlaca());
		registroEntity.setTipo(registro.getTipo());
		registroEntity.setFechaEntrada(registro.getFechaEntrada());
		registroEntity.setFechaSalida(registro.getFechaSalida());
		registroEntity.setValor(registro.getValor());

		if ("MOTO".equals(registro.getTipo())) {
			registroEntity.setCilindraje(registro.getCilindraje());
		}

		return registroEntity;
	}
}
