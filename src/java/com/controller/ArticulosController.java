package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Articulos;
import com.facade.ArticulosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "articulosController")
@ViewScoped
public class ArticulosController extends AbstractController<Articulos> {

    @Inject
    private MarcasController marcaIdController;
    @Inject
    private UnidadesMedidaController unidadMedidaIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolicitudArticulosCollectionEmpty;
    private boolean isOrdenCompraCollectionEmpty;

    public ArticulosController() {
        // Inform the Abstract parent controller of the concrete Articulos Entity
        super(Articulos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        marcaIdController.setSelected(null);
        unidadMedidaIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolicitudArticulosCollectionEmpty();
        this.setIsOrdenCompraCollectionEmpty();
    }

    public boolean getIsSolicitudArticulosCollectionEmpty() {
        return this.isSolicitudArticulosCollectionEmpty;
    }

    private void setIsSolicitudArticulosCollectionEmpty() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            this.isSolicitudArticulosCollectionEmpty = ejbFacade.isSolicitudArticulosCollectionEmpty(selected);
        } else {
            this.isSolicitudArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudArticulos
     * entities that are retrieved from Articulos?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SolicitudArticulos page
     */
    public String navigateSolicitudArticulosCollection() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudArticulos_items", ejbFacade.findSolicitudArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solicitudArticulos/index";
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarcaId(ActionEvent event) {
        Articulos selected = this.getSelected();
        if (selected != null && marcaIdController.getSelected() == null) {
            marcaIdController.setSelected(selected.getMarcaId());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadesMedida controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadMedidaId(ActionEvent event) {
        Articulos selected = this.getSelected();
        if (selected != null && unidadMedidaIdController.getSelected() == null) {
            unidadMedidaIdController.setSelected(selected.getUnidadMedidaId());
        }
    }

    public boolean getIsOrdenCompraCollectionEmpty() {
        return this.isOrdenCompraCollectionEmpty;
    }

    private void setIsOrdenCompraCollectionEmpty() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            this.isOrdenCompraCollectionEmpty = ejbFacade.isOrdenCompraCollectionEmpty(selected);
        } else {
            this.isOrdenCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenCompra entities that
     * are retrieved from Articulos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenCompra page
     */
    public String navigateOrdenCompraCollection() {
        Articulos selected = this.getSelected();
        if (selected != null) {
            ArticulosFacade ejbFacade = (ArticulosFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenCompra_items", ejbFacade.findOrdenCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenCompra/index";
    }

}
