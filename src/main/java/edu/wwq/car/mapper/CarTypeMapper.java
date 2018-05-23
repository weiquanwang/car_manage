package edu.wwq.car.mapper;

import edu.wwq.car.model.CarType;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypeMapper {

    int insert(CarType carType);

    CarType selectByPrimaryKey(Integer id);

    int update(CarType carType);
}