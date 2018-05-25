package edu.wwq.car.service;

import edu.wwq.car.model.CarUse;

import java.util.List;

public interface CarUseService {

    boolean insert(CarUse carUse);

    CarUse getCarUseById(int id);

    boolean update(CarUse carUse);

    boolean delete(int id);

    List<CarUse> getCarUseList();
}
