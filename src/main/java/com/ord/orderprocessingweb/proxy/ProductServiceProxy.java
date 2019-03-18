package com.ord.orderprocessingweb.proxy;

import com.ord.orderprocessingweb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("application.properties")
public class ProductServiceProxy {

    @Autowired
    private Environment env;

    @Value("${url.service.catalog}")
    private String serviceUrlPrefix1;

    @Value("${url.service.catalog2}")
    private String serviceUrlPrefix2;

    @Autowired
    RestTemplate restTemplate;


    private String getServiceUrlPrefixURL() {
        String url = serviceUrlPrefix1;
        if (serviceUrlPrefix2 != null || serviceUrlPrefix2.length() > 0) {
            url = serviceUrlPrefix2;
        }
        return url;
    }


    public static HttpEntity<String> createEntity() {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return entity;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        String url =  getServiceUrlPrefixURL() + "products";
        System.out.println("orders url :" + url);
        ResponseEntity<List<Product>> response = restTemplate.exchange(url,  HttpMethod.GET, createEntity(), new ParameterizedTypeReference<List<Product>>(){});
        List<Product> products = response.getBody();
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        String url =  getServiceUrlPrefixURL() + "products/" + id;

        Map params = new HashMap();
        params.put("id", id);

        Product product = restTemplate.getForObject(url, Product.class);
        return product;

//        ResponseEntity<Product> response = restTemplate.exchange(url,  HttpMethod.GET, createEntity(), new ParameterizedTypeReference<Product>(){});
//        Product product = response.getBody();
//        return product;

    }

    public void deleteProduct(int id) {
        String url =  getServiceUrlPrefixURL() + "products/" + id;
        restTemplate.delete(url);
    }

    public int saveProduct(Product product) {
        System.out.println("Hi....");
        String url =  getServiceUrlPrefixURL() + "products";
        System.out.println(url);
        restTemplate.put(url, product);
        return 0;
    }
}
