package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.CarType;
import edu.wwq.car.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class CarTypeController extends BaseController {

    @Autowired
    private CarTypeService carTypeService;

    @RequestMapping(value = "/carType", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String name = paramMap.get("name");
            if (name == null || "".equals(name)) {
                resultJsonMsg = new ResultJsonMsg(11001, "参数错误!");
                return resultJsonMsg;
            }
            boolean result = carTypeService.insert(name);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(11002, "新增失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carType", method = RequestMethod.GET)
    public ResultJsonMsg getCarTypeList(HttpServletRequest request, HttpServletResponse response) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<CarType> carTypeList = carTypeService.getCarTypeList();
            resultJsonMsg = new ResultJsonMsg(200, "success", carTypeList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }
}
