package com.dbhw.tema7.service;

import com.dbhw.tema7.model.Products;
import com.dbhw.tema7.model.Type;
import com.dbhw.tema7.repository.ProductsRepository;
import com.dbhw.tema7.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.processor.SpringObjectTagProcessor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServices {
    final ProductsRepository productsRepository;

    public void addProduct(String name, String identificationCode, Type type, Integer stock){
        Products product= new Products();
        product.setDeleted(false);
        product.setName(name);
        product.setIdentificationCode(identificationCode);
        product.setStock(stock);
        product.setType(type);
        productsRepository.save(product);
    }

    public void softDeleteProduct(String identificationCode){
        productsRepository.getByIdentificationCode(identificationCode).setDeleted(false);
    }

    public List<Products> getAllProducts(){
        return (List<Products>) productsRepository.findAll()
                .stream()
                .filter(p -> p.getDeleted()==false);
    }
    public List<Products> getAllProductsIncludingDeleted(){
        return productsRepository.findAll();
    }

}
