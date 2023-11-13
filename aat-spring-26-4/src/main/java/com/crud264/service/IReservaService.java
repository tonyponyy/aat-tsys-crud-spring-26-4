package com.crud264.service;

import java.util.List;

import com.crud264.dto.Reserva;


public interface IReservaService {
	
	//Listar todos
	public List<Reserva> listarReservas();
	
	//Listar por id
	public Reserva reservaXID(Integer id); 
	
	//Guardar
	public Reserva guardarReserva(Reserva Fabricante);
	
	//Actualizar
	public Reserva actualizarReserva(Reserva Fabricante);
	
	//Eliminar
	public void eliminarReserva(Integer id);

	
}