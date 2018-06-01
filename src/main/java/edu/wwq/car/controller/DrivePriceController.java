package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.DrivePrice;
import edu.wwq.car.service.DrivePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class DrivePriceController extends BaseController {

    @Autowired
    private DrivePriceService drivePriceService;

    @RequestMapping(value = "/drivePrice", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String price = paramMap.get("price");
            String driveDate = paramMap.get("driveDate");
            String remark = paramMap.get("remark");
            String handStaff = paramMap.get("handStaff");
            DrivePrice drivePrice = new DrivePrice();
            drivePrice.setDrivePriceNum("");
            drivePrice.setLicensePlateNum(licensePlateNum);
            drivePrice.setDriveDate(new Date());
            drivePrice.setPrice(new BigDecimal(price));
            drivePrice.setRemark(remark);
            drivePrice.setCreateTime(new Date());
            boolean result = drivePriceService.insert(drivePrice);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(15011, "新增失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/drivePrice/{id}", method = RequestMethod.PUT)
    public ResultJsonMsg update(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap, @PathVariable("id") int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String price = paramMap.get("price");
            String driveDate = paramMap.get("driveDate");
            String remark = paramMap.get("remark");
            String handStaff = paramMap.get("handStaff");
            DrivePrice drivePrice = drivePriceService.getDrivePriceById(id);
            if (drivePrice == null) {
                resultJsonMsg = new ResultJsonMsg(15012,"id参数错误");
                return resultJsonMsg;
            }
            drivePrice.setDrivePriceNum("");
            drivePrice.setLicensePlateNum(licensePlateNum);
            drivePrice.setDriveDate(new Date());
            drivePrice.setPrice(new BigDecimal(price));
            drivePrice.setRemark(remark);
            drivePrice.setModifyTime(new Date());
            boolean result = drivePriceService.update(drivePrice);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(15012, "修改失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/drivePrice/{id}", method = RequestMethod.DELETE)
    public ResultJsonMsg delete(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id",required=true) int id) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            boolean result = drivePriceService.delete(id);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(15013, "删除失败");
            } else {
                resultJsonMsg = new ResultJsonMsg(200, "success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }

    @RequestMapping(value = "/drivePrice", method = RequestMethod.GET)
    public ResultJsonMsg getDrivePriceList() {
        ResultJsonMsg resultJsonMsg = null;
        try {
            List<DrivePrice> drivePriceList = drivePriceService.getDrivePriceList();
            resultJsonMsg = new ResultJsonMsg(200, "success", drivePriceList);
        } catch (Exception e) {
            e.printStackTrace();
            resultJsonMsg = new ResultJsonMsg(501, "系统错误!");
        }
        return resultJsonMsg;
    }
}
