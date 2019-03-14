package com.ord.orderprocessingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("tttle","Welcome to Order Processing Application");
        return "index";
    }

}
