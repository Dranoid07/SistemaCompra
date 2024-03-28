package com.controller;

import com.entity.OrdenCompra;
import com.facade.OrdenCompraFacade;
import com.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenCompraController")
@ViewScoped
public class OrdenCompraController extends AbstractController<OrdenCompra> {

    @Inject
    private ArticulosController articuloIdController;
    @Inject
    private MarcasController marcaIdController;
    @Inject
    private SolicitudArticulosController solicitudIdController;
    @Inject
    private UnidadesMedidaController unidadMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    public OrdenCompraController() {
        // Inform the Abstract parent controller of the concrete OrdenCompra Entity
        super(OrdenCompra.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articuloIdController.setSelected(null);
        marcaIdController.setSelected(null);
        solicitudIdController.setSelected(null);
        unidadMedidaIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Articulos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticuloId(ActionEvent event) {
        OrdenCompra selected = this.getSelected();
        if (selected != null && articuloIdController.getSelected() == null) {
            articuloIdController.setSelected(selected.getArticuloId());
        }
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarcaId(ActionEvent event) {
        OrdenCompra selected = this.getSelected();
        if (selected != null && marcaIdController.getSelected() == null) {
            marcaIdController.setSelected(selected.getMarcaId());
        }
    }

    /**
     * Sets the "selected" attribute of the SolicitudArticulos controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSolicitudId(ActionEvent event) {
        OrdenCompra selected = this.getSelected();
        if (selected != null && solicitudIdController.getSelected() == null) {
            solicitudIdController.setSelected(selected.getSolicitudId());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadMedidaId(ActionEvent event) {
        OrdenCompra selected = this.getSelected();
        if (selected != null && unidadMedidaIdController.getSelected() == null) {
            unidadMedidaIdController.setSelected(selected.getUnidadMedidaId());
        }
    }

}
