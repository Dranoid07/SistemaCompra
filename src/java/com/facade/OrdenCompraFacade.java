/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entity.OrdenCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.OrdenCompra_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entity.Articulos;
import com.entity.Marcas;
import com.entity.SolicitudArticulos;
import com.entity.UnidadesMedida;

/**
 *
 * @author harly
 */
@Stateless
public class OrdenCompraFacade extends AbstractFacade<OrdenCompra> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenCompraFacade() {
        super(OrdenCompra.class);
    }

    public boolean isArticuloIdEmpty(OrdenCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenCompra> ordenCompra = cq.from(OrdenCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenCompra, entity), cb.isNotNull(ordenCompra.get(OrdenCompra_.articuloId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulos findArticuloId(OrdenCompra entity) {
        return this.getMergedEntity(entity).getArticuloId();
    }

    public boolean isMarcaIdEmpty(OrdenCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenCompra> ordenCompra = cq.from(OrdenCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenCompra, entity), cb.isNotNull(ordenCompra.get(OrdenCompra_.marcaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findMarcaId(OrdenCompra entity) {
        return this.getMergedEntity(entity).getMarcaId();
    }

    public boolean isSolicitudIdEmpty(OrdenCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenCompra> ordenCompra = cq.from(OrdenCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenCompra, entity), cb.isNotNull(ordenCompra.get(OrdenCompra_.solicitudId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SolicitudArticulos findSolicitudId(OrdenCompra entity) {
        return this.getMergedEntity(entity).getSolicitudId();
    }

    public boolean isUnidadMedidaIdEmpty(OrdenCompra entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenCompra> ordenCompra = cq.from(OrdenCompra.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenCompra, entity), cb.isNotNull(ordenCompra.get(OrdenCompra_.unidadMedidaId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadesMedida findUnidadMedidaId(OrdenCompra entity) {
        return this.getMergedEntity(entity).getUnidadMedidaId();
    }
    
}
