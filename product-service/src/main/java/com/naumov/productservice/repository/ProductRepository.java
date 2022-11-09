package com.naumov.productservice.repository;

import com.naumov.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository
extends JpaRepository<Product, Integer>
{

    @Query()
    Optional<Product> findProductById(Integer id);
    @Query()
    boolean existsById(Integer id);

}
