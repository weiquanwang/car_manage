package edu.wwq.car.mapper;

import edu.wwq.car.model.Driver;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverMapper {

    int insert(Driver driver);

    Driver getDriverById(@Param("id") Integer id);

    int update(Driver driver);

    int delete(@Param("id") Integer id);

    List<Driver> getDriverList();
}