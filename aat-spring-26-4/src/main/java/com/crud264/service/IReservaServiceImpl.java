package com.crud264.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud264.dao.IReservaDAO;
import com.crud264.dto.Reserva;


@Service
public class IReservaServiceImpl implements IReservaService {
	
	@Autowired
	IReservaDAO ireservaDAO;

	//Listar todos
		public List<Reserva> listarReservas(){
			return ireservaDAO.findAll();
		};
		
		
		//Listar por id
		public Reserva reservaXID(Integer id) {
			return ireservaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Reserva guardarReserva(Reserva reserva) {
			return ireservaDAO.save(reserva);
		};
		
		//Actualizar
		public Reserva actualizarReserva(Reserva reserva) {
			return ireservaDAO.save(reserva);
		};
		
		//Eliminar
		public void eliminarReserva(Integer id) {
			ireservaDAO.deleteById(id);
		}		

}