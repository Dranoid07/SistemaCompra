package com.entity;

import com.entity.Articulos;
import com.entity.OrdenCompra;
import com.entity.UnidadesMedida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-28T13:10:54")
@StaticMetamodel(SolicitudArticulos.class)
public class SolicitudArticulos_ { 

    public static volatile SingularAttribute<SolicitudArticulos, Articulos> articuloId;
    public static volatile SingularAttribute<SolicitudArticulos, String> estado;
    public static volatile SingularAttribute<SolicitudArticulos, Date> fechaSolicitud;
    public static volatile SingularAttribute<SolicitudArticulos, String> empleadoSolicitante;
    public static volatile SingularAttribute<SolicitudArticulos, UnidadesMedida> unidadMedidaId;
    public static volatile SingularAttribute<SolicitudArticulos, Integer> id;
    public static volatile SingularAttribute<SolicitudArticulos, Integer> cantidad;
    public static volatile CollectionAttribute<SolicitudArticulos, OrdenCompra> ordenCompraCollection;

}