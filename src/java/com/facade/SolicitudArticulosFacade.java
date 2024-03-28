/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.SolicitudArticulos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.SolicitudArticulos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Articulos;
import com.entity.UnidadesMedida;
import com.entity.OrdenCompra;
import java.util.Collection;

/**
 *
 * @author harly
 */
@Stateless
public class SolicitudArticulosFacade extends AbstractFacade<SolicitudArticulos> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudArticulosFacade() {
        super(SolicitudArticulos.class);
    }

    public boolean isArticuloIdEmpty(SolicitudArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudArticulos> solicitudArticulos = cq.from(SolicitudArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudArticulos, entity), cb.isNotNull(solicitudArticulos.get(SolicitudArticulos_.articuloId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulos findArticuloId(SolicitudArticulos entity) {
        return this.getMergedEntity(entity).getArticuloId();
    }

    public boolean isUnidadMedidaIdEmpty(SolicitudArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudArticulos> solicitudArticulos = cq.from(SolicitudArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudArticulos, entity), cb.isNotNull(solicitudArticulos.get(SolicitudArticulos_.unidadMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesMedida findUnidadMedidaId(SolicitudArticulos entity) {
        return this.getMergedEntity(entity).getUnidadMedidaId();
    }

    public boolean isOrdenCompraCollectionEmpty(SolicitudArticulos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudArticulos> solicitudArticulos = cq.from(SolicitudArticulos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudArticulos, entity), cb.isNotEmpty(solicitudArticulos.get(SolicitudArticulos_.ordenCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenCompra> findOrdenCompraCollection(SolicitudArticulos entity) {
        SolicitudArticulos mergedEntity = this.getMergedEntity(entity);
        Collection<OrdenCompra> ordenCompraCollection = mergedEntity.getOrdenCompraCollection();
        ordenCompraCollection.size();
        return ordenCompraCollection;
    }
    
}
