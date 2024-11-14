package com.korkmaz.stoktakipbackend.exception;

public class ProductNotFoundException extends  RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Ürün id'si bulunamadı: " + id);
    }
    public ProductNotFoundException(String code) {
        super("Ürün kodu bulunamadı: " + code);
    }
}
