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

    public List<Product> getAllProducts(int offset) {
        return productRepository.getAllProducts(offset);
    }

    public List<Product> getProductsByBrand(String brandName, int offset) {
        return productRepository.getProductsByBrand(brandName, offset);
    }

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice, int offset) {
        return productRepository.getProductsByPriceRange(minPrice, maxPrice, offset);
    }

    public Product getProductBySKU(Integer productId) {
        return productRepository.getProductBySKU(productId);
    }

    public Integer getProductCountBySeller(Integer sellerId) {
        return productRepository.getProductCountBySeller(sellerId);
    }

    public List<Product> getProductsByTypeAndSize(Integer productType, Integer size, int offset) {
        return productRepository.getProductsByTypeAndSize(productType, size, offset);
    }

    public List<Product> getProductsByTypeAndColor(Integer productType, String color,  int offset) {
        return productRepository.getProductsByTypeAndColor(productType, color, offset);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
