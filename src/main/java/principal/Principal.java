package principal;

import gui.VentanaBienvenida;
import model.data.DBGenerator;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException {
        DBGenerator.iniciarBD("FIFA");
        VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
    }
}

