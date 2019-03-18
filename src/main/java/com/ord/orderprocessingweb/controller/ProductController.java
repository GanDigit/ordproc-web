package com.ord.orderprocessingweb.controller;

import com.ord.orderprocessingweb.model.Product;
import com.ord.orderprocessingweb.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

    @GetMapping("/TTproducts")
    private String getAllProducts(Model model) {
        List<Product> list = productServiceProxy.getAllProducts();
        model.addAttribute("products", list);
        System.out.println(list);
        return "productList";
    }

    @GetMapping("/TTproducts/{id}")
    private String getProduct(Model model, @PathVariable("id") int id) {
        Product product = productServiceProxy.getProduct(id);
        model.addAttribute("product",product);
        return "productDetails";
    }

    @GetMapping("/TTeditProducts/{id}")
    private String editProduct(Model model, @PathVariable("id") int id) {
        Product product = productServiceProxy.getProduct(id);
        model.addAttribute("product",product);
        return "productEdit";
    }

    @GetMapping("/TTdeleteProduct/{id}")
    private ModelAndView deleteProduct(Model model, @PathVariable("id") int id) {
        productServiceProxy.deleteProduct(id);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/TTaddProduct")
    private String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        return "productEdit";
    }

    @PostMapping(value = "/TTsaveProduct")
    public ModelAndView saveProduct(@RequestParam("id") String id,
                               @RequestParam("category") String category,@RequestParam("name") String name,
                               @RequestParam("price") int price) {
        Product product = new Product();
        if (id != null && id.length() > 0) {
            product.setId(Integer.parseInt(id));
        }
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);

        productServiceProxy.saveProduct(product);

        return new ModelAndView("redirect:/products");
    }
}
