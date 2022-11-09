package com.naumov.productservice.service;

import com.naumov.productservice.dto.ProductDto;
import com.naumov.productservice.model.Product;
import com.naumov.productservice.repository.ImageRepository;
import com.naumov.productservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepository;
    private ImageRepository imageRepository;
    private FileService fileService;

    @BeforeEach
    public void init() {
        productRepository = mock(ProductRepository.class);
        fileService = mock(FileService.class);
        imageRepository = mock(ImageRepository.class);
        productService = new ProductService(
                fileService,
                productRepository,
                imageRepository
        );


    }

    @Test
    public void createProductTest() {
        ProductDto product = new ProductDto();
        product.setDescription("non");
        product.setPrice(100.99);
        product.setName("name");
        when(productRepository.save(any(Product.class)))
                .then(returnsFirstArg());
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "file.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "".getBytes()
        );
        MockMultipartFile[] filesArray = {file};
        Product productSave = productService.createProduct(product, filesArray);
        assertNotNull(productSave);
    }

    @Test
    public void saveFileTest() {


    }
}