package com.crud264.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigadores")
public class Investigador {
    @Id
    private String dni;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;
    
    
    @JsonIgnoreProperties("investigadores")
    @OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
    
    
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public Investigador(String dni, String nombre, Facultad facultad, List reservas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}
	public Investigador() {

	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	
	

}
