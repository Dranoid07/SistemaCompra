/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuelito
 */
@Entity
@Table(name = "orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")
    , @NamedQuery(name = "OrdenCompra.findByNumeroOrden", query = "SELECT o FROM OrdenCompra o WHERE o.numeroOrden = :numeroOrden")
    , @NamedQuery(name = "OrdenCompra.findByFechaOrden", query = "SELECT o FROM OrdenCompra o WHERE o.fechaOrden = :fechaOrden")
    , @NamedQuery(name = "OrdenCompra.findByEstado", query = "SELECT o FROM OrdenCompra o WHERE o.estado = :estado")
    , @NamedQuery(name = "OrdenCompra.findByCantidad", query = "SELECT o FROM OrdenCompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenCompra.findByCostoUnitario", query = "SELECT o FROM OrdenCompra o WHERE o.costoUnitario = :costoUnitario")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_orden")
    private Integer numeroOrden;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costo_unitario")
    private BigInteger costoUnitario;
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    @ManyToOne
    private Articulos articuloId;
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    @ManyToOne
    private Marcas marcaId;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id")
    @ManyToOne
    private SolicitudArticulos solicitudId;
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")
    @ManyToOne
    private UnidadesMedida unidadMedidaId;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Integer getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Integer numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigInteger costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Articulos getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulos articuloId) {
        this.articuloId = articuloId;
    }

    public Marcas getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marcas marcaId) {
        this.marcaId = marcaId;
    }

    public SolicitudArticulos getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(SolicitudArticulos solicitudId) {
        this.solicitudId = solicitudId;
    }

    public UnidadesMedida getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(UnidadesMedida unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroOrden != null ? numeroOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.numeroOrden == null && other.numeroOrden != null) || (this.numeroOrden != null && !this.numeroOrden.equals(other.numeroOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.OrdenCompra[ numeroOrden=" + numeroOrden + " ]";
    }
    
}
