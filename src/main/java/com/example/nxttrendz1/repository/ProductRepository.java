package com.example.nxttrendz1.repository;

import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;

public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product getProductById(int productid);

    Product addProduct(Product product);

    Product updateProduct(int productid, Product product);

    void deleteProduct(int productid);

}
