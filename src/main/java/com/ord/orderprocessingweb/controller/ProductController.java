package com.ord.orderprocessingweb.controller;

import com.ord.orderprocessingweb.model.Product;
import com.ord.orderprocessingweb.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

//    @GetMapping("/products")
//    private String getAllProducts(Model model) {
//        String list = productServiceProxy.getAllProducts();
//        model.addAttribute("products", list);
//        System.out.println(list);
//        return "productList";
//    }

    @GetMapping("/products")
    private String getAllProducts(Model model) {
        List<Product> list = productServiceProxy.getAllProducts();
        model.addAttribute("products", list);
        System.out.println(list);
        return "productList";
    }

    @GetMapping("/products/{id}")
    private String getProduct(Model model, @PathVariable("id") int id) {
        Product product = productServiceProxy.getProduct(id);
        model.addAttribute("product",product);
        return "productDetails";
    }

    @DeleteMapping("/products/{id}")
    private String deleteProduct(Model model, @PathVariable("id") int id) {
        productServiceProxy.deleteProduct(id);
        return getAllProducts(model);
    }

    @PostMapping("/products")
    private String saveProduct(Model model, @RequestBody Product product) {
        productServiceProxy.saveProduct(product);
        return getAllProducts(model);
    }
}
