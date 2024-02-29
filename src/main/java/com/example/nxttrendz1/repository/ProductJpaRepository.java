package com.example.nxttrendz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.nxttrendz1.model.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

}
