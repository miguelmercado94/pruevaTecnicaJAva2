package pruebaJavaWeb.daoRest;

import java.util.List;

import javax.ws.rs.core.Response;


public interface IRestCliente {
	
 
 public Response RestGet(String url);
 
 public Response RestGetOne(String url, String id);

 public Response RestPost(String url,  List<Object> obj);	
 
 public Response RestPut(String url,  Object obj);	
 
 public Response RestDelete(String url, String id);

 
}
