package edu.wwq.car.mapper;

import edu.wwq.car.model.CarUse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarUseMapper {

    int insert(CarUse carUse);

    CarUse selectByPrimaryKey(@Param("id") Integer id);

    int update(CarUse carUse);

}