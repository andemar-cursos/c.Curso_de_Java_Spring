package com.cursos.andemar.market.persistence.crud;

import com.cursos.andemar.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


}
