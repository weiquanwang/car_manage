package edu.wwq.car.service;

import edu.wwq.car.model.CarType;

import java.util.List;

public interface CarTypeService {

    boolean insert(String name);

    List<CarType> getCarTypeList();
}
