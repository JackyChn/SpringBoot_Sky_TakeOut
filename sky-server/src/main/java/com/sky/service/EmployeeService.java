package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

//     add new employee
    void save(EmployeeDTO employeeDTO);

//    pageQuery
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

//    change status
    void changeStatus(Integer status, Long id);

//    getEmployee by id
    Employee getById(Long id);

//    update employee info
    void update(EmployeeDTO employeeDTO);
}
