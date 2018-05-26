package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.CarMaintenance;
import edu.wwq.car.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CarMaintenanceController {

    @Autowired
    private CarMaintenanceService carMaintenanceService;

    @RequestMapping(value = "/carMaintenance", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String maintenanceCause = paramMap.get("maintenanceCause");
            String maintenancePrice = paramMap.get("maintenancePrice");
            String maintenanceDate = paramMap.get("maintenanceDate");
            String handStaff = paramMap.get("handStaff");
            String remark = paramMap.get("remark");
            CarMaintenance carMaintenance = new CarMaintenance();
            carMaintenance.setLicensePlateNum(licensePlateNum);
            carMaintenance.setCarMaintenanceNum("");
            carMaintenance.setMaintenanceCause(maintenanceCause);
            carMaintenance.setMaintenancePrice(new BigDecimal(maintenancePrice));
            carMaintenance.setHandStaff(handStaff);
            carMaintenance.setRemark(remark);
            carMaintenance.setCreateTime(new Date());
            boolean result = carMaintenanceService.insert(carMaintenance);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16011, "新增失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carMaintenance/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String maintenanceCause = paramMap.get("maintenanceCause");
            String maintenancePrice = paramMap.get("maintenancePrice");
            String maintenanceDate = paramMap.get("maintenanceDate");
            String handStaff = paramMap.get("handStaff");
            String remark = paramMap.get("remark");
            CarMaintenance carMaintenance = carMaintenanceService.getCarMaintenanceById(id);
            if (carMaintenance == null) {
                resultJsonMsg = new ResultJsonMsg(16012,"id参数错误");
                return resultJsonMsg;
            }
            carMaintenance.setLicensePlateNum(licensePlateNum);
            carMaintenance.setMaintenanceCause(maintenanceCause);
            carMaintenance.setMaintenancePrice(new BigDecimal(maintenancePrice));
            carMaintenance.setHandStaff(handStaff);
            carMaintenance.setRemark(remark);
            carMaintenance.setModifyTime(new Date());
            boolean result = carMaintenanceService.update(carMaintenance);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16013, "修改失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carMaintenance/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            boolean result = carMaintenanceService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(16015, "删除失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/carMaintenance", method = RequestMethod.GET)
    public ResultJsonMsg getCarMaintenanceList() {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<CarMaintenance> carMaintenanceList = carMaintenanceService.getCarMaintenanceList();
            resultJsonMsg = new ResultJsonMsg(200,"success", carMaintenanceList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(500, "系统错误!");
        }
        return resultJsonMsg;
    }
}
