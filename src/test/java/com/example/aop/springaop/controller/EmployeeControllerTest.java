package com.example.aop.springaop.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.aop.springaop.model.Employee;
import com.example.aop.springaop.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#findById(Integer)}
     */
    @Test
    void testFindById() throws Exception {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        when(this.employeeService.findById((Integer) any())).thenReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"department\":\"Department\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#findById(Integer)}
     */
    @Test
    void testFindById2() throws Exception {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        when(this.employeeService.findById((Integer) any())).thenReturn(employee);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employees/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\",\"department\":\"Department\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#save(Employee)}
     */
    @Test
    void testSave() throws Exception {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

