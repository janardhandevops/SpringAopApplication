package com.example.aop.springaop.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.aop.springaop.model.Department;
import com.example.aop.springaop.repository.DepartmentRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DepartmentService.class})
@ExtendWith(SpringExtension.class)
class DepartmentServiceTest {
    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentService#save(Department)}
     */
    @Test
    void testSave() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        when(this.departmentRepository.save((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertSame(department, this.departmentService.save(department1));
        verify(this.departmentRepository).save((Department) any());
    }

    /**
     * Method under test: {@link DepartmentService#findById(Integer)}
     */
    @Test
    void testFindById() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        Optional<Department> ofResult = Optional.of(department);
        when(this.departmentRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(department, this.departmentService.findById(1));
        verify(this.departmentRepository).findById((Integer) any());
    }
}

