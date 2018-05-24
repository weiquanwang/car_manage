package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.CarUseMapper;
import edu.wwq.car.model.CarUse;
import edu.wwq.car.service.CarUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
