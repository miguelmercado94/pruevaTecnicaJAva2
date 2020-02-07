package com.prueba.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	public Cliente() {
		
	}

	public Cliente( String nombre, String apellido, Boolean procesado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="procesado")
	private Boolean procesado;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Boolean getProcesado() {
		return procesado;
	}



	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}



	private static final long serialVersionUID = 1L;

}
