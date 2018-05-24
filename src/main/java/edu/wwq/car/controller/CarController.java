package edu.wwq.car.controller;

import edu.wwq.car.bean.ResultJsonMsg;
import edu.wwq.car.model.Car;
import edu.wwq.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResultJsonMsg insert(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> paramMap) {
        ResultJsonMsg resultJsonMsg = null;
        try {
            String licensePlateNum = paramMap.get("licensePlateNum");
            String manufacturer = paramMap.get("manufacturer");
            String productDate = paramMap.get("productDate");
            String purchaseDate = paramMap.get("purchaseDate");
            String purchasePriceStr = paramMap.get("purchasePrice");
            String loadWeightStr = paramMap.get("loadWeight");
            String carTypeIdStr = paramMap.get("carTypeId");
            if (carTypeIdStr == null || "".equals(carTypeIdStr)) {
                resultJsonMsg = new ResultJsonMsg(11001, "参数错误!");
                return resultJsonMsg;
            }
            if (loadWeightStr == null || "".equals(loadWeightStr)) {
                resultJsonMsg = new ResultJsonMsg(11001, "参数错误!");
                return resultJsonMsg;
            }
            Integer carTypeId = Integer.parseInt(carTypeIdStr);
            Double loadWeight = Double.parseDouble(loadWeightStr);
            BigDecimal purchasePrice = new BigDecimal(purchasePriceStr);
            Car car = new Car();
            car.setLicensePlateNum(licensePlateNum);
            car.setManufacturer(manufacturer);
            car.setProductDate(new Date());
            car.setPurchaseDate(new Date());
            car.setPurchasePrice(purchasePrice);
            car.setCarTypeId(carTypeId);
            car.setLoadWeight(loadWeight);
            boolean result = carService.insert(car);
            if (!result) {
                resultJsonMsg = new ResultJsonMsg(12010, "新增失败!");
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
