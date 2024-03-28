package com.entity;

import com.entity.Articulos;
import com.entity.OrdenCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-28T13:10:54")
@StaticMetamodel(Marcas.class)
public class Marcas_ { 

    public static volatile SingularAttribute<Marcas, String> descripcion;
    public static volatile SingularAttribute<Marcas, String> estado;
    public static volatile SingularAttribute<Marcas, Integer> id;
    public static volatile CollectionAttribute<Marcas, Articulos> articulosCollection;
    public static volatile CollectionAttribute<Marcas, OrdenCompra> ordenCompraCollection;

}