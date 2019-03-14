package com.ord.orderprocessingweb.proxy;

import com.ord.orderprocessingweb.info.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="order-processing-catalog-service")
public interface ProductServiceProxy {

    @GetMapping("/products")
    public List<Product> getAllProducts();

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id);

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id);

    @PostMapping("/products")
    public int saveProduct(@RequestBody Product product) ;
}
