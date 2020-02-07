package pruebaJavaWeb.services;

import java.util.List;

import pruebaJavaWeb.modelo.Cliente;

public interface IClienteService {

	public List<Cliente> obtenerClientes();
	
	public String actualizarCliente(List<Cliente> clientes); 
	
	public String registrarCliente(Cliente cliente);
	
}
