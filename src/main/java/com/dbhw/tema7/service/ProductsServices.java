package com.dbhw.tema7.service;

import com.dbhw.tema7.model.Products;
import com.dbhw.tema7.model.Type;
import com.dbhw.tema7.repository.ProductsRepository;
import com.dbhw.tema7.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.processor.SpringObjectTagProcessor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public void incrementStockByOne(Integer Id){
        productsRepository.incrementStock(Id);
    }
    public void decrementStockByOne(Integer Id){
        productsRepository.decrementStock(Id);
     /*
        if(productsRepository.getById(Id).getStock() <= 0){
            softDeleteProduct(productsRepository.getById(Id).getIdentificationCode());
        }
     */
    }
    public void updateStock(Integer Id, Integer stock){
        productsRepository.getById(Id).setStock(stock);
    }
}
