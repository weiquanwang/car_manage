package edu.wwq.car.service;

import edu.wwq.car.model.Department;

import java.util.List;

public interface DepartmentService {

    boolean insert(String name, String departmentLeader);

    Department getDepartmentById(int id);

    boolean update(Department department);

    boolean delete(int id);

    List<Department> getDepartmentList();
}
