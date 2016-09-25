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
public class PlayList {
    private int idRonda;
    //falta un objeto de la clase cancion a partir del id
    private int idCancion;
    private int totalVotos;
    private boolean envotacion;
    private Date fecha;

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public boolean isEnvotacion() {
        return envotacion;
    }

    public void setEnvotacion(boolean envotacion) {
        this.envotacion = envotacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "PlayList{" + "idRonda=" + idRonda + ", idCancion=" + idCancion + ", totalVotos=" + totalVotos + ", envotacion=" + envotacion + ", fecha=" + fecha + '}';
    }
    
    
    
    
}
