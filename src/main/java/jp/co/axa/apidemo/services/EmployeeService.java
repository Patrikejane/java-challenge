package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;
import java.util.Optional;


/**
 * Service interface for managing employees.
 *
 * @author user.name@axalife.com
 * @version 1.0
 */
public interface EmployeeService {

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    List<Employee> retrieveEmployees();

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return an Optional containing the employee if found, otherwise empty
     */
    Employee getEmployee(Long employeeId);

    /**
     * Saves a new employee.
     *
     * @param employee the employee to save
     */
    void saveEmployee(Employee employee);

    /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to delete
     */
    void deleteEmployee(Long employeeId);

    /**
     * Updates an existing employee.
     *
     * @param employeeId the ID of the employee to update
     * @param employee   the updated employee object
     */
    void updateEmployee(Long employeeId, Employee employee);
}