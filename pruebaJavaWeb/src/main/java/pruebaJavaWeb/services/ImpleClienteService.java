package pruebaJavaWeb.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pruebaJavaWeb.daoRest.IRestCliente;
import pruebaJavaWeb.daoRest.ImpleClienteRest;
import pruebaJavaWeb.modelo.Cliente;

public class ImpleClienteService implements IClienteService {

	
	private IRestCliente rest = new ImpleClienteRest();
	
	
	@Override
	public List<Cliente> obtenerClientes() {
	
		List<Cliente> clientes = Arrays.asList(rest.RestGet("allClientes").readEntity(Cliente[].class));
		
		return clientes;
	}

	@Override
	public String actualizarCliente(List<Cliente> clientes) {
		
		List<Object>  obj= new ArrayList<>();
		
		for(Cliente cliente:clientes) {
			
			obj.add(cliente);
		}
		
		return String.valueOf(rest.RestPost("actualizarClientes",  obj).getStatus());
	}

	@Override
	public String registrarCliente(Cliente cliente) {
	
		return String.valueOf(rest.RestPut("newCliente", cliente).getStatus());
	}

}
