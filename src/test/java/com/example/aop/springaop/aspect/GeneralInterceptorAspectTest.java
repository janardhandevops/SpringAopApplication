package com.example.aop.springaop.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.aop.springaop.model.Department;
import com.example.aop.springaop.model.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GeneralInterceptorAspect.class})
@ExtendWith(SpringExtension.class)
class GeneralInterceptorAspectTest {
    @Autowired
    private GeneralInterceptorAspect generalInterceptorAspect;

    /**
     * Method under test: {@link GeneralInterceptorAspect#before(org.aspectj.lang.JoinPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBefore() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.aspectj.lang.JoinPoint.getSignature()" because "joinPoint" is null
        //       at com.example.aop.springaop.aspect.GeneralInterceptorAspect.before(GeneralInterceptorAspect.java:24)
        //   In order to prevent before(JoinPoint)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   before(JoinPoint).
        //   See https://diff.blue/R013 to resolve this issue.

        this.generalInterceptorAspect.before(null);
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#before(JoinPoint)}
     */
    @Test
    void testBefore2() {
        JoinPoint joinPoint = mock(JoinPoint.class);
        when(joinPoint.getSignature()).thenReturn(null);
        this.generalInterceptorAspect.before(joinPoint);
        verify(joinPoint).getSignature();
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#after(org.aspectj.lang.JoinPoint, Employee)}
     */
    @Test
    void testAfter() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        this.generalInterceptorAspect.after(null, employee);
        assertEquals("Department", employee.getDepartment());
        assertEquals("Name", employee.getName());
        assertEquals(1, employee.getId());
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#after(org.aspectj.lang.JoinPoint, Employee)}
     */
    @Test
    void testAfter2() {
        Employee employee = mock(Employee.class);
        doNothing().when(employee).setDepartment((String) any());
        doNothing().when(employee).setId(anyInt());
        doNothing().when(employee).setName((String) any());
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        this.generalInterceptorAspect.after(null, employee);
        verify(employee).setDepartment((String) any());
        verify(employee).setId(anyInt());
        verify(employee).setName((String) any());
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#after(org.aspectj.lang.JoinPoint, Exception)}
     */
    @Test
    void testAfter3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by after(JoinPoint, Exception)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.generalInterceptorAspect.after(null, new Exception("An error occurred"));
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#after(org.aspectj.lang.JoinPoint, Exception)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAfter4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Exception.getMessage()" because "e" is null
        //       at com.example.aop.springaop.aspect.GeneralInterceptorAspect.after(GeneralInterceptorAspect.java:36)
        //   In order to prevent after(JoinPoint, Exception)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   after(JoinPoint, Exception).
        //   See https://diff.blue/R013 to resolve this issue.

        this.generalInterceptorAspect.after(null, (Exception) null);
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(org.aspectj.lang.ProceedingJoinPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAround() throws Throwable {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.aspectj.lang.ProceedingJoinPoint.getArgs()" because "joinPoint" is null
        //       at com.example.aop.springaop.aspect.GeneralInterceptorAspect.around(GeneralInterceptorAspect.java:42)
        //   In order to prevent around(ProceedingJoinPoint)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   around(ProceedingJoinPoint).
        //   See https://diff.blue/R013 to resolve this issue.

        this.generalInterceptorAspect.around(null);
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(ProceedingJoinPoint)}
     */
    @Test
    void testAround2() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("Proceed");
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertEquals("Proceed", this.generalInterceptorAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(ProceedingJoinPoint)}
     */
    @Test
    void testAround3() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenThrow(new Exception("An error occurred"));
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertThrows(Exception.class, () -> this.generalInterceptorAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(ProceedingJoinPoint)}
     */
    @Test
    void testAround4() throws Throwable {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setId(1);
        employee.setName("Name");
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn(employee);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertSame(employee, this.generalInterceptorAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint, atLeast(1)).getArgs();
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(ProceedingJoinPoint)}
     */
    @Test
    void testAround5() throws Throwable {
        Department department = new Department();
        department.setId(1);
        department.setName("Name");
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn(department);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertSame(department, this.generalInterceptorAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint, atLeast(1)).getArgs();
    }

    /**
     * Method under test: {@link GeneralInterceptorAspect#around(ProceedingJoinPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAround6() throws Throwable {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at com.example.aop.springaop.aspect.GeneralInterceptorAspect.around(GeneralInterceptorAspect.java:42)
        //   In order to prevent around(ProceedingJoinPoint)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   around(ProceedingJoinPoint).
        //   See https://diff.blue/R013 to resolve this issue.

        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("Proceed");
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{});
        this.generalInterceptorAspect.around(proceedingJoinPoint);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link GeneralInterceptorAspect}
     *   <li>{@link GeneralInterceptorAspect#loggingPointCut()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        (new GeneralInterceptorAspect()).loggingPointCut();
    }
}

