package com.korkmaz.stoktakipbackend.product.controller;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.service.AddProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final AddProductService addProductService;

    public ProductController(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductDto cratedProduct = addProductService.addProduct(productDto);
        return new ResponseEntity<>(cratedProduct, HttpStatus.CREATED);
    }
}
//s