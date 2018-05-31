package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.User;
import edu.wwq.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResultJsonMsg login(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String userName = paramMap.get("userName");
            String password = paramMap.get("password");
            if (userName == null || "".equals(userName)) {
                resultJsonMsg = new ResultJsonMsg(16001, "用户名参数错误!");
                return resultJsonMsg;
            }
            if (password == null || "".equals(password)) {
                resultJsonMsg = new ResultJsonMsg(16001, "密码参数错误!");
                return resultJsonMsg;
            }
            boolean result = userService.login(userName, password);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16010, "用户名或密码错误!");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String userName = paramMap.get("userName");
            String password = paramMap.get("password");
            String sexStr = paramMap.get("sex");
            String mobile = paramMap.get("mobile");
            if (userName == null || "".equals(userName)) {
                resultJsonMsg = new ResultJsonMsg(16001, "用户名参数错误!");
                return resultJsonMsg;
            }
            if (password == null || "".equals(password)) {
                resultJsonMsg = new ResultJsonMsg(16001, "密码参数错误!");
                return resultJsonMsg;
            }
            int sex = Integer.parseInt(sexStr);
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setSex(sex);
            user.setMobile(mobile);
            user.setCreateTime(new Date());
            boolean result = userService.insert(user);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16002, "新增失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String userName = paramMap.get("userName");
            String password = paramMap.get("password");
            String sexStr = paramMap.get("sex");
            String mobile = paramMap.get("mobile");
            if (userName == null || "".equals(userName)) {
                resultJsonMsg = new ResultJsonMsg(16001, "用户名参数错误!");
                return resultJsonMsg;
            }
            if (password == null || "".equals(password)) {
                resultJsonMsg = new ResultJsonMsg(16001, "密码参数错误!");
                return resultJsonMsg;
            }
            int sex = Integer.parseInt(sexStr);
            User user = userService.getUserById(id);
            if (user == null) {
                resultJsonMsg = new ResultJsonMsg(16021, "用户不存在!");
                return resultJsonMsg;
            }
            user.setUserName(userName);
            user.setPassword(password);
            user.setSex(sex);
            user.setMobile(mobile);
            user.setModifyTime(new Date());
            boolean result = userService.update(user);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16022, "修改失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            User user = userService.getUserById(id);
            if (user == null) {
                resultJsonMsg = new ResultJsonMsg(16021, "用户不存在!");
                return resultJsonMsg;
            }
            boolean result = userService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16023, "删除失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }


}
