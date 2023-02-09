/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Mauricio
 */
public class Jugador {
    private String cedula;
    private String nombre;
    private String posicion;

    public Jugador(String cedula, String nombre, String posicion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", posicion=" + posicion + ", cedula=" + cedula + "\n" ;
    }
    
    
    
}
