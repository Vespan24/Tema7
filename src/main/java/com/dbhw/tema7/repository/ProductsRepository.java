package com.dbhw.tema7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbhw.tema7.model.Products;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Products getById(Integer Id);
    Products getByIdentificationCode(String identificationCode);
    List<Products> findAll();
}
