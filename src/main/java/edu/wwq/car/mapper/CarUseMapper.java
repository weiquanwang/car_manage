package edu.wwq.car.mapper;

import edu.wwq.car.model.CarUse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarUseMapper {

    int insert(CarUse carUse);

    CarUse getCarUseById(@Param("id") Integer id);

    int update(CarUse carUse);

    int delete(@Param("id") Integer id);

    List<CarUse> getCarUseList();

}