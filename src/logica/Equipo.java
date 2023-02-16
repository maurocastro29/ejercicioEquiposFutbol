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
    
    public static boolean buscarJugadorEnLista(ArrayList<Equipo> listaEquipos, Jugador jugador){
        boolean aux = false;
        Equipo equipo = null;
        for(int i=0;i<listaEquipos.size();i++){
            equipo = listaEquipos.get(i);
            aux = equipo.buscarJugador(jugador);
            if(aux == true){
                return true;
            }
        }
        return false;
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
    
    public boolean insertarJugador(Jugador jugador, int tipoJugador){
        boolean aux = buscarJugador(jugador);
        if(aux == false){
            if(tipoJugador == 1){
                insertarTitular(jugador);
                return true;
            }else if(tipoJugador == 2){
                insertarSuplente(jugador);
                return true;
            }
        }
        return false;
    }    
    
    private void insertarTitular(Jugador jugador){
        this.titulares.add(jugador);
    }
    
    private void insertarSuplente(Jugador jugador){
        this.suplentes.add(jugador);
    }
    
    public static boolean buscarEquipo(ArrayList<Equipo> listaEquipos, String nombre){
        Equipo aux = null;
        for(int i=0;i<listaEquipos.size();i++){
            aux = listaEquipos.get(i);
            if(aux.getNombreEquipo().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public static Equipo buscarEquipoPorNombre(ArrayList<Equipo> listaEquipos, String nombre){
        Equipo aux = null;
        for(int i=0;i<listaEquipos.size();i++){
            aux = listaEquipos.get(i);
            if(aux.getNombreEquipo().equals(nombre)){
                return aux;
            }
        }
        return null;
    }
    
    public String datosEquipo(){
        String titulares = "";
        String suplentes = "";
        Jugador jugador = null;
        String datos = this.toString() + "\n";
        datos += "JUGADORES TITULARES\n";
        for(int i=0; i<this.titulares.size(); i++){
            jugador = this.titulares.get(i);
            titulares += jugador.toString();
        }
        if(titulares != ""){
            datos += titulares;
        }else{
            datos += "No hay jugadores titulares\n";
        }
        datos += "JUGADORES SUPLENTES\n";
        for(int i=0; i<this.suplentes.size(); i++){
            jugador = this.suplentes.get(i);
            suplentes += jugador.toString();
        }
        if(suplentes != ""){
            datos += suplentes;
        }else{
            datos += "No hay jugadores titulares\n";
        }
        return datos;
    }

    @Override
    public String toString() {
        return "Nombre del equipo: " + nombreEquipo + " | Nombre del estadio: " + nombreEstadio + " | Cantidad de titulos: " + cantidadTitulos + "\n" ;
    }
    
}
