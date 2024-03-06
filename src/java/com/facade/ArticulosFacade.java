/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.Articulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.Articulos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.SolicitudArticulos;
import com.entity.Marcas;
import com.entity.UnidadesMedida;
import com.entity.OrdenCompra;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class ArticulosFacade extends AbstractFacade<Articulos> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticulosFacade() {
        super(Articulos.class);
    }

    public boolean isSolicitudArticulosCollectionEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotEmpty(articulos.get(Articulos_.solicitudArticulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolicitudArticulos> findSolicitudArticulosCollection(Articulos entity) {
        return this.getMergedEntity(entity).getSolicitudArticulosCollection();
    }

    public boolean isMarcaIdEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotNull(articulos.get(Articulos_.marcaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findMarcaId(Articulos entity) {
        return this.getMergedEntity(entity).getMarcaId();
    }

    public boolean isUnidadMedidaIdEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotNull(articulos.get(Articulos_.unidadMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesMedida findUnidadMedidaId(Articulos entity) {
        return this.getMergedEntity(entity).getUnidadMedidaId();
    }

    public boolean isOrdenCompraCollectionEmpty(Articulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulos> articulos = cq.from(Articulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulos, entity), cb.isNotEmpty(articulos.get(Articulos_.ordenCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenCompra> findOrdenCompraCollection(Articulos entity) {
        return this.getMergedEntity(entity).getOrdenCompraCollection();
    }
    
}
