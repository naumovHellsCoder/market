package com.naumov.productservice.controller;

import com.naumov.productservice.dto.ProductDto;
import com.naumov.productservice.model.Product;
import com.naumov.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/shop/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping(path = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(
            ProductDto productDto,
            @RequestPart("image") MultipartFile[] files){
        Product product = productService.createProduct(productDto, files);


        return ResponseEntity.ok().body(product);
    }

}
