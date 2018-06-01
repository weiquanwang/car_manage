package edu.wwq.car.mapper;

import edu.wwq.car.model.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    int insert(Department department);

    Department getDepartmentById(@Param("id") Integer id);

    int update(Department department);

    int delete(@Param("id") Integer id);

    List<Department> getDepartmentList();
}