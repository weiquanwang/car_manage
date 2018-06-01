package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.CarUse;
import edu.wwq.car.service.CarUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CarUseController extends BaseController {

    @Autowired
    private CarUseService carUseService;

    @RequestMapping(value = "/carUse", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String destination = paramMap.get("destination");
            String useDate = paramMap.get("useDate");
            String returnDate = paramMap.get("returnDate");
            String useReason = paramMap.get("useReason");
            String useUserName = paramMap.get("useUserName");
            String useUserId = paramMap.get("useUserId");
            CarUse carUse = new CarUse();
            carUse.setLicensePlateNum(licensePlateNum);
            carUse.setDestination(destination);
            carUse.setUseDate(new Date());
            carUse.setReturnDate(new Date());
            carUse.setCarUseNum("");
            carUse.setUseUserName(useUserName);
            carUse.setUseReason(useReason);
            carUse.setCreateTime(new Date());
            boolean result = carUseService.insert(carUse);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(14011, "新增失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carUse/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String destination = paramMap.get("destination");
            String useDate = paramMap.get("useDate");
            String returnDate = paramMap.get("returnDate");
            String useReason = paramMap.get("useReason");
            String useUserName = paramMap.get("useUserName");
            String useUserId = paramMap.get("useUserId");
            CarUse carUse = carUseService.getCarUseById(id);
            if (carUse == null) {
                resultJsonMsg = new ResultJsonMsg(14012,"id参数错误");
                return resultJsonMsg;
            }
            carUse.setLicensePlateNum(licensePlateNum);
            carUse.setDestination(destination);
            carUse.setUseDate(new Date());
            carUse.setReturnDate(new Date());
            carUse.setCarUseNum("");
            carUse.setUseUserName(useUserName);
            carUse.setUseReason(useReason);
            carUse.setModifyTime(new Date());
            boolean result = carUseService.update(carUse);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(14013, "修改失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carUse/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            boolean result = carUseService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(14010,"删除失败！");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }


    @RequestMapping(value = "/carUse",method = RequestMethod.GET)
    public ResultJsonMsg getCarUseList(HttpServletRequest request, HttpServletResponse response) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<CarUse> carUseList = carUseService.getCarUseList();
            resultJsonMsg = new ResultJsonMsg(200,"success", carUseList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

}
