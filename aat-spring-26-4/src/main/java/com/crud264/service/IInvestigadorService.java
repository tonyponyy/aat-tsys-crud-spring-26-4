package com.crud264.service;

import java.util.List;

import com.crud264.dto.Investigador;


public interface IInvestigadorService {
	
	//Listar todos
	public List<Investigador> listarInvestigadors();
	
	//Listar por id
	public Investigador investigadorXID(String dni); 
	
	//Guardar
	public Investigador guardarInvestigador(Investigador Fabricante);
	
	//Actualizar
	public Investigador actualizarInvestigador(Investigador Fabricante);
	
	//Eliminar
	public void eliminarInvestigador(String dni);

	
}