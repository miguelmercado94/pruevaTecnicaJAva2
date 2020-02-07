package com.prueba.java.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.java.modelo.MCliente;
import com.prueba.java.service.IClienteService;

@RestController
@RequestMapping("/v1")
public class ClienteController {

	@Autowired
	@Qualifier("servicio")
	private IClienteService clienteService;
	
	@PutMapping("/newCliente")
	public void crearCliente(@RequestBody @Valid	MCliente mCliente) {
		clienteService.guardarNuevoCliente(mCliente);
	}
	
	@GetMapping("/allClientes")
	public List<MCliente> mostrarClientes(){
		
		return clienteService.obtenerTodoLosClientes();
	}
	@GetMapping("/clientesNoProcesados")
	public List<MCliente> mostrarClientesNoProcesados(){
		
		return clienteService.obtenerClientesNoProcesados();
	}
	
	@GetMapping("/allClientes/{id}")
	public MCliente mostrarClienteById(@PathVariable Long id){
		
		return clienteService.findOne(id);
	}
	
	@PostMapping("/actualizarClientes")	
	public void actulizarClientes(@RequestBody @Valid List<MCliente> mClientes) {
		
	for(MCliente mCliente: mClientes) {			
		    clienteService.actualizarCliente(mCliente);
			
	}
	}
	
	
}
