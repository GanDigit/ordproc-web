package com.ord.orderprocessingweb.proxy;

import com.ord.orderprocessingweb.model.OrderHeader;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name="order-processing-order-service", url= "http://localhost:8081")
@FeignClient(name="order-processing-order-service")
public interface OrderServiceProxy {

    @GetMapping("/orders")
    public List<OrderHeader> getAllOrders();

    @GetMapping("/orders/{id}")
    public OrderHeader getOrder(@PathVariable("id") int id);

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable("id") int id);

    @PostMapping("/orders")
    public int saveOrder(@RequestBody OrderHeader orderHeader) ;
}
