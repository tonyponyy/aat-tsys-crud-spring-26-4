package com.crud264.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud264.dao.IFacultadDAO;
import com.crud264.dto.Facultad;


@Service
public class IFacultadServiceImpl implements IFacultadService {
	
	@Autowired
	IFacultadDAO ifacultadDAO;

	//Listar todos
		public List<Facultad> listarFacultads(){
			return ifacultadDAO.findAll();
		};
		
		
		//Listar por id
		public Facultad facultadXID(Integer id) {
			return ifacultadDAO.findById(id).get();
		}; 
		
		//Guardar
		public Facultad guardarFacultad(Facultad facultad) {
			return ifacultadDAO.save(facultad);
		};
		
		//Actualizar
		public Facultad actualizarFacultad(Facultad facultad) {
			return ifacultadDAO.save(facultad);
		};
		
		//Eliminar
		public void eliminarFacultad(Integer id) {
			ifacultadDAO.deleteById(id);
		}		

}