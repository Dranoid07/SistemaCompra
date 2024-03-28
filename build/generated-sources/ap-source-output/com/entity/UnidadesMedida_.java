package com.entity;

import com.entity.Articulos;
import com.entity.OrdenCompra;
import com.entity.SolicitudArticulos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-28T13:10:54")
@StaticMetamodel(UnidadesMedida.class)
public class UnidadesMedida_ { 

    public static volatile SingularAttribute<UnidadesMedida, String> descripcion;
    public static volatile SingularAttribute<UnidadesMedida, String> estado;
    public static volatile CollectionAttribute<UnidadesMedida, SolicitudArticulos> solicitudArticulosCollection;
    public static volatile SingularAttribute<UnidadesMedida, Integer> id;
    public static volatile CollectionAttribute<UnidadesMedida, Articulos> articulosCollection;
    public static volatile CollectionAttribute<UnidadesMedida, OrdenCompra> ordenCompraCollection;

}