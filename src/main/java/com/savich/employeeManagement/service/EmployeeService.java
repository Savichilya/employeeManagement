package com.savich.employeeManagement.service;

import com.savich.employeeManagement.dao.EmployeeDao;
import com.savich.employeeManagement.dto.EmployeeDto;
import com.savich.employeeManagement.entity.Employee;
import com.savich.employeeManagement.exception.EmployeeNotFoundException;
import com.savich.employeeManagement.mapping.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeDao employeeDao, EmployeeMapper employeeMapper) {
        this.employeeDao = employeeDao;
        this.employeeMapper = employeeMapper;
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        return employeeDao.save(employeeMapper.mapToEmployee(employeeDto));
    }

    public void updateEmployee(int id, EmployeeDto employeeDto) {
        Employee employee=employeeMapper.mapToEmployee(employeeDto);
        employee.setEmployeeId(id);
        employeeDao.save(employee);
    }

    public void deleteEmployeeById(int id) {
        employeeDao.deleteById(id);
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found, id is incorrect"));
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeDao.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }


}
