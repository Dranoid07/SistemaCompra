package com.controller;

import com.entity.SolicitudArticulos;
import com.entity.OrdenCompra;
import java.util.Collection;
import com.facade.SolicitudArticulosFacade;
import com.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solicitudArticulosController")
@ViewScoped
public class SolicitudArticulosController extends AbstractController<SolicitudArticulos> {

    @Inject
    private ArticulosController articuloIdController;
    @Inject
    private UnidadesMedidaController unidadMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isOrdenCompraCollectionEmpty;

    public SolicitudArticulosController() {
        // Inform the Abstract parent controller of the concrete SolicitudArticulos Entity
        super(SolicitudArticulos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articuloIdController.setSelected(null);
        unidadMedidaIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsOrdenCompraCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Articulos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticuloId(ActionEvent event) {
        SolicitudArticulos selected = this.getSelected();
        if (selected != null && articuloIdController.getSelected() == null) {
            articuloIdController.setSelected(selected.getArticuloId());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadMedidaId(ActionEvent event) {
        SolicitudArticulos selected = this.getSelected();
        if (selected != null && unidadMedidaIdController.getSelected() == null) {
            unidadMedidaIdController.setSelected(selected.getUnidadMedidaId());
        }
    }

    public boolean getIsOrdenCompraCollectionEmpty() {
        return this.isOrdenCompraCollectionEmpty;
    }

    private void setIsOrdenCompraCollectionEmpty() {
        SolicitudArticulos selected = this.getSelected();
        if (selected != null) {
            SolicitudArticulosFacade ejbFacade = (SolicitudArticulosFacade) this.getFacade();
            this.isOrdenCompraCollectionEmpty = ejbFacade.isOrdenCompraCollectionEmpty(selected);
        } else {
            this.isOrdenCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenCompra entities that
     * are retrieved from SolicitudArticulos and returns the navigation outcome.
     *
     * @return navigation outcome for OrdenCompra page
     */
    public String navigateOrdenCompraCollection() {
        SolicitudArticulos selected = this.getSelected();
        if (selected != null) {
            SolicitudArticulosFacade ejbFacade = (SolicitudArticulosFacade) this.getFacade();
            Collection<OrdenCompra> selectedOrdenCompraCollection = ejbFacade.findOrdenCompraCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenCompra_items", selectedOrdenCompraCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenCompra/index";
    }

}
