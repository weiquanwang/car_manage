package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String name = paramMap.get("name");
            String departmentLeader = paramMap.get("departmentLeader");
            boolean result = departmentService.insert(name, departmentLeader);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(501, "新增失败");

            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }
}
