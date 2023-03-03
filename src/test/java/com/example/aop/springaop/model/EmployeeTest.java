package com.example.aop.springaop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employee}
     *   <li>{@link Employee#setDepartment(String)}
     *   <li>{@link Employee#setId(int)}
     *   <li>{@link Employee#setName(String)}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        actualEmployee.setDepartment("Department");
        actualEmployee.setId(1);
        actualEmployee.setName("Name");
        assertEquals("Department", actualEmployee.getDepartment());
        assertEquals(1, actualEmployee.getId());
        assertEquals("Name", actualEmployee.getName());
    }
}

