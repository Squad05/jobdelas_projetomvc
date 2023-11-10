package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexAppController {

    @GetMapping("jobdelas")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }
}