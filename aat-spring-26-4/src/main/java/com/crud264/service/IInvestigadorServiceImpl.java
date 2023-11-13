package com.crud264.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud264.dao.IInvestigadorDAO;
import com.crud264.dto.Investigador;


@Service
public class IInvestigadorServiceImpl implements IInvestigadorService {
	
	@Autowired
	IInvestigadorDAO iinvestigadorDAO;

	//Listar todos
		public List<Investigador> listarInvestigadors(){
			return iinvestigadorDAO.findAll();
		};
		
		
		//Listar por id
		public Investigador investigadorXID(String dni) {
			return iinvestigadorDAO.findById(dni).get();
		}; 
		
		//Guardar
		public Investigador guardarInvestigador(Investigador investigador) {
			return iinvestigadorDAO.save(investigador);
		};
		
		//Actualizar
		public Investigador actualizarInvestigador(Investigador investigador) {
			return iinvestigadorDAO.save(investigador);
		};
		
		//Eliminar
		public void eliminarInvestigador(String dni) {
			iinvestigadorDAO.deleteById(dni);
		}		

}