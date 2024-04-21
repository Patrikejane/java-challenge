package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.EmployeeEntityNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

/**
 * Service implementation for managing employees.
 *
 * @author user.name@axalife.com
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

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
    @Override
    @Cacheable(value = "employees")
    public List<Employee> retrieveEmployees() {
        logger.info("Retrieving all employees");
        return employeeRepository.findAll();
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return an Optional containing the employee if found, otherwise empty
     */

    @Override
    @Cacheable(value = "employees", key = "#employeeId")
    public Employee getEmployee(Long employeeId) {
        logger.info("get employee by ID"+ employeeId);

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
    @Override
    @CacheEvict(value = "employees", key = "#employeeId")
    public void deleteEmployee(Long employeeId) {
        logger.info("delete employee by ID " + employeeId);
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
     * @param employee the updated employee object
     */
    @Override
    @CacheEvict(value = "employees", key = "#employeeId")
    public void updateEmployee(Long employeeId, Employee employee) {
        logger.info("delete employee by ID " + employeeId);
        if (employeeRepository.existsById(employeeId)) {
            employee.setId(employeeId);
            employeeRepository.save(employee);
        } else{
            throw new EmployeeEntityNotFoundException("Employee not exist","Employee with id " + employeeId + " cannot be found!");
        }
    }

}