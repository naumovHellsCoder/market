package com.naumov.productservice.repository;

import com.naumov.productservice.model.Image;
import com.naumov.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository
extends JpaRepository<Image, Integer>
{

    Image getImageById(Integer id);
    List<Product> getImageByProduct(Product product);

}
