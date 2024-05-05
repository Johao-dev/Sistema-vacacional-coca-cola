package Controller;

import Model.Trabajador;
import View.ViewBienvenida;
import View.ViewTermsAndCond;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerBienvenida implements ActionListener {

    private Trabajador modeloTrabajador;
    private ViewBienvenida vistaBienvenida;
    private ViewTermsAndCond vistaTerminosYCondiciones;
    
    public ControllerBienvenida(Trabajador modeloTrabajador, ViewBienvenida vistaBienvenida, ViewTermsAndCond vistaTerminos) {
        this.modeloTrabajador = modeloTrabajador;
        this.vistaBienvenida = vistaBienvenida;
        this.vistaTerminosYCondiciones = vistaTerminos;
        configListener();
    }
    
    private void configListener() {
        this.vistaBienvenida.btningresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaBienvenida.btningresar) {
            if (this.vistaBienvenida.txtnombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar su nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                this.modeloTrabajador.setNombres(this.vistaBienvenida.txtnombre.getText());
                this.vistaBienvenida.dispose();
                this.vistaTerminosYCondiciones.setVisible(true);
            }
        }
    }
}