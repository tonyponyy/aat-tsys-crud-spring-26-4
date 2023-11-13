package com.crud264.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud264.dto.Reserva;
import com.crud264.service.IReservaServiceImpl;


@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	private IReservaServiceImpl reservaServiceImpl;

	@GetMapping("/all")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	@PostMapping("/add")
	public Reserva salvarreserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	@GetMapping("/{id}")
	public Reserva reservaXID(@PathVariable(name="id") Integer id) {
		Reserva reserva_xid= new Reserva();	
		reserva_xid=reservaServiceImpl.reservaXID(id);
		return reserva_xid;
	}
	
	@PutMapping("/{id}")
	public Reserva actualizarreserva(@PathVariable(name="id")Integer id,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionado= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionado= reservaServiceImpl.reservaXID(id);
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		reserva_seleccionado.setFecha_comienzo(reserva.getFecha_comienzo());
		reserva_seleccionado.setFecha_final(reserva.getFecha_final());
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);
		System.out.println("El reserva actualizado es: "+ reserva_actualizado);
		return reserva_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarreserva(@PathVariable(name="id")Integer id) {
		reservaServiceImpl.eliminarReserva(id);
		System.out.println("reserva eliminado");
	}
	


}