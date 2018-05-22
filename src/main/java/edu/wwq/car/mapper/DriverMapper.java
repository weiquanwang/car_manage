package edu.wwq.car.mapper;

import edu.wwq.car.model.Driver;

public interface DriverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
}