package com.prueba.java.service;

import java.util.List;


import com.prueba.java.modelo.MCliente;

public interface IClienteService {
	
	public List<MCliente> obtenerTodoLosClientes();
	
	public List<MCliente> obtenerClientesNoProcesados();
	
	public void guardarNuevoCliente(MCliente mcliente);
	
	
	public MCliente findOne(Long id);
	
	public void actualizarCliente(MCliente mcliente);
	
	
}
