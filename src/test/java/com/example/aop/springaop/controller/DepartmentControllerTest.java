package com.example.aop.springaop.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.aop.springaop.model.Department;
import com.example.aop.springaop.service.DepartmentService;
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

@ContextConfiguration(classes = {DepartmentController.class})
@ExtendWith(SpringExtension.class)
class DepartmentControllerTest {
    @Autowired
    private DepartmentController departmentController;

    @MockBean
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentController#findById(Integer)}
     */
    @Test
    void testFindById() throws Exception {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        when(this.departmentService.findById((Integer) any())).thenReturn(department);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#findById(Integer)}
     */
    @Test
    void testFindById2() throws Exception {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        when(this.departmentService.findById((Integer) any())).thenReturn(department);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/departments/{id}", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.departmentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Name\"}"));
    }
//
//    /**
//     * Method under test: {@link DepartmentController#save(Department)}
//     */
//    @Test
//    void testSave() throws Exception {
//        Department department = new Department();
//        department.setId(1);
//        department.setName("Name");
//        String content = (new ObjectMapper()).writeValueAsString(department);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.departmentController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
//    }
//
//    /**
//     * Method under test: {@link DepartmentController#save(Department)}
//     */
//    @Test
//    void testSave2() throws Exception {
//        Department department = new Department();
//        department.setId(1);
//        department.setName("Name");
//        String content = (new ObjectMapper()).writeValueAsString(department);
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.departmentController)
//                .build()
//                .perform(requestBuilder);
//        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
//    }
}

