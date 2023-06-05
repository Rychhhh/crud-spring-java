package cobaspringapi.cobaspringapi.api;

import cobaspringapi.cobaspringapi.domain.Employee;
import cobaspringapi.cobaspringapi.exception.ResourceNotFoundException;
import cobaspringapi.cobaspringapi.jpa.EmployeeRepository;
import cobaspringapi.cobaspringapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {


    @Autowired
    private EmployeeRepository  employeeRepository;


    // list employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // get employe by id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Exist with ID:" + id));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(Long id) {
         employeeRepository.deleteById(id);
    }


    // create emplloyhe

    // metode post sederhana
  /*  @PostMapping("/employees")
    public Employee createEmployee(@RequestBody  Employee employee) {
        return employeeRepository.save(employee);
    }*/

    // metode post menggunakan bussiness logic
    private EmployeeService employeeService;

    // constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // api


    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }





}
