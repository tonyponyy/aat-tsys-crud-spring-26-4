package com.crud264.service;

import java.util.List;

import com.crud264.dto.Equipo;


public interface IEquipoService {
	
	//Listar todos
	public List<Equipo> listarEquipos();
	
	//Listar por id
	public Equipo equipoXID(String num_serie); 
	
	//Guardar
	public Equipo guardarEquipo(Equipo Fabricante);
	
	//Actualizar
	public Equipo actualizarEquipo(Equipo Fabricante);
	
	//Eliminar
	public void eliminarEquipo(String num_serie);

	
}