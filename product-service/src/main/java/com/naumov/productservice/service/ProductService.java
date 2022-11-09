package com.naumov.productservice.service;

import com.naumov.productservice.dto.ProductDto;
import com.naumov.productservice.model.Image;
import com.naumov.productservice.model.Product;
import com.naumov.productservice.repository.ImageRepository;
import com.naumov.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final FileService fileService;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;


    public Product createProduct(
            ProductDto productDto,
            MultipartFile[] files
            ) {
        Product product = new Product();
        String directoryImage = "./images/";

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);

        if(productDto.getName() == null){
            return null;
        }
        for (MultipartFile file : files) {
            String filePath = directoryImage + generateRandomName() + ".png";
            Image image = new Image();
            image.setProduct(product);
            image.setTypeImg(file.getContentType());
            image.setFilePath(filePath);

            try {
                fileService.saveImage(filePath, file.getBytes());
                imageRepository.save(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
    private static  String generateRandomName(){
        return UUID.randomUUID().toString();
    }
}
