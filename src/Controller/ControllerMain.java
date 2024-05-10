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
        this.vistaPrincipal.menuCalcularVacaciones.addActionListener(evt -> vacacionesActionPerformed(evt));
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
         JOptionPane.showMessageDialog(null, "Seleccionaste " + opcionSeleccionada, "Seleccion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void departamentoSelected(ActionEvent evt) {
        JComboBox<String> opcion = (JComboBox<String>) evt.getSource();
         String opcionSeleccionada = (String) opcion.getSelectedItem();
         this.modelTrabajador.setDepartamento(opcionSeleccionada);
         JOptionPane.showMessageDialog(null, "Seleccionaste " + opcionSeleccionada, "Seleccion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void vacacionesActionPerformed(ActionEvent evt) {
        
    }
}
