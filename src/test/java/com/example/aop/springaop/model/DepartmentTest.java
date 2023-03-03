package com.example.aop.springaop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DepartmentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Department}
     *   <li>{@link Department#setId(int)}
     *   <li>{@link Department#setName(String)}
     * </ul>
     */
    @Test
    void testConstructor() {
        Department actualDepartment = new Department();
        actualDepartment.setId(1);
        actualDepartment.setName("Name");
        assertEquals(1, actualDepartment.getId());
        assertEquals("Name", actualDepartment.getName());
    }
}

