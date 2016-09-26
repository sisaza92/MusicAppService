/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.exception.ExceptionDao;
import lab2.musicappservice.modelo.dto.PlayList;
import lab2.musicappservice.modelo.dto.Voto;

/**
 *
 * @author Santiago
 */
public interface PlayListDAO {
    
    
    void guardarPlayList(PlayList playList) throws ExceptionDao;
    /**
     * se encarga de guardar un voto en la base de datos y sumarlo a la puntuacion
     * que tiene en el playList
     * @param voto
     * @throws ExceptionDao 
     */
    void agregarVotoPlayLIst(Voto voto) throws ExceptionDao;
    
    
}
