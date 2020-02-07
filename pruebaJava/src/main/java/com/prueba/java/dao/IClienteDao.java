package com.prueba.java.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prueba.java.entity.Cliente;

public interface IClienteDao extends CrudRepository <Cliente,Long>{

@Query("select c from Cliente c where c.procesado = false")
public List<Cliente> obtnerClientesNoProcesados();	
	
}
