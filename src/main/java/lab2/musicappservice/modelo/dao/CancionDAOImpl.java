/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.dto.Cancion;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class CancionDAOImpl implements CancionDAO {

    @Override
    public List<Cancion> getAllSongs() throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cancion> resultado = new ArrayList<Cancion>();
        try {
            connection = DataSource.getInstancia().getConnection();
            ps = connection.prepareStatement("SELECT * FROM cancion");
            rs = ps.executeQuery();

            while (rs.next()) {

                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt("idCancion"));
                cancion.setTituloCancion(rs.getString("tituloCancion"));
                cancion.setArtista(rs.getString("artista"));
                cancion.setAlbum(rs.getString("album"));
                cancion.setRutaCancion(rs.getString("rutaCancion"));

                resultado.add(cancion);
            }

        } catch (SQLException e) {
            // TODO: handle exception
            throw new ExceptionDao(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return resultado;
    }

    @Override
    public Cancion getSong(int idCancion) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cancion cancion = new Cancion();

        try {
            connection = DataSource.getInstancia().getConnection();
            ps = connection.prepareStatement("SELECT * FROM cancion WHERE idCancion=?");
            ps.setInt(1, idCancion);
            rs = ps.executeQuery();
            // rs.next para poder acceder al resultado del query
            rs.next();
            cancion.setIdCancion(rs.getInt("idCancion"));
            cancion.setTituloCancion(rs.getString("tituloCancion"));
            cancion.setArtista(rs.getString("artista"));
            cancion.setAlbum(rs.getString("album"));
            cancion.setRutaCancion(rs.getString("rutaCancion"));

        } catch (SQLException e) {
            // TODO: handle exception
            throw new ExceptionDao(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return cancion;

    }

    @Override
    public void saveSong(Cancion cancion) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("INSERT INTO cancion  (idCancion,tituloCancion,artista,album,rutaCancion) VALUES(?,?,?,?,?)");
            //esto evita el sqlinjection
            ps.setInt(1, cancion.getIdCancion());
            ps.setString(2, cancion.getTituloCancion());
            ps.setString(3, cancion.getArtista());
            ps.setString(4, cancion.getAlbum());
            ps.setString(5, cancion.getRutaCancion());
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
