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

import com.crud264.dto.Investigador;
import com.crud264.service.IInvestigadorServiceImpl;


@RestController
@RequestMapping("/investigadores")
public class InvestigadorController {
	@Autowired
	private IInvestigadorServiceImpl investigadorServiceImpl;

	@GetMapping("/all")
	public List<Investigador> listarInvestigadors(){
		return investigadorServiceImpl.listarInvestigadors();
	}
	@PostMapping("/add")
	public Investigador salvarinvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	@GetMapping("/{dni}")
	public Investigador investigadorXID(@PathVariable(name="dni") String dni) {
		Investigador investigador_xid= new Investigador();	
		investigador_xid=investigadorServiceImpl.investigadorXID(dni);
		return investigador_xid;
	}
	
	@PutMapping("/{id}")
	public Investigador actualizarinvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorServiceImpl.investigadorXID(dni);
		investigador_seleccionado.setNombre(investigador.getNombre());
		investigador_seleccionado.setDni(investigador.getDni());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);
		System.out.println("El investigador actualizado es: "+ investigador_actualizado);
		return investigador_actualizado;
	}
	
	@DeleteMapping("/{dni}")
	public void eliminarinvestigador(@PathVariable(name="dni")String dni) {
		investigadorServiceImpl.eliminarInvestigador(dni);
		System.out.println("investigador eliminado");
	}
	


}