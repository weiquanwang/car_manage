package edu.wwq.car.mapper;

import edu.wwq.car.model.CarMaintenance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMaintenanceMapper {

    int insert(CarMaintenance carMaintenance);

    CarMaintenance getCarMaintenanceById(@Param("id") Integer id);

    int update(CarMaintenance carMaintenance);

    int delete(@Param("id") Integer id);

    List<CarMaintenance> getCarMaintenanceList();

}