package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.CarUseMapper;
import edu.wwq.car.model.CarUse;
import edu.wwq.car.service.CarUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarUseServiceImpl implements CarUseService {

    @Autowired
    private CarUseMapper carUseMapper;

    @Override
    public boolean insert(CarUse carUse) {
        boolean result = false;
        int index = carUseMapper.insert(carUse);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public CarUse getCarUseById(int id) {
        CarUse carUse = carUseMapper.getCarUseById(id);
        return carUse;
    }

    @Override
    public boolean update(CarUse carUse) {
        boolean result = false;

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = carUseMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<CarUse> getCarUseList() {
        List<CarUse> carUseList = carUseMapper.getCarUseList();
        return carUseList;
    }
}
