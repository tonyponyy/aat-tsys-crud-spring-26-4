package com.crud264.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_serie")
    private String num_serie;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;
    
    @JsonIgnoreProperties("equipos")
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    public Equipo(String num_serie, String nombre, Facultad facultad) {
        this.num_serie = num_serie;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public Equipo() {

    }

    public String getNum_serie() {
		return num_serie;
	}



	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
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



	public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
