package pruebaJavaWeb.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import pruebaJavaWeb.modelo.Cliente;
import pruebaJavaWeb.services.IClienteService;
import pruebaJavaWeb.services.ImpleClienteService;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Cliente cliente;
	
	private IClienteService iClienteService ;
	
	private List<Cliente> clientes;
	
	
	
	public ClienteBean () {
		cliente = new Cliente();
		
		iClienteService = new ImpleClienteService ();
		
		clientes = new ArrayList<>();
	}

	
	
	public List<Cliente> obtenerClientes(){
			
		List<Cliente> clientes = iClienteService.obtenerClientes();		
		
		return clientes;
	}
	
	
	public String buttonAction() {
		
		if(!cliente.getNombre().equals("") && !cliente.getApellido().equals("")) {
			
			System.out.println(iClienteService.registrarCliente(cliente));
			cliente = new Cliente();
			
		}
		
		return "index.xhtml?faces-redirect=true";
				
    }
	
	public String procesarCliente() {
		
		
		List<Cliente> auxCliente = new ArrayList<>();
		
		for(Cliente cliente: clientes) {
			cliente.setProcesado(true);
			auxCliente.add(cliente);
			
		}
			
		System.out.println(iClienteService.actualizarCliente(auxCliente));
				
		return "clientesNoProcesados.xhtml?faces-redirect=true" ;
	}
	
	public void reload() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
