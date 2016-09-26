/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.dto.PlayList;
import lab2.musicappservice.modelo.dto.Voto;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class PlayListDAOImpl implements PlayListDAO{

    @Override
    public void guardarPlayList(PlayList playList) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("INSERT INTO playList  (idRonda,idCancion,totalVotos,envotacion,fecha) VALUES(?,?,?,?,?)");
            //esto evita el sqlinjection
            ps.setInt(1, playList.getIdRonda());
            ps.setInt(2, playList.getIdCancion());
            ps.setInt(3, playList.getTotalVotos());
            ps.setBoolean(4, playList.isEnvotacion());
            ps.setDate(5, playList.getFecha());
            
            ps.execute();
            
            // volver a enviarle otra sentencia sql y ejecutarla

        } catch (SQLException e) {
            // TODO: handle exception
            throw new ExceptionDao(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
                throw new ExceptionDao();
            }
        }
        
    }

    @Override
    public void agregarVotoPlayLIst(Voto voto) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("UPDATE playList SET playList.totalVotos=playList.totalVotos+1 WHERE"
                    + " idRonda=? AND idCancion=? AND envotacion=? AND fecha=? ");
            //esto evita el sqlinjection
            ps.setInt(1, voto.getIdRonda());
            ps.setInt(2, voto.getIdCancion());
            ps.setBoolean(3, true);
            ps.setDate(4, voto.getFecha());
            
            ps.execute();
            
            // volver a enviarle otra sentencia sql y ejecutarla

        } catch (SQLException e) {
            // TODO: handle exception
            throw new ExceptionDao(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
                throw new ExceptionDao();
            }
        }
        
    }
    
}
