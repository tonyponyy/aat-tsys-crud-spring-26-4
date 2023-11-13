package com.crud264.service;

import java.util.List;

import com.crud264.dto.Facultad;


public interface IFacultadService {
	
	//Listar todos
	public List<Facultad> listarFacultads();
	
	//Listar por id
	public Facultad facultadXID(Integer id); 
	
	//Guardar
	public Facultad guardarFacultad(Facultad Fabricante);
	
	//Actualizar
	public Facultad actualizarFacultad(Facultad Fabricante);
	
	//Eliminar
	public void eliminarFacultad(Integer id);

	
}