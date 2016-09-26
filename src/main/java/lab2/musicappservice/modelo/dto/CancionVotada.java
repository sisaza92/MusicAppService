/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.musicappservice.modelo.dto;

import lab2.musicappservice.modelo.Cancion;


/**
 *
 * @author Santiago
 */
public class CancionVotada {
    
    private int idRonda;
    private Cancion cancion;
    private float totalVotos;
    private boolean envotacion;
    //private Date fecha;

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }
    
    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
 
    public float getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(float totalVotos) {
        this.totalVotos = totalVotos;
    }

    public boolean isEnvotacion() {
        return envotacion;
    }

    public void setEnvotacion(boolean envotacion) {
        this.envotacion = envotacion;
    }

    @Override
    public String toString() {
        return "PlayList{" + "idRonda=" + idRonda + ", "+cancion.toString()+ " totalVotos=" + totalVotos + ", envotacion=" + envotacion + '}';
    }
  
}
