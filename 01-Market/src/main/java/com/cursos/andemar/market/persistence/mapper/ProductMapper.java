package com.cursos.andemar.market.persistence.mapper;

import com.cursos.andemar.market.domain.Product;
import com.cursos.andemar.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);


    // Esta anotacion, recoge el mappings anterior y lo usa
    // a la inversa
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

    List<Product> toProducts(List<Producto> productos);

}
