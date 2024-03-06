/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.UnidadesMedida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.UnidadesMedida_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.SolicitudArticulos;
import com.entity.Articulos;
import com.entity.OrdenCompra;
import java.util.Collection;

/**
 *
 * @author manuelito
 */
@Stateless
public class UnidadesMedidaFacade extends AbstractFacade<UnidadesMedida> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadesMedidaFacade() {
        super(UnidadesMedida.class);
    }

    public boolean isSolicitudArticulosCollectionEmpty(UnidadesMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesMedida> unidadesMedida = cq.from(UnidadesMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesMedida, entity), cb.isNotEmpty(unidadesMedida.get(UnidadesMedida_.solicitudArticulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolicitudArticulos> findSolicitudArticulosCollection(UnidadesMedida entity) {
        return this.getMergedEntity(entity).getSolicitudArticulosCollection();
    }

    public boolean isArticulosCollectionEmpty(UnidadesMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesMedida> unidadesMedida = cq.from(UnidadesMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesMedida, entity), cb.isNotEmpty(unidadesMedida.get(UnidadesMedida_.articulosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Articulos> findArticulosCollection(UnidadesMedida entity) {
        return this.getMergedEntity(entity).getArticulosCollection();
    }

    public boolean isOrdenCompraCollectionEmpty(UnidadesMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadesMedida> unidadesMedida = cq.from(UnidadesMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadesMedida, entity), cb.isNotEmpty(unidadesMedida.get(UnidadesMedida_.ordenCompraCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<OrdenCompra> findOrdenCompraCollection(UnidadesMedida entity) {
        return this.getMergedEntity(entity).getOrdenCompraCollection();
    }
    
}
