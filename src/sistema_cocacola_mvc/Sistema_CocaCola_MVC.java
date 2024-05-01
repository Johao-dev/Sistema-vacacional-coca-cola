package sistema_cocacola_mvc;

import Model.*;
import View.*;
import Controller.*;

public class Sistema_CocaCola_MVC {

    public static void main(String[] args) {
        Trabajador modeloTrabajador = new Trabajador();
        ViewBienvenida vistaBienvenida = new ViewBienvenida();
        ControllerBienvenida ctrlBienvenida = new ControllerBienvenida(modeloTrabajador, vistaBienvenida);
        vistaBienvenida.setVisible(true);
        vistaBienvenida.setController(ctrlBienvenida);
    }
    
}
