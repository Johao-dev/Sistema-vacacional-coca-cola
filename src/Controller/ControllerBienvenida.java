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

    public ControllerBienvenida(Trabajador trabajador, ViewBienvenida view) {
        this.modeloTrabajador = trabajador;
        this.vistaBienvenida = view;

        this.vistaBienvenida.btningresar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaBienvenida.btningresar) {
            if (vistaBienvenida.txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                this.modeloTrabajador.setNombres(vistaBienvenida.txtnombre.getText());
                vistaBienvenida.dispose();
                vistaTerminosYCondiciones.setVisible(true);
            }
        }
    }
}