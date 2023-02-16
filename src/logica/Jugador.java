/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

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
    
    public static boolean buscarCedula(String cedula, ArrayList<Jugador> jugadores){
        Jugador j = null;
        for(int i=0; i<jugadores.size();i++){
            j = jugadores.get(i);
            if(j.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public static Jugador buscarJugadorPorCedula(String cedula, ArrayList<Jugador> jugadores){
        Jugador j = null;
        for(int i=0; i<jugadores.size();i++){
            j = jugadores.get(i);
            if(j.getCedula().equals(cedula)){
                return j;
            }
        }
        return null;
    }
    
     public static String listarJugadores(ArrayList<Jugador> jugadores){
        Jugador j = null;
        String datos = "";
        for(int i=0; i<jugadores.size();i++){
            j = jugadores.get(i);
            datos += j.toString();
        }
        return datos;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " | posicion: " + posicion + " | cedula=" + cedula + "\n" ;
    }
    
    
    
}
