package com.prueba.java.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.java.entity.Cliente;
import com.prueba.java.modelo.MCliente;

@Component
public class Convertidor {

	public List<MCliente> convertirListaMCliente(List<Cliente> clientes) {
		
		List<MCliente> mClientes =new ArrayList<>();
		
		for(Cliente auxCliente: clientes) {
			mClientes.add(new MCliente(auxCliente));			
		}
				
		return mClientes;
	}
	
}
