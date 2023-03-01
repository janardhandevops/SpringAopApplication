package com.example.aop.springaop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DepartmentTest {
    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Department()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Department department = new Department();

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertTrue(department.canEqual(department1));
    }

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

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        assertNotEquals(department, null);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals2() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        assertNotEquals(department, "Different type to Department");
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals3() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        assertEquals(department, department);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department.hashCode());
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals4() {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals5() {
        Department department = new Department();
        department.setId(123);
        department.setName("Name");

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals6() {
        Department department = new Department();
        department.setId(1);
        department.setName(null);

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals7() {
        Department department = new Department();
        department.setId(1);
        department.setName("com.example.aop.springaop.model.Department");

        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals8() {
        Department department = new Department();
        department.setId(1);
        department.setName(null);

        Department department1 = new Department();
        department1.setId(1);
        department1.setName(null);
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }
}

