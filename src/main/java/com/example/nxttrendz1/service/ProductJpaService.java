package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ProductRepository;
import com.example.nxttrendz1.model.Product;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> products = productJpaRepository.findAll();
        ArrayList<Product> productlist = new ArrayList<>(products);
        return productlist;
    }

    @Override
    public Product getProductById(int productid) {
        try {
            Product product = productJpaRepository.findById(productid).get();
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Product addProduct(Product product) {
        productJpaRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int productid, Product product) {
        try {
            Product newproduct = productJpaRepository.findById(productid).get();
            if (product.getProductName() != null) {
                newproduct.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0) {
                newproduct.setPrice(product.getPrice());
            }
            productJpaRepository.save(newproduct);
            return newproduct;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteProduct(int productid) {
        try {
            productJpaRepository.deleteById(productid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}