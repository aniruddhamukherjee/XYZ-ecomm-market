package com.aniruddha.XYZecommmarket.controller;

import com.aniruddha.XYZecommmarket.beans.Product;
import com.aniruddha.XYZecommmarket.business.ProductBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductBusiness productBusiness;

    /**
     * Api for fetching all products with details
     * @return List of products
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productBusiness.getAllProducts();
    }
    /**
     * Api for fetching products details by brand
     * @return List of products
     */
    @RequestMapping(value = "/products/brand/{brand}", method = RequestMethod.GET)
    public List<Product> getProductsByBrand(@PathVariable("brand") String brand) {
        return productBusiness.getProductsByBrand(brand);
    }
    /**
     * Api for fetching products details by price range
     * @return List of products
     */
    @RequestMapping(value = "/products/price/min/{min}/max/{max}", method = RequestMethod.GET)
    public List<Product> getProductsByPriceRange(@PathVariable("min") Double minPrice, @PathVariable("max") Double maxPrice) {
        return productBusiness.getProductsByPriceRange(minPrice, maxPrice);
    }
    /**
     * Api for fetching product details by SKU
     * @return List of products
     */
    @RequestMapping(value = "/products/{sku}", method = RequestMethod.GET)
    public Product getProductBySKU(@PathVariable("sku") Integer productId) {
        return productBusiness.getProductBySKU(productId);
    }
    /**
     * Api for fetching product's count by SKU and seller
     * @return List of products
     */
    @RequestMapping(value = "/products/{sku}/seller/{supplier}", method = RequestMethod.GET)
    public Integer getProductBySKU(@PathVariable("sku") Integer productId, @PathVariable("supplier") Integer sellerId) {
        return productBusiness.getProductCountByIdAndSeller(productId, sellerId);
    }
    /**
     * Api for fetching products details by type and size
     * @return List of products
     */
    @RequestMapping(value = "/products/type/{type}/size/{size}", method = RequestMethod.GET)
    public List<Product> getProductsByTypeAndSize(@PathVariable("type") Integer productType, @PathVariable("size") Integer size) {
        return productBusiness.getProductsByTypeAndSize(productType, size);
    }
    /**
     * Api for fetching products details by type and color
     * @return List of products
     */
    @RequestMapping(value = "/products/type/{type}/color/{color}", method = RequestMethod.GET)
    public List<Product> getProductsByTypeAndColor(@PathVariable("type") Integer productType, @PathVariable("color") String color) {
        return productBusiness.getProductsByTypeAndColor(productType, color);
    }

}
