package com.prueba.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.java.convertidor.Convertidor;
import com.prueba.java.dao.IClienteDao;
import com.prueba.java.entity.Cliente;
import com.prueba.java.modelo.MCliente;

@Service("servicio")
public class ClienteServiceImplement implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private Convertidor convertidor;
	
	@Override
	@Transactional(readOnly=true)
	public List<MCliente> obtenerTodoLosClientes() {
		
		return convertidor.convertirListaMCliente((List<Cliente>) clienteDao.findAll());
	}
	@Override
	@Transactional(readOnly=true)
	public List<MCliente> obtenerClientesNoProcesados() {
		
		return convertidor.convertirListaMCliente(clienteDao.obtnerClientesNoProcesados());
	}
	
	
	
	
	@Override
	@Transactional
	public void guardarNuevoCliente(MCliente mcliente) {
		Cliente cliente = new Cliente(mcliente.getNombre(),mcliente.getApellido(),
				mcliente.getProcesado());
		
		
		clienteDao.save(cliente);
		
	}
	@Override
	@Transactional
	public void actualizarCliente(MCliente mcliente) {
		Cliente cliente = new Cliente();
		cliente.setId(mcliente.getId());
		cliente.setNombre(mcliente.getNombre());
		cliente.setApellido(mcliente.getApellido());
		cliente.setProcesado(mcliente.getProcesado());
		
		clienteDao.save(cliente);
		
	}
	@Transactional(readOnly=true)
	@Override
	public MCliente findOne(Long id) {	
		
		return new MCliente(clienteDao.findById(id).get());
	}



}
