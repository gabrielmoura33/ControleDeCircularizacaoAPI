package br.controledecirularizacao.ControledeCirculacao;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Circularizacao.CircularizacaoInit;
import Circularizacao.ProcessoAuditoria;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("processos")
public class ProcessoAuditoriaService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws IOException 
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcessoAuditoria> ListaProcessos() {
    	return CircularizacaoInit.processoDao.getAll();
    }
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProcesso(ProcessoAuditoria processo) throws IOException {
		CircularizacaoInit.processoDao.add(processo);
		return Response.status(Status.CREATED).build();
	}
        
}
