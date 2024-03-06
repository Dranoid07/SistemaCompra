/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuelito
 */
@Entity
@Table(name = "solicitud_articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudArticulos.findAll", query = "SELECT s FROM SolicitudArticulos s")
    , @NamedQuery(name = "SolicitudArticulos.findById", query = "SELECT s FROM SolicitudArticulos s WHERE s.id = :id")
    , @NamedQuery(name = "SolicitudArticulos.findByEmpleadoSolicitante", query = "SELECT s FROM SolicitudArticulos s WHERE s.empleadoSolicitante = :empleadoSolicitante")
    , @NamedQuery(name = "SolicitudArticulos.findByFechaSolicitud", query = "SELECT s FROM SolicitudArticulos s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "SolicitudArticulos.findByCantidad", query = "SELECT s FROM SolicitudArticulos s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SolicitudArticulos.findByEstado", query = "SELECT s FROM SolicitudArticulos s WHERE s.estado = :estado")})
public class SolicitudArticulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "empleado_solicitante")
    private String empleadoSolicitante;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    @ManyToOne
    private Articulos articuloId;
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")
    @ManyToOne
    private UnidadesMedida unidadMedidaId;
    @OneToMany(mappedBy = "solicitudId")
    private Collection<OrdenCompra> ordenCompraCollection;

    public SolicitudArticulos() {
    }

    public SolicitudArticulos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpleadoSolicitante() {
        return empleadoSolicitante;
    }

    public void setEmpleadoSolicitante(String empleadoSolicitante) {
        this.empleadoSolicitante = empleadoSolicitante;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Articulos getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulos articuloId) {
        this.articuloId = articuloId;
    }

    public UnidadesMedida getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(UnidadesMedida unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    @XmlTransient
    public Collection<OrdenCompra> getOrdenCompraCollection() {
        return ordenCompraCollection;
    }

    public void setOrdenCompraCollection(Collection<OrdenCompra> ordenCompraCollection) {
        this.ordenCompraCollection = ordenCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudArticulos)) {
            return false;
        }
        SolicitudArticulos other = (SolicitudArticulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SolicitudArticulos[ id=" + id + " ]";
    }
    
}
