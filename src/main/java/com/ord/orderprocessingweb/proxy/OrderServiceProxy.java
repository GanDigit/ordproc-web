package com.ord.orderprocessingweb.proxy;

import com.ord.orderprocessingweb.model.OrderHeader;
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
public class OrderServiceProxy {

    @Autowired
    private Environment env;

    @Value("${url.service.order}")
    private String serviceUrlPrefix;

    @Autowired
    RestTemplate restTemplate;

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

    @GetMapping("/orders")
    public List<OrderHeader> getAllOrders() {
        String url =  serviceUrlPrefix + "orders";
        System.out.println("orders url :" + url);
        ResponseEntity<List<OrderHeader>> response = restTemplate.exchange(url,  HttpMethod.GET, createEntity(), new ParameterizedTypeReference<List<OrderHeader>>(){});
        List<OrderHeader> orders = response.getBody();
        return orders;
    }

    @GetMapping("/orders/{id}")
    public OrderHeader getOrder(@PathVariable("id") int id) {
        String url =  serviceUrlPrefix + "orders/" + id;

        Map params = new HashMap();
        params.put("id", id);

        OrderHeader order = restTemplate.getForObject(url, OrderHeader.class);
        return order;

//        ResponseEntity<Order> response = restTemplate.exchange(url,  HttpMethod.GET, createEntity(), new ParameterizedTypeReference<Order>(){});
//        Order order = response.getBody();
//        return order;

    }

    public void deleteOrder(int id) {
        String url =  serviceUrlPrefix + "orders/" + id;
        restTemplate.delete(url);
    }

    public int saveOrder(OrderHeader order) {
        System.out.println("Hi....");
        String url =  serviceUrlPrefix + "orders";
        System.out.println(url);
        restTemplate.put(url, order);
        return 0;
    }
}
