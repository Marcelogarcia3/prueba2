package controller;

import model.Seleccion;
import model.data.dao.SeleccionDAO;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;

public class SeleccionController {

    public static boolean añadirSeleccion(String nombreSeleccion, String idSeleccion, int rankingFifa, String iconoBandera) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Seleccion");
        if(!SeleccionDAO.validarExistenciaSeleccion(query,"id",idSeleccion)){
            Seleccion seleccion = new Seleccion(nombreSeleccion,idSeleccion,rankingFifa, iconoBandera);
            SeleccionDAO.agregarSeleccion(query, seleccion);
            DBConnector.closeConnection();
            return true;
        }
        else{
            return false;
        }
    }
    public static Object[] getIdSeleccion() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("FIFA");
        Object[] seleciones = SeleccionDAO.getIDSeleccion(query);
        Object[] selecciones = SeleccionDAO.getIDSeleccion(query);
        DBConnector.closeConnection();
        return selecciones;
    }

}

