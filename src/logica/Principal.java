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
        double pi = Math.PI;
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
        ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        do{
            op = new Integer(JOptionPane.showInputDialog("DIGITE UNA OPCION\n"
                    + "1. Crear nuevo Equipo\n"
                    + "2. Ver lista de equipos\n"
                    + "3. Crear nuevo Jugador\n"
                    + "4. Ver lista de jugadores\n"
                    + "5. Insertar jugador a equipo\n"
                    + "6. Ver Datos completos de un equipo\n"
                    + "7. Salir\n"));
            switch(op){
                case 1:{
                    String nombreEquipo = JOptionPane.showInputDialog("Digite el nombre del nuevo Equipo");
                    String nombreEstadio = JOptionPane.showInputDialog("Digite el nombre del estadio del nuevo equipo");
                    int cantTitulos = new Integer(JOptionPane.showInputDialog("Digite la cantidad de titulos del equipo"));      
                    boolean buscarE = Equipo.buscarEquipo(listaEquipos, nombreEquipo);
                    if( !buscarE ){
                        Equipo equipo = new Equipo(nombreEquipo, nombreEstadio, cantTitulos);
                        listaEquipos.add(equipo);
                        JOptionPane.showMessageDialog(null, "Equipo creado con exito.");
                    }else{
                        JOptionPane.showMessageDialog(null, "Este nombre ya existe en la lista de equipos\n"
                                                            + "No se pudo crear el equipo.");
                    }
                    break;
                }
                case 2:{
                    String datos = listarEquipos(listaEquipos);
                    JOptionPane.showMessageDialog(null, "Datos de los equipos\n" + datos);
                    break;
                }
                case 3:{
                    String nombre = JOptionPane.showInputDialog("Digite el nombre del nuevo jugador");
                    String posicion = JOptionPane.showInputDialog("Digite la posicion del nuevo jugador");
                    String cedula = JOptionPane.showInputDialog("Digite la cedula del nuevo jugador");
                    boolean buscar = Jugador.buscarCedula(cedula, listaJugadores);
                    if(buscar == true){
                        JOptionPane.showMessageDialog(null, "Ya existe un jugador con esta cedula");
                    }else{
                        Jugador jugador = new Jugador(cedula, nombre, posicion);
                        listaJugadores.add(jugador);
                        JOptionPane.showMessageDialog(null, "Jugador creado con exito\n");
                    }
                    break;
                }
                case 4:{
                    String datos = listarJugadores(listaJugadores);
                    JOptionPane.showMessageDialog(null, "Datos de los jugadores\n" + datos);
                    break;
                }
                case 5:{
                    String cedula = JOptionPane.showInputDialog("Digite la cedula del jugador a insertar");
                    Jugador jugador = Jugador.buscarJugadorPorCedula(cedula, listaJugadores);
                    if(jugador != null){
                        String nombreEquipo = JOptionPane.showInputDialog("Digite el nombre del equipo");
                        Equipo aux = Equipo.buscarEquipoPorNombre(listaEquipos, nombreEquipo);
                        if(aux != null){
                            boolean buscarLista = Equipo.buscarJugadorEnLista(listaEquipos, jugador);
                            if(buscarLista == false){
                                int tipoJugador = new Integer(
                                        JOptionPane.showInputDialog("Seleccoine el tipo de jugador\n"
                                        + "1. Titular\n"
                                        + "2. Suplente\n"));
                                aux.insertarJugador(jugador, tipoJugador);
                            }else{
                                JOptionPane.showMessageDialog(null, "Este jugador ya le pertenece a un equipo");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No existe un equipo con este nombre");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Esta cedula no existe en la lista de jugadores");
                    }
                    break;
                }
                case 6:{
                    String nombreEquipo = JOptionPane.showInputDialog("Escribe el nombre del equipo");
                    Equipo equipo = Equipo.buscarEquipoPorNombre(listaEquipos, nombreEquipo);
                    String datos = "";
                    if(equipo != null){
                        datos = equipo.datosEquipo();
                        JOptionPane.showMessageDialog(null, datos);
                    }else{
                        JOptionPane.showMessageDialog(null, "No existe un equipo con este nombre");
                    }
                    break;
                }
                case 7:{
                    return;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
            }
        }while(true);
    }
    
    public static String listarEquipos(ArrayList<Equipo> equipos){
        Equipo e = null;
        String datos = "";
        for(int i=0; i<equipos.size();i++){
            e = equipos.get(i);
            datos += e.toString();
        }
        return datos;
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
    
    
    
    public static void insertarJugadorEnEquipo(ArrayList<Jugador> jugadores, ArrayList<Equipo> equipos){
        
    }
    
    
}











