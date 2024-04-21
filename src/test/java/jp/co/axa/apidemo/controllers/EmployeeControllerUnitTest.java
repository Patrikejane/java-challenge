package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class EmployeeControllerUnitTest {

        @Mock
        private EmployeeService employeeService;

        @InjectMocks
        private EmployeeController employeeController;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testGetEmployees() {
            // Arrange
            Employee employee1 = new Employee(1L, "John", 10,"L");
            Employee employee2 = new Employee(2L, "Jane", 10,"L");
            List<Employee> employees = Arrays.asList(employee1, employee2);

            when(employeeService.retrieveEmployees()).thenReturn(employees);

            // Act
            ResponseEntity<List<Employee>> responseEntity = employeeController.getEmployees();

            // Assert
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertEquals(employees, responseEntity.getBody());
            verify(employeeService, times(1)).retrieveEmployees();
        }

        @Test
        public void testGetEmployee() {
            // Arrange
            Long employeeId = 1L;
            Employee employee = new Employee(employeeId, "John",10,"L");

            when(employeeService.getEmployee(employeeId)).thenReturn(employee);

            // Act
            ResponseEntity<Employee> responseEntity = employeeController.getEmployee(employeeId);

            // Assert
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertEquals(employee, responseEntity.getBody());
            verify(employeeService, times(1)).getEmployee(employeeId);
        }

        @Test
        public void testSaveEmployee() {
            // Arrange
            Employee employee = new Employee(1L, "John", 10,"L");

            // Act
            ResponseEntity<Void> responseEntity = employeeController.saveEmployee(employee);

            // Assert
            assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
            verify(employeeService, times(1)).saveEmployee(employee);
        }

        @Test
        public void testDeleteEmployee() {
            // Arrange
            Long employeeId = 1L;

            // Act
            ResponseEntity<Void> responseEntity = employeeController.deleteEmployee(employeeId);

            // Assert
            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
            verify(employeeService, times(1)).deleteEmployee(employeeId);
        }

        @Test
        public void testUpdateEmployee() {
            // Arrange
            Long employeeId = 1L;
            Employee employee = new Employee(employeeId, "John", 10,"L");

            // Act
            ResponseEntity<Void> responseEntity = employeeController.updateEmployee(employee, employeeId);

            // Assert
            assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
            verify(employeeService, times(1)).updateEmployee(employeeId, employee);
        }
    }


