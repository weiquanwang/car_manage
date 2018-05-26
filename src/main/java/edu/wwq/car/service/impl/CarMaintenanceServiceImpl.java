package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.CarMaintenanceMapper;
import edu.wwq.car.model.CarMaintenance;
import edu.wwq.car.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarMaintenanceServiceImpl implements CarMaintenanceService {

    @Autowired
    private CarMaintenanceMapper carMaintenanceMapper;

    @Override
    public boolean insert(CarMaintenance carMaintenance) {
        boolean result = false;
        int index = carMaintenanceMapper.insert(carMaintenance);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public CarMaintenance getCarMaintenanceById(int id) {
        CarMaintenance carMaintenance = carMaintenanceMapper.getCarMaintenanceById(id);
        return carMaintenance;
    }

    @Override
    public boolean update(CarMaintenance carMaintenance) {
        boolean result = false;
        int index = carMaintenanceMapper.update(carMaintenance);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = carMaintenanceMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<CarMaintenance> getCarMaintenanceList() {
        List<CarMaintenance> carMaintenanceList = carMaintenanceMapper.getCarMaintenanceList();
        return carMaintenanceList;
    }
}
