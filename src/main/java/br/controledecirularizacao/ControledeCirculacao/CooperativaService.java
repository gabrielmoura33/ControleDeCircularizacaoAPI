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
import Circularizacao.CircularizacaoInit;
import Circularizacao.Cooperativa;
import dao.CooperativaDAO;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("cooperativas")
public class CooperativaService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Cooperativa> getAllCooperativas() throws IOException {
    	CooperativaDAO cooperativa = new CooperativaDAO("Cooperativas.bin");
    	return cooperativa.getAll();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cooperativa getAuditoria(@PathParam("id") Integer id) throws IOException {
		
		return CircularizacaoInit.cooperativaDao.get(id);
	} 
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Cooperativa cooperativa) throws IOException {
		CircularizacaoInit.cooperativaDao.add(cooperativa);
		return Response.status(Status.CREATED).build();
	}
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(Cooperativa cooperativa) {
		CircularizacaoInit.cooperativaDao.update(cooperativa);
		
		return Response.ok().build();
	}
	@DELETE
	@Path("/{id}")
	public Response deleteProduct(@PathParam("id") int id) {
		Cooperativa coop = CircularizacaoInit.cooperativaDao.get(id);
		CircularizacaoInit.cooperativaDao.remove(coop);
		return Response.status(202).entity("Cooperativa " + id + " removida com sucesso.").build();
	}
}
