package edu.wwq.car.mapper;

import edu.wwq.car.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMapper {

    int insert(Car car);

    Car selectByPrimaryKey(Integer id);

    int update(Car car);
}