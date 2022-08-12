package com.dbhw.tema7.controller;

import com.dbhw.tema7.model.Products;
import com.dbhw.tema7.model.Type;
import com.dbhw.tema7.service.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductsServices productsServices;

    @PostMapping("/products/addproduct/")
    public void addProduct(@RequestParam String name, @RequestParam String identificationCode, @RequestParam Type type, @RequestParam Integer stock){
        productsServices.addProduct(name, identificationCode, type, stock);
    }

    @PostMapping("/products/{identificationCode}")
    public void softDeleteProduct(@PathVariable("identificationCode") String identificationCode){
        productsServices.softDeleteProduct(identificationCode);
    }
    @GetMapping("products/all/undeleted")
    public List<Products> getAllProducts(){
        return productsServices.getAllProducts();
    }

    @GetMapping("products/all/all")
    public List<Products> getAllProductsIncludingUndeleted(){
        return productsServices.getAllProductsIncludingDeleted();
    }
}
