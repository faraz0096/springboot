package net.javaguide.springboot.service;

import net.javaguide.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee (Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeByid(long id);

    Employee updateEmployee(Employee employee , long id);

}
