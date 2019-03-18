package com.ord.orderprocessingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView home(Model model) {
        return new ModelAndView("redirect:/index.html");
    }

}
