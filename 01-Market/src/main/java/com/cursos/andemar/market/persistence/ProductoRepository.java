package com.cursos.andemar.market.persistence;

import com.cursos.andemar.market.persistence.crud.ProductoCrudRepository;
import com.cursos.andemar.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
