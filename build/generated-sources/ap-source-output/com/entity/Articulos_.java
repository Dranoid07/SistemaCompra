package com.entity;

import com.entity.Marcas;
import com.entity.OrdenCompra;
import com.entity.SolicitudArticulos;
import com.entity.UnidadesMedida;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-28T13:10:54")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile SingularAttribute<Articulos, Boolean> existencia;
    public static volatile SingularAttribute<Articulos, String> estado;
    public static volatile SingularAttribute<Articulos, Marcas> marcaId;
    public static volatile CollectionAttribute<Articulos, SolicitudArticulos> solicitudArticulosCollection;
    public static volatile SingularAttribute<Articulos, UnidadesMedida> unidadMedidaId;
    public static volatile SingularAttribute<Articulos, Integer> id;
    public static volatile CollectionAttribute<Articulos, OrdenCompra> ordenCompraCollection;

}