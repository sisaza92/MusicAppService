/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.servicios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import lab2.musicappservice.modelo.dao.CancionDAO;
import lab2.musicappservice.modelo.dao.CancionDAOImpl;
import lab2.musicappservice.modelo.dto.Cancion;
import lab2.musicappservice.modelo.exception.ExceptionDao;

/**
 * Clase que implementa los metodos que retornaran las canciones y que son 
 expuestos por el servicio a travez de la interfaz CancionServiceImpl.
 * @author CristianCamilo
 */
@Path("/Canciones")
public class CancionServiceImpl implements CancionService {
    
    CancionDAO cancionDAO = null;
    
    /**
  * Retorna la cancion con identificador idCancion
  * @param idCancion identificador de la cancion que se va a consultar
  * @return Objeto de tipo javax.ws.rs.core.Response con el contenido json de la cancion
  * que será procesado por RESTEasy.
  */
    public Response getSongById(int idCancion) {
        
        Response respuesta = null;
        try {
            
            cancionDAO = new CancionDAOImpl();
            Cancion cancion = cancionDAO.getSong(idCancion);
            respuesta = Response.ok(cancion).build();
            
        } catch (ExceptionDao ex) {
            Logger.getLogger(CancionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    /**
     * Lista todas las canciones que se encuentran en la base de datos
     * @return Objeto de tipo javax.ws.rs.core.Response con la lista json de todas las canciones
     * que será procesado por RESTEasy.
     */
    public Response getAllSongs() {
    	
        Response respuesta = null;
        try {
            
            cancionDAO = new CancionDAOImpl();
            List<Cancion> canciones = cancionDAO.getAllSongs();
            respuesta = Response.ok(canciones).build();
            
        } catch (ExceptionDao ex) {
            Logger.getLogger(CancionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
