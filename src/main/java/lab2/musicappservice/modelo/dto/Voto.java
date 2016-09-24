/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dto;

import java.sql.Date;


/**
 *
 * @author Santiago
 */
public class Voto {

  int idCancion;
  String idUsuario;
  Date fecha;
  int idRonda;

    public Voto() {
    }

    public Voto(int idCancion, String idUsuario, Date fecha, int idRonda) {
        this.idCancion = idCancion;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.idRonda = idRonda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    @Override
    public String toString() {
        return "Voto{" + "idCancion=" + idCancion + ", idUsuario=" + idUsuario + ", fecha=" + fecha + ", idRonda=" + idRonda + '}';
    }
    
    
  
  
  
   

}
