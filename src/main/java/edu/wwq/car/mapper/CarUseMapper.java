package edu.wwq.car.mapper;

import edu.wwq.car.model.CarUse;

public interface CarUseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarUse record);

    int insertSelective(CarUse record);

    CarUse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarUse record);

    int updateByPrimaryKey(CarUse record);
}