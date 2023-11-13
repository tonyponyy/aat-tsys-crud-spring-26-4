package com.crud264.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud264.dao.IEquipoDAO;
import com.crud264.dto.Equipo;


@Service
public class IEquipoServiceImpl implements IEquipoService {
	
	@Autowired
	IEquipoDAO iequipoDAO;

	//Listar todos
		public List<Equipo> listarEquipos(){
			return iequipoDAO.findAll();
		};
		
		
		//Listar por id
		public Equipo equipoXID(String num_serie) {
			return iequipoDAO.findById(num_serie).get();
		}; 
		
		//Guardar
		public Equipo guardarEquipo(Equipo equipo) {
			return iequipoDAO.save(equipo);
		};
		
		//Actualizar
		public Equipo actualizarEquipo(Equipo equipo) {
			return iequipoDAO.save(equipo);
		};
		
		//Eliminar
		public void eliminarEquipo(String num_serie) {
			iequipoDAO.deleteById(num_serie);
		}		

}