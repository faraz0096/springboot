package net.javaguide.springboot.services.imp;

import net.javaguide.springboot.exception.ResourceNotFoundException;
import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.repository.EmployeeRepository;
import net.javaguide.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByid(long id) {
        //   Optional<Employee> employee = employeeRepository.findById(id);
        //   if(employee.isPresent()){
        //     return employee.get();
        //   }else {

        // throw new ResourceNotFoundException("Employee" , "Id" , id);
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //We need to check whether employee with given id is existing or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee" , "Id" , id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //Save existing employee to database
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


}
