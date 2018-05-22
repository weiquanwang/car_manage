package edu.wwq.car.mapper;

import edu.wwq.car.model.CarMaintenance;

public interface CarMaintenanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarMaintenance record);

    int insertSelective(CarMaintenance record);

    CarMaintenance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarMaintenance record);

    int updateByPrimaryKey(CarMaintenance record);
}