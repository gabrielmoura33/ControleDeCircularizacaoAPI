package br.controledecirularizacao.ControledeCirculacao;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import Circularizacao.Laudo;
import dao.LaudoDAO;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("laudo")
public class LaudoService {

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
    public List<Laudo> teste() throws IOException {
    	LaudoDAO laudo = new LaudoDAO("laudos.bin");
    	return laudo.getAll();
    }
      
    
}
