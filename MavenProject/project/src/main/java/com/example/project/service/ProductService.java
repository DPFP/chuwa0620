package com.example.project.service;

import com.example.project.payload.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(ProductDto productDto, Long id);
    void deleteProductById(Long id);
}
