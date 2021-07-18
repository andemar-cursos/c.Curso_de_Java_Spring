package com.cursos.andemar.market.persistence;

import com.cursos.andemar.market.domain.Product;
import com.cursos.andemar.market.domain.repository.ProductRepository;
import com.cursos.andemar.market.persistence.crud.ProductoCrudRepository;
import com.cursos.andemar.market.persistence.entity.Producto;
import com.cursos.andemar.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository
                .findByIdCategoriaOrOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository
                .findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId)
                .map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
