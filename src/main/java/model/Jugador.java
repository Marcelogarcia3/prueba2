package model;


public class Jugador {

    private String numero;

    private String nombre;

    private String posicion;


    private Seleccion seleccion;

    public Jugador(String numero, String nombre, String posicion, Seleccion seleccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
        this.seleccion = seleccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", seleccion=" + seleccion +
                '}';
    }
}