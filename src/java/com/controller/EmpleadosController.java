package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Empleados;
import com.facade.EmpleadosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController extends AbstractController<Empleados> {

    @Inject
    private MobilePageController mobilePageController;

    public EmpleadosController() {
        // Inform the Abstract parent controller of the concrete Empleados Entity
        super(Empleados.class);
    }

}
