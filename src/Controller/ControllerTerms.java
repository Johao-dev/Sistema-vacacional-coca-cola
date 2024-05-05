package Controller;

import View.ViewMain;
import View.ViewBienvenida;
import View.ViewTermsAndCond;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class ControllerTerms {
    private ViewMain vistaPrincipal;
    private ViewBienvenida vistaBienvenida;
    private ViewTermsAndCond vistaTerminos;

    public ControllerTerms(ViewTermsAndCond vistaTerminos, ViewMain vistaPrincipal, ViewBienvenida vistaBienvenida) {
	this.vistaTerminos = vistaTerminos;
	this.vistaPrincipal = vistaPrincipal;
	this.vistaBienvenida = vistaBienvenida;
	configListeners();
    }

    private void configListeners(){
        this.vistaTerminos.btnContinuar.setEnabled(false);
	this.vistaTerminos.btnContinuar.addActionListener(evt -> btnContinuarActionPerformed(evt));
	this.vistaTerminos.btnNoAceptar.addActionListener(evt -> btnNoAceptarActionPerformed(evt));
	this.vistaTerminos.chbTerminos.addItemListener(evt -> chbTerminosStateChanged(evt));
    }
    
    private void btnContinuarActionPerformed(ActionEvent evt) {
        this.vistaTerminos.dispose();
        this.vistaPrincipal.setVisible(true);
    }

    private void btnNoAceptarActionPerformed(ActionEvent evt) {
        this.vistaTerminos.dispose();
        this.vistaBienvenida.setVisible(true);
    }

    private void chbTerminosStateChanged(ItemEvent evt) {
	if (evt.getStateChange() == ItemEvent.SELECTED) {
	    this.vistaTerminos.btnContinuar.setEnabled(true);
	    this.vistaTerminos.btnNoAceptar.setEnabled(false);
	} else {
	    this.vistaTerminos.btnContinuar.setEnabled(false);
	    this.vistaTerminos.btnNoAceptar.setEnabled(true);
	}
    }
}