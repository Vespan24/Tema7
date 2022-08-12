package com.dbhw.tema7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbhw.tema7.model.Products;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Products getById(Integer Id);
    Products getByIdentificationCode(String identificationCode);
    List<Products> findAll();

    @Modifying
    @Query("UPDATE Products p set p.stock = p.stock +1 WHERE p.Id = productId")
    void incrementStock(Integer productId);
    @Modifying
    @Query("UPDATE Products p set p.stock = p.stock -1 WHERE p.Id = productId")
    void decrementStock(Integer productId);
}
