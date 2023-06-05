package cobaspringapi.cobaspringapi.service.impl;

import cobaspringapi.cobaspringapi.domain.Employee;
import cobaspringapi.cobaspringapi.jpa.EmployeeRepository;
import cobaspringapi.cobaspringapi.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }
}
