package edu.wwq.car.mapper;

import edu.wwq.car.model.CarType;

public interface CarTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarType record);

    int insertSelective(CarType record);

    CarType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);
}