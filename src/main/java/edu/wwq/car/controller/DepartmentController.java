package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.Department;
import edu.wwq.car.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
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

    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String name = paramMap.get("name");
            String departmentLeader = paramMap.get("departmentLeader");
            Department department = departmentService.getDepartmentById(id);
            if (department == null) {
                resultJsonMsg = new ResultJsonMsg(503, "部门不存在!");
                return resultJsonMsg;
            }
            department.setName(name);
            department.setDepartmentLeader(departmentLeader);
            department.setModifyTime(new Date());
            boolean result = departmentService.update(department);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(501, "修改失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            boolean result = departmentService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(505, "删除失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResultJsonMsg getDepartmentList() {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            resultJsonMsg = new ResultJsonMsg(200, "success", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }
}
