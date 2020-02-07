package com.prueba.java.modelo;

import com.prueba.java.entity.Cliente;

public class MCliente {

	public MCliente() {}
	
	public MCliente(Cliente entityCliente) {
		
		this.id = entityCliente.getId();
		
		this.nombre = entityCliente.getNombre();
		
		this.apellido = entityCliente.getApellido();
		
		this.procesado = entityCliente.getProcesado();
		
	}
	
	public MCliente(Long id, String nombre, String apellido,Boolean procesado) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.procesado=procesado;		
	}
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
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
	
	
}
