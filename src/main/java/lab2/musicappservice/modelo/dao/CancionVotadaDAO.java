/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import java.sql.Date;
import java.util.List;
import lab2.musicappservice.modelo.dto.Cancion;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import lab2.musicappservice.modelo.dto.CancionVotada;
import lab2.musicappservice.modelo.dto.Voto;

/**
 *
 * @author Santiago
 */
public interface CancionVotadaDAO {
    
    public List<CancionVotada> getAllPlayList() throws ExceptionDao;
    
    void guardarPlayList(CancionVotada playList) throws ExceptionDao;
    /**
     * se encarga de guardar un voto en la base de datos y sumarlo a la puntuacion
     * que tiene en el playList
     * @param voto
     * @throws ExceptionDao 
     */
    void agregarVotoPlayLIst(Voto voto) throws ExceptionDao;
    
    int votacionCancion(int idRonda, int idCancion , Date fecha) throws ExceptionDao;
    
    /**
     * retorna la ronda actual de la cancion para una fecha dada
     * @param cancion
     * @return
     * @throws ExceptionDao 
     */
    int getIdRondaCancion(Cancion cancion,Date fecha) throws ExceptionDao;
    
    // crea una nueva cancion en el playList y asigna el idRonda que le corresponde en la fecha dada
    // tambien habilita la votacion y al la misma cancion con idRonda pasado vuelve false en votacion
    void actualizarRondaCancion( Cancion cancion, Date fecha) throws ExceptionDao;
    
}
