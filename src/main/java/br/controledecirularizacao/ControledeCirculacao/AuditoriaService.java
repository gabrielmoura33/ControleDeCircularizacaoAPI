package br.controledecirularizacao.ControledeCirculacao;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Circularizacao.Auditoria;
import Circularizacao.CircularizacaoInit;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("auditorias")
public class AuditoriaService {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Auditoria> getAllCooperativas() throws IOException {
    	return CircularizacaoInit.auditoriaDao.getAll();
	}
    
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Auditoria getAuditoria(@PathParam("id") Integer id) throws IOException {
		
		return CircularizacaoInit.auditoriaDao.get(id);
	}		
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Auditoria auditoria) throws IOException {
		CircularizacaoInit.auditoriaDao.add(auditoria);
		return Response.status(Status.CREATED).build();
	}
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(Auditoria auditoria) {
		CircularizacaoInit.auditoriaDao.update(auditoria);		
		return Response.ok().build();
	}
	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@PathParam("id") int id) {
		Auditoria audi = CircularizacaoInit.auditoriaDao.get(id);
		CircularizacaoInit.auditoriaDao.remove(audi);
		return Response.status(202).entity("Auditoria " + id + " removida com sucesso.").build();
	}
	
	
}
