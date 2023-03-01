package com.example.aop.springaop.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.aop.springaop.model.Employee;
import com.example.aop.springaop.repository.EmployeeRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#save(Employee)}
     */
    @Test
    void testSave() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        when(this.employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertSame(employee, this.employeeService.save(employee1));
        verify(this.employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#findById(Integer)}
     */
    @Test
    void testFindById() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        Optional<Employee> ofResult = Optional.of(employee);
        when(this.employeeRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(employee, this.employeeService.findById(1));
        verify(this.employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeService#findById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.orElseThrow(Optional.java:377)
        //       at com.example.aop.springaop.service.EmployeeService.findById(EmployeeService.java:19)
        //   In order to prevent findById(Integer)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());
        this.employeeService.findById(1);
    }
}

