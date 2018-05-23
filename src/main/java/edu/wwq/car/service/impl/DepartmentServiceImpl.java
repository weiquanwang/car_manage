package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.DepartmentMapper;
import edu.wwq.car.model.Department;
import edu.wwq.car.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean insert(String name, String departmentLeader) {
        boolean result = false;
        Department department = new Department();
        department.setName(name);
        department.setDepartmentLeader(departmentLeader);
        department.setCreateTime(new Date());
        int index = departmentMapper.insert(department);
        if (index > 0) {
            result = true;
        }
        return result;
    }
}
