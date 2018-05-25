package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class DrivePriceController {

    @RequestMapping(value = "/drivePrice", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }
}
