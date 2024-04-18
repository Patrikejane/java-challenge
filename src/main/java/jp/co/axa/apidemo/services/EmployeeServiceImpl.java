package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeEntityNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

/**
 * Service implementation for managing employees.
 *
 * @author user.name@axalife.com
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    /**
     * Constructs an EmployeeServiceImpl with the given EmployeeRepository.
     *
     * @param employeeRepository the repository for employee data access
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return an Optional containing the employee if found, otherwise empty
     */
    public Employee getEmployee(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId).orElseThrow(
                        () -> new EmployeeEntityNotFoundException("Employee not found",
                        "Employee with id " + employeeId + " cannot be found!"));
        return employee;
    }

    /**
     * Saves a new employee.
     *
     * @param employee the employee to save
     */
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to delete
     */
    public void deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else{
            throw new EmployeeEntityNotFoundException("Employee not exist","Employee with id " + employeeId + " cannot be found!");
        }
    }

    /**
     * Updates an existing employee.
     *
     * @param employeeId the ID of the employee to update
     * @param employee   the updated employee object
     */
    public void updateEmployee(Long employeeId, Employee employee) {
        if (employeeRepository.existsById(employeeId)) {
            employee.setId(employeeId);
            employeeRepository.save(employee);
        } else{
            throw new EmployeeEntityNotFoundException("Employee not exist","Employee with id " + employeeId + " cannot be found!");
        }
    }

}