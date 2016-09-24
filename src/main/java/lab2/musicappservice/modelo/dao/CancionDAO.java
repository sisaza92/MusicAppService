/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.dto.Cancion;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface CancionDAO {
    
    /**
     * retorna una lista  de todas las canciones almacenadas en la base de datos
     * @return
     * @throws ExceptionDao 
     */
    public List<Cancion> getAllSongs() throws ExceptionDao;
    /**
     * retorna una cancion dado de su id
     * @param idCancion
     * @return
     * @throws ExceptionDao 
     */
    public Cancion getSong(int idCancion)throws ExceptionDao;
    /**
     * guarda una cancion en la base de datos
     * @param cancion
     * @throws ExceptionDao 
     */
    void saveSong(Cancion cancion) throws ExceptionDao;
    
    
}
