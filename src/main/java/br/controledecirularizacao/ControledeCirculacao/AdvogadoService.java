package br.controledecirularizacao.ControledeCirculacao;
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

import Circularizacao.Advogado;
import Circularizacao.CircularizacaoInit;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("advogados")
public class AdvogadoService {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Advogado> getAllCooperativas() {
    	return CircularizacaoInit.advogadoDao.getAll();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Advogado getAdvogado(@PathParam("id") Integer id) {
		
		return CircularizacaoInit.advogadoDao.get(id);
	}	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Advogado addAdvogado(Advogado advogado) {
		CircularizacaoInit.advogadoDao.add(advogado);
		return CircularizacaoInit.advogadoDao.get(advogado.getId());
	}
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(Advogado advogado) {
		CircularizacaoInit.advogadoDao.update(advogado);
		
		return Response.ok().build();
	}
	@DELETE
	@Path("/{id}")
	public Response deleteAdvogado(@PathParam("id") int id) {
		Advogado audi = CircularizacaoInit.advogadoDao.get(id);
		CircularizacaoInit.advogadoDao.remove(audi);
		return Response.status(202).entity("Advogado " + id + " removido com sucesso.").build();
	}
}
