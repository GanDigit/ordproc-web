package com.ord.orderprocessingweb.controller;

import com.ord.orderprocessingweb.info.OrderHeader;
import com.ord.orderprocessingweb.proxy.OrderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@EnableFeignClients
public class OrderController {

    @Autowired
    OrderServiceProxy orderServiceProxy;

    @GetMapping("/orders")
    private List<OrderHeader> getAllOrders() {
        System.out.println(orderServiceProxy);
        return orderServiceProxy.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    private OrderHeader getOrder(@PathVariable("id") int id) {
        return orderServiceProxy.getOrder(id);
    }

    @DeleteMapping("/orders/{id}")
    private void deleteOrder(@PathVariable("id") int id) {
        orderServiceProxy.deleteOrder(id);
    }

    @PostMapping("/orders")
    private int saveOrder(@RequestBody OrderHeader orderHeader) {
        orderServiceProxy.saveOrder(orderHeader);
        return orderHeader.getId();
    }
}
