/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dao;



import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import lab2.musicappservice.modelo.exception.ExceptionDao;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class DataSource {
    
    private final String MYSQL_HOST = "localhost";
    private final String MYSQL_PORT = "3306";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASS = "";
    private final String DB_NAME = "musicappdb";
    
    //Condiciones para clase singleton	
    private static DataSource instancia;

    private DataSource(){

    }

    public static DataSource getInstancia(){
            if (instancia == null) {
                    instancia = new DataSource();
            }
            return instancia;
    }

    //fin condicion singleton

    public Connection getConnection() throws ExceptionDao{

            Connection connection = null;

            try {

                    Class.forName("com.mysql.jdbc.Driver");
                    String user = MYSQL_USER;
                    String contrasena = MYSQL_PASS;
                    String rutaJDBC_DB = "jdbc:mysql://"+MYSQL_HOST+":"+MYSQL_PORT+"/"+DB_NAME;
                    connection = (Connection) DriverManager.getConnection(rutaJDBC_DB,user,contrasena);

            } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    throw new ExceptionDao("No se encontro el driver de la base de datos");

            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            return connection;
    }

}
