package edu.wwq.car.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class BaseController {

    @RequestMapping(value = "/index")
    public void index() {
        System.out.println("index.................");
    }

    public int getUserId(HttpServletRequest request, HttpServletResponse response) {
        int userId = -1;
        String userIdStr = request.getHeader("userId");
        userId = Integer.parseInt(userIdStr);
        return userId;
    }

    public String getToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        return token;
    }
}
