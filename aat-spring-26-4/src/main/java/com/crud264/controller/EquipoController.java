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

import com.crud264.dto.Equipo;
import com.crud264.service.IEquipoServiceImpl;


@RestController
@RequestMapping("/equipos")
public class EquipoController {
	@Autowired
	private IEquipoServiceImpl equipoServiceImpl;

	@GetMapping("/all")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	@PostMapping("/add")
	public Equipo salvarequipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	@GetMapping("/{num_serie}")
	public Equipo equipoXID(@PathVariable(name="num_serie") String num_serie) {
		Equipo equipo_xid= new Equipo();	
		equipo_xid=equipoServiceImpl.equipoXID(num_serie);
		return equipo_xid;
	}
	
	@PutMapping("/{id}")
	public Equipo actualizarequipo(@PathVariable(name="num_serie")String num_serie,@RequestBody Equipo equipo) {
		
		Equipo equipo_seleccionado= new Equipo();
		Equipo equipo_actualizado= new Equipo();
		
		equipo_seleccionado= equipoServiceImpl.equipoXID(num_serie);
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setNum_serie(equipo.getNum_serie());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);
		System.out.println("El equipo actualizado es: "+ equipo_actualizado);
		return equipo_actualizado;
	}
	
	@DeleteMapping("/{num_serie}")
	public void eliminarequipo(@PathVariable(name="num_serie")String num_serie) {
		equipoServiceImpl.eliminarEquipo(num_serie);
		System.out.println("equipo eliminado");
	}
	


}