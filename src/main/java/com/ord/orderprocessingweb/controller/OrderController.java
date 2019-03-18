package com.ord.orderprocessingweb.controller;

import com.ord.orderprocessingweb.model.OrderHeader;
import com.ord.orderprocessingweb.proxy.OrderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderServiceProxy orderServiceProxy;

    @GetMapping("/TTorders")
    private String getAllOrders(Model model) {
        List<OrderHeader> list = orderServiceProxy.getAllOrders();
        model.addAttribute("orders", list);
        System.out.println(list);
        return "orderList";
    }

    @GetMapping("/TTorders/{id}")
    private String getOrder(Model model, @PathVariable("id") int id) {
        OrderHeader order = orderServiceProxy.getOrder(id);
        model.addAttribute("order",order);
        return "orderDetails";
    }

    @GetMapping("/TTeditOrders/{id}")
    private String editOrder(Model model, @PathVariable("id") int id) {
        OrderHeader order = orderServiceProxy.getOrder(id);
        model.addAttribute("order",order);
        return "orderEdit";
    }

    @GetMapping("/TTdeleteOrder/{id}")
    private ModelAndView deleteOrder(Model model, @PathVariable("id") int id) {
        orderServiceProxy.deleteOrder(id);
        return new ModelAndView("redirect:/orders");
    }

    @GetMapping("/TTaddOrder")
    private String addOrder(Model model) {
        OrderHeader order = new OrderHeader();
        model.addAttribute("order",order);
        return "orderEdit";
    }

    @PostMapping(value = "/TTsaveOrder")
    public ModelAndView saveOrder(@RequestParam("id") String id,
                                    @RequestParam("referenceText") String referenceText,@RequestParam("userName") String userName) {
        OrderHeader order = new OrderHeader();
        if (id != null && id.length() > 0) {
            order.setId(Integer.parseInt(id));
        }
        order.setReferenceText(referenceText);
        order.setUserName(userName);

        orderServiceProxy.saveOrder(order);

        return new ModelAndView("redirect:/orders");
    }


}
