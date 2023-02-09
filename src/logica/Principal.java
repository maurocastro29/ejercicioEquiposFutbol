/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class Principal {
    public static void main(String[] args) {
        int op = -1;
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
        ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        do{
            op = new Integer(JOptionPane.showInputDialog("DIGITE UNA OPCION\n"
                    + "1. Crear nuevo Equipo\n"
                    + "2. Crear nuevo Jugador\n"
                    + "3. Ver lista de jugadores\n"
                    + "4. Insertar jugador a equipo\n"
                    + "5. Salir\n"));
            switch(op){
                case 1:{
                    String nombreEquipo = JOptionPane.showInputDialog("Digite el nombre del nuevo Equipo");
                    String nombreEstadio = JOptionPane.showInputDialog("Digite el nombre del estadio del nuevo equipo");
                    int cantTitulos = new Integer(JOptionPane.showInputDialog("Digite la cantidad de titulos del equipo"));      
                    Equipo equipo = new Equipo(nombreEquipo, nombreEstadio, cantTitulos);
                    listaEquipos.add(equipo);
                    break;
                }
                case 2:{
                    String nombre = JOptionPane.showInputDialog("Digite el nombre del nuevo jugador");
                    String posicion = JOptionPane.showInputDialog("Digite la posicion del nuevo jugador");
                    String cedula = JOptionPane.showInputDialog("Digite la cedula del nuevo jugador");
                    boolean buscar = buscarCedula(cedula, listaJugadores);
                    if(buscar == true){
                        JOptionPane.showMessageDialog(null, "Ya existe un jugador con esta cedula");
                    }else{
                        Jugador jugador = new Jugador(cedula, nombre, posicion);
                        listaJugadores.add(jugador);
                        JOptionPane.showMessageDialog(null, "Jugador creado con exito\n");
                    }
                    break;
                }
                case 3:{
                    String datos = listarJugadores(listaJugadores);
                    JOptionPane.showMessageDialog(null, datos);
                    break;
                }
                case 4:{
                    insertarJugadorEnEquipo(listaJugadores, listaEquipos);
                    break;
                }
                case 5:{
                    return;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
            }
        }while(true);
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
    
    public static void insertarJugadorEnEquipo(ArrayList<Jugador> jugadores, ArrayList<Equipo> equipos){
        
    }
    
    
}











