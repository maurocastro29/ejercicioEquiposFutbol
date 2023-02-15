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
public class Equipo {
    
    private String nombreEquipo;
    private String nombreEstadio;
    private int cantidadTitulos;
    private ArrayList<Jugador> titulares;
    private ArrayList<Jugador> suplentes;

    public Equipo(String nombreEquipo, String nombreEstadio, int cantidadTitulos) {
        this.nombreEquipo = nombreEquipo;
        this.nombreEstadio = nombreEstadio;
        this.cantidadTitulos = cantidadTitulos;
        this.titulares = new ArrayList<Jugador>();
        this.suplentes = new ArrayList<Jugador>();
    }

    public Equipo(String nombreEquipo, String nombreEstadio, int cantidadTitulos, ArrayList<Jugador> titulares, ArrayList<Jugador> suplentes) {
        this.nombreEquipo = nombreEquipo;
        this.nombreEstadio = nombreEstadio;
        this.cantidadTitulos = cantidadTitulos;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public int getCantidadTitulos() {
        return cantidadTitulos;
    }

    public void setCantidadTitulos(int cantidadTitulos) {
        this.cantidadTitulos = cantidadTitulos;
    }

    public ArrayList<Jugador> getTitulares() {
        return titulares;
    }

    public void setTitulares(ArrayList<Jugador> titulares) {
        this.titulares = titulares;
    }

    public ArrayList<Jugador> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(ArrayList<Jugador> suplentes) {
        this.suplentes = suplentes;
    }
    
    public boolean buscarJugador(Jugador jugador){
        boolean suplente = buscarJugadorSuplente(jugador);
        boolean titular = buscarJugadorTitular(jugador);
        if(suplente || titular ){
            return true;
        }        
        return false;
    }
    
    private boolean buscarJugadorSuplente(Jugador jugador){
        int cantiSuplentes = this.suplentes.size();
        Jugador aux = null;
        for(int i=0; i<cantiSuplentes;i++){
            aux = this.suplentes.get(i);
            if(aux == jugador){
                return true;
            }
        }
        return false;
    }
    
    private boolean buscarJugadorTitular(Jugador jugador){
        int cantiTitulares = this.titulares.size();
        Jugador aux = null;
        for(int i=0; i<cantiTitulares;i++){
            aux = this.titulares.get(i);
            if(aux == jugador){
                return true;
            }
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "Nombre del equipo: " + nombreEquipo + " | Nombre del estadio: " + nombreEstadio + " | Cantidad de titulos: " + cantidadTitulos + "\n" ;
    }
    
}
