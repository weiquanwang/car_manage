package edu.wwq.car.service.impl;

import edu.wwq.car.mapper.DepartmentMapper;
import edu.wwq.car.model.Department;
import edu.wwq.car.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public Department getDepartmentById(int id) {
        Department department = departmentMapper.getDepartmentById(id);
        return department;
    }

    @Override
    public boolean update(Department department) {
        boolean result = false;
        int index = departmentMapper.update(department);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int index = departmentMapper.delete(id);
        if (index > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Department> getDepartmentList() {
        List<Department> departmentList = departmentMapper.getDepartmentList();
        if (departmentList == null) {
            departmentList = new ArrayList<Department>();
        }
        return departmentList;
    }
}
