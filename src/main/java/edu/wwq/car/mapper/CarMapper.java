package edu.wwq.car.mapper;

import edu.wwq.car.model.Car;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {

    int insert(Car car);

    Car getCarById(@Param("id") Integer id);

    int update(Car car);

    int delete(@Param("id") Integer id);

    List<Car> getCarList();
}