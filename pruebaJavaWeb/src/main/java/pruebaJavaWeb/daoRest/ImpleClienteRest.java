package pruebaJavaWeb.daoRest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ImpleClienteRest implements IRestCliente {

	private final Client client = ClientBuilder.newClient(new ClientConfig().register(JacksonJsonProvider.class));

	private WebTarget webTarget;

	private String urlBase = "http://localhost:8090/v1/";
	
	public ImpleClienteRest(String urlBase) {
		
		this.urlBase = urlBase;
		
	}
	
	public ImpleClienteRest() {
		 this.urlBase = "http://localhost:8090/v1/";
	}

	@Override
	public Response RestGet(String url) {

		webTarget = client.target(urlBase).path(url);

		Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
		return response;
	}

	@Override
	public Response RestGetOne(String url, String id) {
		webTarget = client.target(urlBase).path(url);

		Response response = webTarget.path(id).request(MediaType.APPLICATION_JSON_TYPE).get();
		return response;
	}

	@Override
	public Response RestPut(String url, Object obj) {
		webTarget = client.target(urlBase).path(url);
		Response response = webTarget
		        .request()
		        .put(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
		
		return response;
	}

	@Override
	public Response RestPost(String url,  List<Object> obj) {
		webTarget = client.target(urlBase).path(url);
		Response response = webTarget
		        .request()
		        .post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
		return response;
	}

	@Override
	public Response RestDelete(String url, String id) {
		webTarget = client.target(urlBase).path(url);
		Response response = webTarget.path(id)
		        .request()
		        .delete();
		return response;
	}

}
