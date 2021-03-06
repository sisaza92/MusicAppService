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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lab2.musicappservice.modelo.dto.Cancion;


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

    // falta probar este metodo
    @Override
    public int votacionCancion(int idRonda, int idCancion, Date fecha) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int votacion;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("Select totalVotos FROM  playList WHERE"
                    + " idRonda=? AND idCancion=? AND fecha=? ");
            //esto evita el sqlinjection
            ps.setInt(1, idRonda);
            ps.setInt(2, idCancion);
            ps.setDate(3,fecha);
            
            rs = ps.executeQuery();
            rs.next();
            votacion = rs.getInt("totalVotos");
            
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
        return votacion;
        
    }

    // falta probar este metodo
    @Override
    public int getIdRondaCancion(Cancion cancion, Date fecha) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int idRonda;

        try {
            connection = DataSource.getInstancia().getConnection();
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("Select idRonda FROM  playList WHERE"
                    + " idCancion=? AND fecha=? AND envotacion=true ");
            //esto evita el sqlinjection
            ps.setInt(1,cancion.getIdCancion() );
            ps.setDate(2,fecha);
            
            rs = ps.executeQuery();
            rs.next();
            idRonda = rs.getInt("idRonda");
            
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
        return idRonda;
        

    }

    // falta probar este metodo
    @Override
    public void actualizarRondaCancion(Cancion cancion, Date fecha) throws ExceptionDao {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataSource.getInstancia().getConnection();
            int idRonda = getIdRondaCancion(cancion, fecha);
            //meter en ps param codigo puede provocar sql injection
            ps = connection.prepareStatement("INSERT INTO playList  (idRonda,idCancion,totalVotos,envotacion,fecha) VALUES(?,?,?,?,?)");
            //esto evita el sqlinjection
            ps.setInt(1,idRonda + 1);
            ps.setInt(2,cancion.getIdCancion());
            ps.setInt(3,0);
            ps.setBoolean(4,true);
            ps.setDate(5, fecha);
            
            ps.execute();
            
            
            ps = connection.prepareStatement("UPDATE playList SET playList.envotacion=false WHERE"
                    + " idRonda=? AND idCancion=? AND envotacion=? AND fecha=? ");
            //esto evita el sqlinjection
            ps.setInt(1,idRonda);
            ps.setInt(2, cancion.getIdCancion());
            ps.setBoolean(3, true);
            ps.setDate(4, fecha);
            
            ps.execute();
           

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
