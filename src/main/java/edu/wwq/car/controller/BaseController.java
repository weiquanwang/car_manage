package edu.wwq.car.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/index")
    public void index() {
        System.out.println("index.................");
    }
}
