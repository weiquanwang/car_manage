package edu.wwq.car.mapper;

import edu.wwq.car.model.DrivePrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrivePriceMapper {

    int insert(DrivePrice drivePrice);

    DrivePrice getDrivePriceById(@Param("id") Integer id);

    int update(DrivePrice drivePrice);

    int delete(@Param("id") Integer id);

    List<DrivePrice> getDrivePriceList();
}