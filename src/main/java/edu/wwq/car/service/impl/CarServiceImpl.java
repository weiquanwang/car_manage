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

    @Override
    public boolean update(Car car) {
        boolean result = false;
        int index = carMapper.update(car);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Car getCarById(int id) {
        Car car = carMapper.getCarById(id);
        return car;
    }

    @Override
    public boolean delete(Car car) {
        boolean result = false;
        int id = car.getId();
        int index = carMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }
}
