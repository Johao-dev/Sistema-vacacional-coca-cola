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

    String nombres;
    String apellidoPaterno;
    String apellidoMaterno;
    String departamentoSeleccionado;
    String antiguedadSeleccionada;

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
        //configurando listener de cada opcion del menu
        this.vistaPrincipal.menuOpcionesFondoPredeterminado.addActionListener(evt -> fondoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesFondoOscuro.addActionListener(evt -> fondoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesNuevo.addActionListener(evt -> opcionNuevoActionPerformed(evt));
        this.vistaPrincipal.menuOpcionesCerrarSesion.addActionListener(evt -> opcionCerrarSesionActionPerformed(evt));
        this.vistaPrincipal.menuCalcularVacaciones.addActionListener(evt -> calcularVacacionesActionPerformed(evt));
        this.vistaPrincipal.menuAcercaDeProyecto.addActionListener(evt -> acercaDeActionPerformed(evt));
        this.vistaPrincipal.menuAcercaDeDesarrollador.addActionListener(evt -> acercaDeActionPerformed(evt));
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
        
        //resultado
        this.vistaPrincipal.txtResultados.setText(null);
    }

    private void acercaDeActionPerformed(ActionEvent evt) {
        JMenuItem menuItem = (JMenuItem) evt.getSource();
        if (menuItem == this.vistaPrincipal.menuAcercaDeProyecto) {
            JOptionPane.showMessageDialog(null, "Proyecto final del curso Java desde cero del canal de la Geekipedia de Ernesto. Link a su canal: https://www.youtube.com/@LaGeekipediaDeErnesto", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
        } else if (menuItem == this.vistaPrincipal.menuAcercaDeDesarrollador) {
            JOptionPane.showMessageDialog(null, "El desarrollador de este proyecto se llama Johao. Link de su Github: https://github.com/Johao-dev", "Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void recogerDatos() {
        this.nombres = this.vistaPrincipal.txtnombrePrincipal.getText();
        this.apellidoPaterno = this.vistaPrincipal.txtApellidoPaterno.getText();
        this.apellidoMaterno = this.vistaPrincipal.txtApellidoMaterno.getText();
        this.departamentoSeleccionado = (String) this.vistaPrincipal.cbbDepartamento.getSelectedItem();
        this.antiguedadSeleccionada = (String) this.vistaPrincipal.cbbAntiguedad.getSelectedItem();
    }

    private void enviarDatos() {
        this.modelTrabajador.setNombres(this.nombres);
        this.modelTrabajador.setApellidoPaterno(this.apellidoPaterno);
        this.modelTrabajador.setApellidoMaterno(this.apellidoMaterno);
        this.modelTrabajador.setAñosServicio(this.antiguedadSeleccionada);
        this.modelTrabajador.setDepartamento(this.departamentoSeleccionado);
    }

    private void calcularVacacionesActionPerformed(ActionEvent evt) {
        recogerDatos();
        enviarDatos();
        
        if (this.modelTrabajador.getDepartamento().equalsIgnoreCase("Atencion al cliente")) {
            esAtencionAlCliente(this.modelTrabajador.getAñosServicio());
        } else if (this.modelTrabajador.getDepartamento().equalsIgnoreCase("Logistica")) {
            esLogistica(this.modelTrabajador.getAñosServicio());
        } else if (this.modelTrabajador.getDepartamento().equalsIgnoreCase("Gerencia")) {
            esGerencia(this.modelTrabajador.getAñosServicio());
        }
    }
    
    private void esAtencionAlCliente(String servicio) {
        if (servicio.equalsIgnoreCase("1 año de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelCliente.getUnAño());
        } else if (servicio.equalsIgnoreCase("2 a 6 años de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelCliente.getDosAñosSeisAños());
        } else if (servicio.equalsIgnoreCase("7 años a mas de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelCliente.getMasDeSieteAños());
        }
    }

    private void esLogistica(String servicio) {
        if (servicio.equalsIgnoreCase("1 año de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelLogistica.getUnAño());
        } else if (servicio.equalsIgnoreCase("2 a 6 años de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelLogistica.getDosAñosSeisAños());
        } else if (servicio.equalsIgnoreCase("7 años a mas de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelLogistica.getMasDeSieteAños());
        }
    }
    
    private void esGerencia(String servicio) {
        if (servicio.equalsIgnoreCase("1 año de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelGerencia.getUnAño());
        } else if (servicio.equalsIgnoreCase("2 a 6 años de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelGerencia.getDosAñosSeisAños());
        } else if (servicio.equalsIgnoreCase("7 años a mas de servicio")) {
            this.vistaPrincipal.txtResultados.setText("El empleado " + this.modelTrabajador.getNombres() +
            " "+this.modelTrabajador.getApellidoPaterno() + " "+this.modelTrabajador.getApellidoMaterno() +
            "\nque trabaja en el departamento de " + this.modelTrabajador.getDepartamento() +
            "\ntiene derecho a " + this.modelGerencia.getMasDeSieteAños());
        }
    }
}