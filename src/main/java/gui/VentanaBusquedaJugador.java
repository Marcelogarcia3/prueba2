package gui;

import controller.JugadorController;
import controller.SeleccionController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaBusquedaJugador extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoSelccion, textoNombre;
    private JComboBox campoSeleccion;
    private JTextField campoNombre;

    public VentanaBusquedaJugador() throws ClassNotFoundException {
        super("Búsqueda de Jugador", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() throws ClassNotFoundException {
        generarCampoNombre();
        generarBotonBuscarJugador();
        generarBotonCancelar();
        generarListaSeleccion();
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre Jugador:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarListaSeleccion() throws ClassNotFoundException {
        super.generarJLabel(this.textoSelccion,"Seleccion:",20,100,150,20);
        this.campoSeleccion=super.generarListaDesplegable(SeleccionController.getIdSeleccion(),200,100, 250, 20);
        this.add(this.campoSeleccion);
    }
    private void generarBotonBuscarJugador() {
        String textoBoton= "Buscar Jugador";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] exportarDatos() throws ClassNotFoundException {
        if(this.campoNombre.getText().length()==0 && this.campoSeleccion.getSelectedItem().equals("Error no existen Selecciones")){
            JOptionPane.showMessageDialog(this,"Ingrese datos validos");
            return new String[0][0];
        }
        else if(this.campoNombre.getText().length()==0){
            return JugadorController.mostrarJugadoresPorSeleccion(this.campoSeleccion.getSelectedItem().toString());
        }
        else{
            return JugadorController.mostrarJugadoresPorNombre(this.campoSeleccion.getSelectedItem().toString(),this.campoNombre.getText());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"numero jugador","nombre Jugador","Seleccion","IdCarrera"};
            try {
                VentanaTabla ventanaTabla= new VentanaTabla(exportarDatos(),nombreColumnas);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonRegresar){
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }

    }
}

