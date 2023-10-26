package model.data.dao;

import model.Seleccion;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class SeleccionDAO {
    public static void agregarSeleccion(DSLContext query, Seleccion seleccion){
        Table tablaSeleccion= table(name("seleccion"));
        Field[] columnas = tablaSeleccion.fields("nombre_seleccion","id","ranking-fifa", "icono-bandera");
        query.insertInto(tablaSeleccion, columnas[0], columnas[1],columnas[2],columnas[3])
                .values(seleccion.getNombreSeleccion(), seleccion.getId(), seleccion.getRankingFifa(), seleccion.getIconoBandera())
                .execute();
    }
    public static boolean validarExistenciaSeleccion(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("seleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public static Seleccion buscarSeleccion(DSLContext query, Object dato){
        Result resultados= (Result) buscarSeleccion(query,"id",dato);
        String idSeleccion = (String) resultados.getValue(0,"id");
        String nombreSeleccion = (String) resultados.getValue(0,"nombre_seleccion");
        int rankingFifa = (int) resultados.getValue(0,"ranking-fifa");
        String iconoBandera = (String) resultados.getValue(0,"icono-bandera");
        return new Seleccion(nombreSeleccion,idSeleccion,rankingFifa,iconoBandera);
    }

    public static List buscarSeleccion(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("seleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return resultados;
    }
    public static Object[] getIDSeleccion(DSLContext query){
        Table Seleccion= DSL.table("seleccion");
        Result resultados = query.select(Seleccion.field("id")).from(Seleccion).fetch();
        if(resultados.size()==0){
            return new String[]{"Error no existen selecciones"};
        }
        else {
            return resultados.getValues("id").toArray();
        }
    }

}

