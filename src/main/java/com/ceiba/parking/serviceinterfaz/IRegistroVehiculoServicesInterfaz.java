package com.ceiba.parking.serviceinterfaz;

import java.util.List;

import com.ceiba.parking.entity.RegistroVigilanteEntity;

//Contratos
public interface IRegistroVehiculoServicesInterfaz {

		public List<RegistroVigilanteEntity> buscarTotalRegistros();
		
		public RegistroVigilanteEntity buscarPorId(Long id);
		
		public RegistroVigilanteEntity buscarPorPlaca(String placa);
		
		public RegistroVigilanteEntity guardarRegistroVigilanteEntity(RegistroVigilanteEntity registroVigilanteEntity);
		
		public void fntEliminaRegistroVigilanteEntity(Long id);
				
}
