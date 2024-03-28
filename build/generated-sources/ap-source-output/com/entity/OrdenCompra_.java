package com.entity;

import com.entity.Articulos;
import com.entity.Marcas;
import com.entity.SolicitudArticulos;
import com.entity.UnidadesMedida;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-28T13:10:54")
@StaticMetamodel(OrdenCompra.class)
public class OrdenCompra_ { 

    public static volatile SingularAttribute<OrdenCompra, Integer> numeroOrden;
    public static volatile SingularAttribute<OrdenCompra, Articulos> articuloId;
    public static volatile SingularAttribute<OrdenCompra, String> estado;
    public static volatile SingularAttribute<OrdenCompra, SolicitudArticulos> solicitudId;
    public static volatile SingularAttribute<OrdenCompra, Marcas> marcaId;
    public static volatile SingularAttribute<OrdenCompra, UnidadesMedida> unidadMedidaId;
    public static volatile SingularAttribute<OrdenCompra, Integer> cantidad;
    public static volatile SingularAttribute<OrdenCompra, BigInteger> costoUnitario;
    public static volatile SingularAttribute<OrdenCompra, Date> fechaOrden;

}