package edu.wwq.car.service;

import edu.wwq.car.model.Car;

public interface CarService {

    boolean insert(Car car);

    boolean update(Car car);

    Car getCarById(int id);

    boolean delete(Car car);
}
