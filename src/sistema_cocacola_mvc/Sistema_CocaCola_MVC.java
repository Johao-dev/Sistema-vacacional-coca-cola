package sistema_cocacola_mvc;

import Model.*;
import View.*;
import Controller.*;

public class Sistema_CocaCola_MVC {

    public static void main(String[] args) {
        //Instancia del modelo trabajador
        Trabajador modeloTrabajador = new Trabajador();
        AtencionCliente modelCliente = new AtencionCliente();
        Logistica modelLogistica = new Logistica();
        Gerencia modelGerencia = new Gerencia();

        //instanciando las vistas
        ViewTermsAndCond vistaTerminos = new ViewTermsAndCond();
        ViewBienvenida vistaBienvenida = new ViewBienvenida();
        ViewMain vistaPrincipal = new ViewMain();

        //instanciando los controladores 
        ControllerBienvenida ctrlBienvenida = new ControllerBienvenida(modeloTrabajador, vistaBienvenida, vistaTerminos);
        ControllerTerms ctrlTerminos = new ControllerTerms(vistaTerminos, vistaPrincipal, vistaBienvenida);
        ControllerMain ctrlMain = new ControllerMain(modeloTrabajador, modelCliente, modelLogistica, modelGerencia, vistaPrincipal, vistaBienvenida);

        //Asignando controladores a sus vistas respectivas
        vistaBienvenida.setController(ctrlBienvenida);
        vistaTerminos.setController(ctrlTerminos);
        vistaPrincipal.setController(ctrlMain);
        vistaBienvenida.setVisible(true);
    }

}
