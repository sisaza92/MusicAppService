/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;

import lab2.musicappservice.modelo.dto.Voto;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class VotoDAOImpl implements VotoDAO {

    @Override
    public void guardarVoto(Voto voto) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("INSERT INTO voto  (idCancion,idUsuario,fecha,idRonda) VALUES(?,?,?,?)");
            //esto evita el sqlinjection
            ps.setInt(1, voto.getIdCancion());
            ps.setString(2, voto.getIdUsuario());
            ps.setDate(3, voto.getFecha());
            ps.setInt(4, voto.getIdRonda());
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
    public List<Voto> getVotos() throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Voto> resultado = new ArrayList<Voto>();
        try {
            connection = DataSource.getInstancia().getConnection();
            ps = connection.prepareStatement("SELECT * FROM voto");
            rs = ps.executeQuery();

            while (rs.next()) {

                Voto voto = new Voto();
                voto.setIdCancion(rs.getInt("idCancion"));
                voto.setIdUsuario(rs.getString("idUsuario"));
                voto.setFecha(rs.getDate("fecha"));
                voto.setIdRonda(rs.getInt("idRonda"));

                resultado.add(voto);
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
    public void eliminarVoto(Voto voto) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("DELETE FROM voto  WHERE idCancion=? AND idUsuario=?"
                    + "AND fecha=? AND idRonda=?");
            //esto evita el sqlinjection
            ps.setInt(1, voto.getIdCancion());
            ps.setString(2, voto.getIdUsuario());
            ps.setDate(3, voto.getFecha());
            ps.setInt(4, voto.getIdRonda());
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
    public int getNumeroVotantes(Date fecha) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Date fe = Date.valueOf(LocalDate.now());
        
        int nroVotantes;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("SELECT count(idCancion) as nrovotos  FROM voto WHERE fecha = ?");
            //esto evita el sqlinjection
            
            ps.setDate(1,fecha);
            
            rs = ps.executeQuery();
            
            rs.next();
            
            nroVotantes = rs.getInt("nrovotos");
            
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
        return nroVotantes;
    }
    
}
