package edu.wwq.car.service;

import edu.wwq.car.model.Driver;

import java.util.List;

public interface DriverService {

    boolean insert(Driver driver);

    Driver getDriverById(int id);

    boolean update(Driver driver);

    boolean delete(int id);

    List<Driver> getDriverList();

}
