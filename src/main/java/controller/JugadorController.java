package controller;

import model.Seleccion;
import model.Jugador;
import model.data.dao.SeleccionDAO;
import model.data.DBConnector;
import model.data.DBGenerator;
import model.data.dao.JugadorDAO;
import org.jooq.DSLContext;

public class JugadorController {

    public static boolean registrarJugador(String nombre, String numero, String posicion, String idSeleccion) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("FIFA");
        if(!JugadorDAO.validarExistenciaJugador(query,"numero",numero)){
            Seleccion seleccion = (Seleccion) SeleccionDAO.buscarSeleccion(query, "id", idSeleccion);
            Jugador jugador = new Jugador(numero,nombre,posicion, seleccion);
            JugadorDAO.agregarJugador(query, jugador);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }
    public static String[][] mostrarJugadoresPorSeleccion(String id) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("FIFA");
        String[][] datosJugadores= JugadorDAO.obtenerJugadoresSeleccionID(query,id);
        DBConnector.closeConnection();
        return datosJugadores;
    }
    public static String[][] mostrarJugadoresPorNombre(String id, String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("FIFA");
        String[][] datosJugadores = JugadorDAO.obtenerJugadorSeleccionNombre(query,nombre,id);
        DBConnector.closeConnection();
        return datosJugadores;
    }
}

