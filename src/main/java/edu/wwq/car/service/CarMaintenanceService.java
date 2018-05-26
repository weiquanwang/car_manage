package edu.wwq.car.service;

import edu.wwq.car.model.CarMaintenance;

import java.util.List;

public interface CarMaintenanceService {

    boolean insert(CarMaintenance carMaintenance);

    CarMaintenance getCarMaintenanceById(int id);

    boolean update(CarMaintenance carMaintenance);

    boolean delete(int id);

    List<CarMaintenance> getCarMaintenanceList();
}
