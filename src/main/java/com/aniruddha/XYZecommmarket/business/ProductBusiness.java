package com.aniruddha.XYZecommmarket.business;

import com.aniruddha.XYZecommmarket.beans.Product;
import com.aniruddha.XYZecommmarket.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductBusiness {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByBrand(String brandName) {
        return productRepository.getProductsByBrand(brandName);
    }

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice);
    }

    public Product getProductBySKU(Integer productId) {
        return productRepository.getProductBySKU(productId);
    }

    public Integer getProductCountByIdAndSeller(Integer productId, Integer sellerId) {
        return productRepository.getProductCountByIdAndSeller(productId, sellerId);
    }

    public List<Product> getProductsByTypeAndSize(Integer productType, Integer size) {
        return productRepository.getProductsByTypeAndSize(productType, size);
    }

    public List<Product> getProductsByTypeAndColor(Integer productType, String color) {
        return productRepository.getProductsByTypeAndColor(productType, color);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
