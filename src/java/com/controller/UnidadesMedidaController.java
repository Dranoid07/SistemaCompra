package com.controller;

import com.controller.util.MobilePageController;
import com.entity.UnidadesMedida;
import com.facade.UnidadesMedidaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "unidadesMedidaController")
@ViewScoped
public class UnidadesMedidaController extends AbstractController<UnidadesMedida> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolicitudArticulosCollectionEmpty;
    private boolean isArticulosCollectionEmpty;
    private boolean isOrdenCompraCollectionEmpty;

    public UnidadesMedidaController() {
        // Inform the Abstract parent controller of the concrete UnidadesMedida Entity
        super(UnidadesMedida.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolicitudArticulosCollectionEmpty();
        this.setIsArticulosCollectionEmpty();
        this.setIsOrdenCompraCollectionEmpty();
    }

    public boolean getIsSolicitudArticulosCollectionEmpty() {
        return this.isSolicitudArticulosCollectionEmpty;
    }

    private void setIsSolicitudArticulosCollectionEmpty() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            this.isSolicitudArticulosCollectionEmpty = ejbFacade.isSolicitudArticulosCollectionEmpty(selected);
        } else {
            this.isSolicitudArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudArticulos
     * entities that are retrieved from UnidadesMedida?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SolicitudArticulos page
     */
    public String navigateSolicitudArticulosCollection() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudArticulos_items", ejbFacade.findSolicitudArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solicitudArticulos/index";
    }

    public boolean getIsArticulosCollectionEmpty() {
        return this.isArticulosCollectionEmpty;
    }

    private void setIsArticulosCollectionEmpty() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            this.isArticulosCollectionEmpty = ejbFacade.isArticulosCollectionEmpty(selected);
        } else {
            this.isArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Articulos entities that
     * are retrieved from UnidadesMedida?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Articulos page
     */
    public String navigateArticulosCollection() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Articulos_items", ejbFacade.findArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/articulos/index";
    }

    public boolean getIsOrdenCompraCollectionEmpty() {
        return this.isOrdenCompraCollectionEmpty;
    }

    private void setIsOrdenCompraCollectionEmpty() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            this.isOrdenCompraCollectionEmpty = ejbFacade.isOrdenCompraCollectionEmpty(selected);
        } else {
            this.isOrdenCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenCompra entities that
     * are retrieved from UnidadesMedida?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenCompra page
     */
    public String navigateOrdenCompraCollection() {
        UnidadesMedida selected = this.getSelected();
        if (selected != null) {
            UnidadesMedidaFacade ejbFacade = (UnidadesMedidaFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenCompra_items", ejbFacade.findOrdenCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenCompra/index";
    }

}
