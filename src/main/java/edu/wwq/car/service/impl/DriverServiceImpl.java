package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.DriverMapper;
import edu.wwq.car.model.Driver;
import edu.wwq.car.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public boolean insert(Driver driver) {
        boolean result = false;
        int index = driverMapper.insert(driver);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Driver getDriverById(int id) {
        Driver driver = driverMapper.getDriverById(id);
        return driver;
    }

    @Override
    public boolean update(Driver driver) {
        boolean result = false;
        int index = driverMapper.update(driver);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = driverMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Driver> getDriverList() {
        List<Driver> driverList = driverMapper.getDriverList();
        return driverList;
    }
}
