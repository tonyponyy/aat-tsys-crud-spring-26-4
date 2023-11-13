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

import com.crud264.dto.Facultad;
import com.crud264.service.IFacultadServiceImpl;


@RestController
@RequestMapping("/facultads")
public class FacultadController {
	@Autowired
	private IFacultadServiceImpl facultadServiceImpl;

	@GetMapping("/all")
	public List<Facultad> listarFacultads(){
		return facultadServiceImpl.listarFacultads();
	}
	@PostMapping("/add")
	public Facultad salvarfacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	@GetMapping("/{id}")
	public Facultad facultadXID(@PathVariable(name="id") Integer id) {
		Facultad facultad_xid= new Facultad();	
		facultad_xid=facultadServiceImpl.facultadXID(id);
		return facultad_xid;
	}
	
	@PutMapping("/{id}")
	public Facultad actualizarfacultad(@PathVariable(name="id")Integer id,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= facultadServiceImpl.facultadXID(id);
		facultad_seleccionado.setNombre(facultad.getNombre());
		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);
		System.out.println("El facultad actualizado es: "+ facultad_actualizado);
		return facultad_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarfacultad(@PathVariable(name="id")Integer id) {
		facultadServiceImpl.eliminarFacultad(id);
		System.out.println("facultad eliminado");
	}
	


}