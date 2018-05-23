package edu.wwq.car.mapper;

import edu.wwq.car.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {

    int insert(Department department);

    Department selectByPrimaryKey(Integer id);

    int update(Department record);
}