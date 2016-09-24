/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.dto.Voto;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface VotoDao {
    
    /**
     * se encarga de almacenar el voto en la base de datos y (pendiente)modificar
     * la votacion total en el playlist
     * @param voto
     * @throws ExceptionDao 
     */
    void guardarVoto(Voto voto) throws ExceptionDao;
    
    /**
     * 
     * @return 
     * @throws ExceptionDao 
     */
    List<Voto> getVotos() throws ExceptionDao;
    
    
}
