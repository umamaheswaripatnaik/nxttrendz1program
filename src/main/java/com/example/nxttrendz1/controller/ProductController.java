package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxttrendz1.service.ProductJpaService;
import com.example.nxttrendz1.model.Product;

@RestController
public class ProductController {
    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return productJpaService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productid) {
        return productJpaService.getProductById(productid);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productid, @RequestBody Product product) {
        return productJpaService.updateProduct(productid, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productid) {
        productJpaService.deleteProduct(productid);
    }

}
