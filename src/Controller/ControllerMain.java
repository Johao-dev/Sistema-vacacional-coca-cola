package Controller;

import Model.*;
import View.ViewBienvenida;
import View.ViewMain;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ControllerMain {
    Trabajador modelTrabajador;
    AtencionCliente modelCliente;
    Logistica modelLogistica;
    Gerencia modelGerencia;
    ViewMain vistaPrincipal;
    ViewBienvenida vistaBienvenida;
    
    public ControllerMain(Trabajador tr, AtencionCliente cliente, Logistica logistica, Gerencia gerencia, ViewMain main, ViewBienvenida wel) {
        this.modelTrabajador = tr;
        this.modelCliente = cliente;
        this.modelLogistica = logistica;
        this.modelGerencia = gerencia;
        this.vistaPrincipal = main;
        this.vistaBienvenida = wel;
        configListeners();
    }
    
    private void configListeners() {
        //LIstener de la barra de menu
        this.vistaPrincipal.menuOpcionesFondoPredeterminado.addActionListener(evt -> fondoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesFondoOscuro.addActionListener(evt -> fondoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesNuevo.addActionListener(evt -> opcionNuevoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesCerrarSesion.addActionListener(evt -> opcionCerrarSesionActionPerformed(evt));
        this.vistaPrincipal.menuCalcularVacaciones.addActionListener(evt -> calcularVacacionesActionPerformed(evt));
        this.vistaPrincipal.menuAcercaDeProyecto.addActionListener(evt -> acercaDeActionPerformed(evt));
        this.vistaPrincipal.menuAcercaDeDesarrollador.addActionListener(evt -> acercaDeActionPerformed(evt));
        
        //Listeners para los JComboBox
        this.vistaPrincipal.cbbDepartamento.addActionListener(evt -> servicioSelected(evt));
        this.vistaPrincipal.cbbAntiguedad.addActionListener(evt -> departamentoSelected(evt));
    }
    
    private void fondoActionPerformed(ActionEvent evt) {
        JMenuItem menuItem = (JMenuItem) evt.getSource();
        if (menuItem == this.vistaPrincipal.menuOpcionesFondoPredeterminado) {
            this.vistaPrincipal.panelPrincipal.setBackground(Color.RED);
            this.vistaPrincipal.panelDatosPersonales.setBackground(Color.red);
            this.vistaPrincipal.panelDatosServicio.setBackground(Color.red);
        } else if (menuItem == this.vistaPrincipal.menuOpcionesFondoOscuro) {
            this.vistaPrincipal.panelPrincipal.setBackground(Color.BLACK);
            this.vistaPrincipal.panelDatosPersonales.setBackground(Color.BLACK);
            this.vistaPrincipal.panelDatosServicio.setBackground(Color.BLACK);
        }
    }
    
    private void opcionCerrarSesionActionPerformed(ActionEvent evt) {
        this.vistaPrincipal.dispose();
        this.vistaBienvenida.setVisible(true);
    }
    
    private void opcionNuevoActionPerformed(ActionEvent evt) {
        //datos personales
        this.vistaPrincipal.txtnombrePrincipal.setText(null);
        this.vistaPrincipal.txtApellidoMaterno.setText(null);
        this.vistaPrincipal.txtApellidoPaterno.setText(null);
        
        //datos del servicio
        this.vistaPrincipal.cbbDepartamento.setSelectedIndex(0);
        this.vistaPrincipal.cbbAntiguedad.setSelectedIndex(0);
    }
    
    private void acercaDeActionPerformed(ActionEvent evt) {
        JMenuItem menuItem = (JMenuItem) evt.getSource();
        if (menuItem == this.vistaPrincipal.menuAcercaDeProyecto) {
            JOptionPane.showMessageDialog(null, "Proyecto final del curso Java desde cero del canal de la Geekipedia de Ernesto. Link a su canal: https://www.youtube.com/@LaGeekipediaDeErnesto", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
        } else if (menuItem == this.vistaPrincipal.menuAcercaDeDesarrollador) {
            JOptionPane.showMessageDialog(null, "El desarrollador de este proyecto se llama Johao. Link de su Github: https://github.com/Johao-dev", "Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void servicioSelected(ActionEvent evt) {
         JComboBox<String> opcion = (JComboBox<String>) evt.getSource();
         String opcionSeleccionada = (String) opcion.getSelectedItem();
         this.modelTrabajador.setAñosServicio(opcionSeleccionada);
    }
    
    private void departamentoSelected(ActionEvent evt) {
        JComboBox<String> opcion = (JComboBox<String>) evt.getSource();
         String opcionSeleccionada = (String) opcion.getSelectedItem();
         this.modelTrabajador.setDepartamento(opcionSeleccionada);
    }
    
    private void calcularVacacionesActionPerformed(ActionEvent evt) {
        //recogiendo los datos
        String nombres = this.vistaPrincipal.txtnombrePrincipal.getText();
        String apellidoPaterno = this.vistaPrincipal.txtApellidoPaterno.getText();
        String apellidoMaterno = this.vistaPrincipal.txtApellidoMaterno.getText();
        //String departamentoSeleccionado = (String) this.vistaPrincipal.cbbDepartamento.getSelectedItem();
        //String antiguedadSeleccionado = (String) this.vistaPrincipal.cbbAntiguedad.getSelectedItem();
        
        //enviando datos al modelo
        this.modelTrabajador.setNombres(nombres);
        this.modelTrabajador.setApellidoPaterno(apellidoPaterno);
        this.modelTrabajador.setApellidoMaterno(apellidoMaterno);
        //this.modelTrabajador.setAñosServicio(antiguedadSeleccionado);
        //this.modelTrabajador.setDepartamento(departamentoSeleccionado);
    }
}
