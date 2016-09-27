/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import java.sql.Date;
import lab2.musicappservice.modelo.dto.Voto;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface VotoDAO {
    
    /**
     * se encarga de almacenar el voto en la base de datos y (pendiente)modificar
     * la votacion total en el playlist retorna true si almacena el voto y false 
     * si ya existe y lo elimina
     * @param voto
     * @throws ExceptionDao 
     */
    boolean guardarVoto(Voto voto) throws ExceptionDao;
    
    /**
     * 
     * @return 
     * @throws ExceptionDao 
     */
    List<Voto> getVotos() throws ExceptionDao;
    /**
    * Elimina un voto de la base de datos
    * @param voto
    * @throws ExceptionDao 
    */
    void eliminarVoto(Voto voto) throws ExceptionDao;
    
    int getNumeroVotantes(Date fecha) throws ExceptionDao;
    
    boolean existeVoto(Voto voto) throws ExceptionDao;
    

    
}
