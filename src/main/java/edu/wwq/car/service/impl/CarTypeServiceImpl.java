package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.CarTypeMapper;
import edu.wwq.car.model.CarType;
import edu.wwq.car.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    private CarTypeMapper carTypeMapper;

    @Override
    public boolean insert(String name) {
        boolean result = false;
        CarType carType = new CarType();
        carType.setName(name);
        carType.setCreateTime(new Date());
        int index = carTypeMapper.insert(carType);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<CarType> getCarTypeList() {
        List<CarType> carTypeList = null;
        carTypeList = carTypeMapper.getCarTypeList();
        if (carTypeList == null) {
            carTypeList = new ArrayList<CarType>();
        }
        return carTypeList;
    }
}
