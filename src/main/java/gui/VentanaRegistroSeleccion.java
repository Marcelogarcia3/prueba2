package gui;

import controller.SeleccionController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroSeleccion extends Ventana {
    private JLabel textoEncabezado, textoId, textoNombre, textoRankingFifa, textoIconoBandera;
    private JTextField campoIdSeleccion, campoNombre, campoIconoBandera;
    private JFormattedTextField campoRankingFifa;
    private JButton botonRegistrar, botonCancelar;


    public VentanaRegistroSeleccion(){
        super("Registro de Seleccion", 500, 520);
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombre();
        generarCampoIdSeleccion();
        generarCampoRankingFifa();
        generarCampoIconoBandera();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de Seleccion";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 100, 10, 290, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Seleccion";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Nombre Seleccion:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoIdSeleccion(){
        String textoId= "Id seleccion:";
        super.generarJLabel(this.textoId,textoId,20,100,150,20);
        this.campoIdSeleccion= super.generarJTextField(200,100,250,20);
        this.add(this.campoIdSeleccion);
    }
    private void generarCampoRankingFifa(){
        String textoRankingFifa= "Ranking Fifa:";
        super.generarJLabel(this.textoRankingFifa,textoRankingFifa,20,150,150,20);
        this.campoRankingFifa = super.generarJFormattedTextField(super.generarFormato(0),200,150,250,20);
        this.add(this.campoRankingFifa);
    }
    private void generarCampoIconoBandera(){
        String textoIconoBandera= "Icono Bandera:";
        super.generarJLabel(this.textoIconoBandera,textoIconoBandera,20,50,150,20);
        this.campoIconoBandera= super.generarJTextField(200,50,250,20);
        this.add(this.campoIconoBandera);
    }

    private boolean registrarSeleccion() throws ClassNotFoundException {
        if(this.campoIdSeleccion.getText().length()==0 || this.campoNombre.getText().length()==0 || this.campoRankingFifa.getText().length()==0 || this.campoIconoBandera.getText().length()==0){
            return false;
        }
        else{
            return SeleccionController.añadirSeleccion(this.campoNombre.getText(),this.campoIdSeleccion.getText(),Integer.parseInt(this.campoRankingFifa.getText()),this.campoIconoBandera.getText());

        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if(registrarSeleccion()) {
                    JOptionPane.showMessageDialog(this,"Seleccion registrada correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Seleccion ya ingresada o datos incorrectos");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }

    }

}

