package com.ceiba.parking.services;

import java.util.List;

import com.ceiba.parking.entity.RegistroEntity;

//Contratos
public interface IRegistroService {

		public List<RegistroEntity> findAll();
		
		public RegistroEntity findById(Long id);
		
		public RegistroEntity findByPlaca(String placa);
		
		public RegistroEntity save(RegistroEntity registro);
		
		public void fntDeleteRegistro(Long id);

		long contarCupos(String tipo, String tipoRegistro);
		
		

}
