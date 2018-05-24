package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.CarMapper;
import edu.wwq.car.model.Car;
import edu.wwq.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public boolean insert(Car car) {
        boolean result = false;
        int index = carMapper.insert(car);
        if (index > 0) {
            result = true;
        }
        return result;
    }
}
