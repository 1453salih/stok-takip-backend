package com.korkmaz.stoktakipbackend.product.controller;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.service.AddProductService;
import com.korkmaz.stoktakipbackend.product.service.GetProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final AddProductService addProductService;
    private final GetProductService getProductService;

    public ProductController(AddProductService addProductService, GetProductService getProductService) {
        this.addProductService = addProductService;
        this.getProductService = getProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductDto cratedProduct = addProductService.addProduct(productDto);
        return new ResponseEntity<>(cratedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id) {
        ProductDto productDto = getProductService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductDto> getProductByCode(@PathVariable String code) {
        ProductDto productDto = getProductService.getProductByCode(code);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
