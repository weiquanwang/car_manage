package edu.wwq.car.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public void insert() {
        String licensePlateNum = "";
        String manufacturer = "";
        String productDate = "";
        String purchaseDate = "";
        String purchasePrice = "";
        String loadWeightStr = "";
        String carTypeId = "";

    }
}
