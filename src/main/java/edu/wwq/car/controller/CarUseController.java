package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.service.CarUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarUseController {

    @Autowired
    private CarUseService carUseService;

    @RequestMapping(value = "/carUse", method = RequestMethod.POST)
    public ResultJsonMsg insert() {
        ResultJsonMsg resultJsonMsg = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

}
