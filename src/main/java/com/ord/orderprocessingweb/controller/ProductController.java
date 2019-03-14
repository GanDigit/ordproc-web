package com.ord.orderprocessingweb.controller;

import com.ord.orderprocessingweb.info.Product;
import com.ord.orderprocessingweb.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class ProductController {

    @Autowired
    ProductServiceProxy productServiceProxy;

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        System.out.println("productServiceProxy --> " + productServiceProxy);
        return productServiceProxy.getAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") int id) {
        return productServiceProxy.getProduct(id);
    }

    @DeleteMapping("/products/{id}")
    private void deleteProduct(@PathVariable("id") int id) {
        productServiceProxy.deleteProduct(id);
    }

    @PostMapping("/products")
    private int saveProduct(@RequestBody Product product) {
        productServiceProxy.saveProduct(product);
        return product.getId();
    }
}
