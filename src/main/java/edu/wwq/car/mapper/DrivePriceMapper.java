package edu.wwq.car.mapper;

import edu.wwq.car.model.DrivePrice;

public interface DrivePriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrivePrice record);

    int insertSelective(DrivePrice record);

    DrivePrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DrivePrice record);

    int updateByPrimaryKey(DrivePrice record);
}