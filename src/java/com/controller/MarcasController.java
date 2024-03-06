package com.controller;

import com.controller.util.MobilePageController;
import com.entity.Marcas;
import com.facade.MarcasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcasController")
@ViewScoped
public class MarcasController extends AbstractController<Marcas> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isArticulosCollectionEmpty;
    private boolean isOrdenCompraCollectionEmpty;

    public MarcasController() {
        // Inform the Abstract parent controller of the concrete Marcas Entity
        super(Marcas.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsArticulosCollectionEmpty();
        this.setIsOrdenCompraCollectionEmpty();
    }

    public boolean getIsArticulosCollectionEmpty() {
        return this.isArticulosCollectionEmpty;
    }

    private void setIsArticulosCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isArticulosCollectionEmpty = ejbFacade.isArticulosCollectionEmpty(selected);
        } else {
            this.isArticulosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Articulos entities that
     * are retrieved from Marcas?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Articulos page
     */
    public String navigateArticulosCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Articulos_items", ejbFacade.findArticulosCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/articulos/index";
    }

    public boolean getIsOrdenCompraCollectionEmpty() {
        return this.isOrdenCompraCollectionEmpty;
    }

    private void setIsOrdenCompraCollectionEmpty() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isOrdenCompraCollectionEmpty = ejbFacade.isOrdenCompraCollectionEmpty(selected);
        } else {
            this.isOrdenCompraCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenCompra entities that
     * are retrieved from Marcas?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for OrdenCompra page
     */
    public String navigateOrdenCompraCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenCompra_items", ejbFacade.findOrdenCompraCollection(selected));
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ordenCompra/index";
    }

}
