package model.data.dao;

import model.Jugador;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class JugadorDAO {

    public static void agregarJugador(DSLContext query, Jugador jugador) {
        query.insertInto(table("Jugador"), field("numero"), field("nombre"), field("posicion"), field("id_seleccion"))
                .values(jugador.getNumero(), jugador.getNombre(), jugador.getPosicion(), jugador.getSeleccion().getId())
                .execute();
    }

    public void modificarJugador(DSLContext query, String numero, String columnaTabla, Object dato) {
        query.update(table("Jugador"))
                .set(field(columnaTabla), dato)
                .where(field("numero").eq(numero))
                .execute();
    }

    public List<Jugador> obtenerJugador(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(table("Jugador")).where(field(columnaTabla).eq(dato)).fetch();
        return obtenerListaJugadores(resultados);
    }

    public List<Jugador> obtenerSeleccionJugador(DSLContext query) {
        Result resultados = query.select().from(table("Jugador")).fetch();
        return obtenerListaJugadores(resultados);
    }

    private List<Jugador> obtenerListaJugadores(Result resultados) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int fila = 0; fila < resultados.size(); fila++) {
            String numero = (String) resultados.getValue(fila, field("numero", String.class));
            String nombre = (String) resultados.getValue(fila, field("nombre", String.class));
            String posicion = (String) resultados.getValue(fila, field("posicion", String.class));
            jugadores.add(new Jugador(numero, nombre, posicion, null));
        }
        return jugadores;
    }

    public static String[][] obtenerJugadoresSeleccionID(DSLContext query, String id) {
        Result resultados = query.select().from(table("Jugador"))
                .join(table("Seleccion")).on(field("id").eq(field("id_seleccion")))
                .where(field("id_seleccion").eq(id)).fetch();
        return exportarDatos(resultados);
    }

    public static String[][] obtenerJugadorSeleccionNombre(DSLContext query, String nombre, String id) {
        Result resultados = query.select().from(table("Jugador"))
                .join(table("Seleccion")).on(field("id").eq(field("id_seleccion")))
                .where(field("nombre").eq(nombre)).and(field("id_seleccion").eq(id)).fetch();
        return exportarDatos(resultados);
    }

    private static String[][] exportarDatos(Result resultados) {
        String[][] datosResultado = new String[resultados.size()][4];
        for (int registro = 0; registro < resultados.size(); registro++) {
            datosResultado[registro][0] = (String) resultados.getValue(registro, field("nombre", String.class));
            datosResultado[registro][1] = (String) resultados.getValue(registro, field("numero", String.class));
            datosResultado[registro][2] = (String) resultados.getValue(registro, field("nombre-seleccion", String.class));
            datosResultado[registro][3] = (String) resultados.getValue(registro, field("posicion", String.class));
        }
        return datosResultado;
    }

    public static boolean validarExistenciaJugador(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(table("Jugador")).where(field(columnaTabla).eq(dato)).fetch();
        return resultados.size() >= 1;
    }
}



