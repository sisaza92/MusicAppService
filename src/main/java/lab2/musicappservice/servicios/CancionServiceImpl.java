/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import lab2.musicappservice.InicializadorRest;
import lab2.musicappservice.modelo.dto.Cancion;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

/**
 * Clase que implementa los metodos que retornaran las canciones y que son 
 expuestos por el servicio a travez de la interfaz CancionServiceImpl.
 * @author CristianCamilo
 */
@Path("/Canciones")
public class CancionServiceImpl implements CancionService {
    
    
    /**
  * Retorna la cancion con identificador idCancion
  * @param idCancion identificador de la cancion que se va a consultar
  * @return Objeto de tipo javax.ws.rs.core.Response con el contenido json de la cancion
  * que será procesado por RESTEasy.
  */
    public Response getSongById(int idCancion) {
    	Cancion cancion = getCancion(idCancion);
        Response respuesta = Response.ok(cancion).build();
        return respuesta;
    }
    
    /**
     * Lista todas las canciones que se encuentran en la base de datos
     * @return Objeto de tipo javax.ws.rs.core.Response con la lista json de todas las canciones
     * que será procesado por RESTEasy.
     */
    public Response getAllSongs() {
    	
        return Response.ok(listarAllCanciones()).build();
    }
    
    /**
     * Metodo Auxiliar que debe ser reemplazado por una invocacion al DAO
     * @param idCancion
     * @return 
     */
    private Cancion getCancion(int idCancion){
        
    	Cancion cancion = new Cancion();
    	cancion.setIdCancion(idCancion);
    	cancion.setTituloCancion("Menealo mami XD");
    	cancion.setAlbum("Album 2005");
        
    	return cancion;
    }
    /**
     * Metodo Auxiliar que debe ser reemplazado por una invocacion al DAO
     * @return 
     */
    private List<Cancion> listarAllCanciones(){
        
        List<Cancion> canciones = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            
            Cancion cancion = new Cancion();
                cancion.setIdCancion(i);
                cancion.setTituloCancion("Menealo mami XD #"+i);
                cancion.setAlbum("Album "+ 2005 + i);
            canciones.add(cancion);
        }       
     
        return canciones;
    }
}
