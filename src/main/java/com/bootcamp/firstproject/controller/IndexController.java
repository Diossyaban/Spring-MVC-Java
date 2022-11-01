package com.bootcamp.firstproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.firstproject.model.Province;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("isHome", true);
        model.addAttribute("title", "Hello Daniel Dewanto");
        return "index";
    }

    @GetMapping("/provinces")
    public String showProvince(Model model){
        List<Province> listOfProvince = Arrays.asList(
            new Province(1L, "DKI JAKARTA"),
            new Province(2L, "JAWA TIMUR"),
            new Province(3L, "D.I.YOGYAKARTA")
        );
        model.addAttribute("listOfProvince", listOfProvince);
        return "province.html";
    }
}
