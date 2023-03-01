package com.example.aop.springaop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Method under test: {@link Employee#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Employee()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Employee#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Employee employee = new Employee();

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertTrue(employee.canEqual(employee1));
    }

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

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        assertNotEquals(employee, null);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals2() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        assertNotEquals(employee, "Different type to Employee");
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals3() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        assertEquals(employee, employee);
        int expectedHashCodeResult = employee.hashCode();
        assertEquals(expectedHashCodeResult, employee.hashCode());
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals4() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertEquals(employee, employee1);
        int expectedHashCodeResult = employee.hashCode();
        assertEquals(expectedHashCodeResult, employee1.hashCode());
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals5() {
        Employee employee = new Employee();
        employee.setDepartment("Name");
        employee.setId(1);
        employee.setName("Name");

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertNotEquals(employee, employee1);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals6() {
        Employee employee = new Employee();
        employee.setDepartment(null);
        employee.setId(1);
        employee.setName("Name");

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertNotEquals(employee, employee1);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals7() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(123);
        employee.setName("Name");

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertNotEquals(employee, employee1);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals8() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Department");

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertNotEquals(employee, employee1);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals9() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName(null);

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName("Name");
        assertNotEquals(employee, employee1);
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals10() {
        Employee employee = new Employee();
        employee.setDepartment(null);
        employee.setId(1);
        employee.setName("Name");

        Employee employee1 = new Employee();
        employee1.setDepartment(null);
        employee1.setId(1);
        employee1.setName("Name");
        assertEquals(employee, employee1);
        int expectedHashCodeResult = employee.hashCode();
        assertEquals(expectedHashCodeResult, employee1.hashCode());
    }

    /**
     * Method under test: {@link Employee#equals(Object)}
     */
    @Test
    void testEquals11() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName(null);

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setId(1);
        employee1.setName(null);
        assertEquals(employee, employee1);
        int expectedHashCodeResult = employee.hashCode();
        assertEquals(expectedHashCodeResult, employee1.hashCode());
    }
}

