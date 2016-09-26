/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

/**
 * Interfaz que Especifica los metodos que deben ser implementados por El servicio CancionServiceImpl
 * @author CristianCamilo
 */
public interface CancionServiceInterfaz {
    
    @GET
    @Path("/getSongById/{idCancion}")
    @Produces("application/json")
    @Formatted
    public Response getSongById(@PathParam("idCancion") int idCancion);
    
    @GET
    @Path("/getAllSongs")
    @Produces("application/json")
    @Formatted
    public Response getAllSongs();
    
    @GET
    @Path("/getCurrentPlaylist")
    @Produces("application/json")
    @Formatted
    public Response getCurrentPlaylist();
}
