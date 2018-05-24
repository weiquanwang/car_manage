package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.Driver;
import edu.wwq.car.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String name = paramMap.get("name");
            String sexStr = paramMap.get("sex");
            String birthDateStr = paramMap.get("birthDate");
            String departmentIdStr = paramMap.get("departmentId");
            String levelStr = paramMap.get("level");
            String remark = paramMap.get("remark");
            int sex = Integer.parseInt(sexStr);
            int departmentId = Integer.parseInt(departmentIdStr);
            int level = Integer.parseInt(levelStr);
            Driver driver = new Driver();
            driver.setName(name);
            driver.setSex(sex);
            driver.setDepartmentId(departmentId);
            driver.setLevel(level);
            driver.setRemark(remark);
            driver.setCreateTime(new Date());
            boolean result = driverService.insert(driver);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(13010, "新增失败!");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String name = paramMap.get("name");
            String sexStr = paramMap.get("sex");
            String birthDateStr = paramMap.get("birthDate");
            String departmentIdStr = paramMap.get("departmentId");
            String levelStr = paramMap.get("level");
            String remark = paramMap.get("remark");
            int sex = Integer.parseInt(sexStr);
            int departmentId = Integer.parseInt(departmentIdStr);
            int level = Integer.parseInt(levelStr);
            Driver driver = driverService.getDriverById(id);
            if (driver == null) {
                resultJsonMsg = new ResultJsonMsg(13011, "该驾驶员不存在!");
                return resultJsonMsg;
            }
            driver.setName(name);
            driver.setDepartmentId(departmentId);
            driver.setLevel(level);
            driver.setSex(sex);
            driver.setRemark(remark);
            driver.setModifyTime(new Date());
            boolean result = driverService.update(driver);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(13013, "修改失败!");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            Driver driver = driverService.getDriverById(id);
            if (driver == null) {
                resultJsonMsg = new ResultJsonMsg(13011, "该驾驶员不存在!");
                return resultJsonMsg;
            }
            boolean result = driverService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(13015, "删除失败!");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public ResultJsonMsg getDriverList(HttpServletRequest request, HttpServletResponse response) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<Driver> driverList = driverService.getDriverList();
            resultJsonMsg = new ResultJsonMsg(200, "success", driverList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }
}
