package com.ceiba.parking.services;

import java.util.List;

import com.ceiba.parking.domain.Registro;
import com.ceiba.parking.entity.RegistroEntity;

//Contratos
public interface IRegistroService {

		public List<RegistroEntity> findAll();
		
		public RegistroEntity findById(Long id);
		
		public RegistroEntity findByPlaca(String placa);
		
		public RegistroEntity save(RegistroEntity registro);
		
		public void fntDeleteRegistro(Long id);

		long contarCupos(String tipo, String tipoRegistro);
		
		public void registrarEntrada (Registro registro);
		
		public void registrarSalida (Registro registro);
		
		public Registro buscarPorPlaca(String placa);
		
		public Registro buscarPorPlacaTipoRegistro(String placa, String tipoRegistro);

		RegistroEntity registroExiste(String placa, String tipoRegistro);

}
