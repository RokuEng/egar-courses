package com.RokuEng.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AskController {

    @RequestMapping("/ask")
    public String askDetails() {
        return "ask-emp-details-view";
    }

    @RequestMapping(
            name = "show",
            value = "/ask",
            method = RequestMethod.GET)
    public String show(
            @RequestParam(name = "name", required = false) String name
    ) {
        System.out.println(name);
        return "ask-emp-details-view";
    }
}
