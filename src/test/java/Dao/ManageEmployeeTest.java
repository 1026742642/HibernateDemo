package Dao;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * ManageEmployee Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>09/02/2017</pre>
 */
public class ManageEmployeeTest {
    ManageEmployee ME;
    Integer empID1;
    Integer empID2;
    Integer empID3;

    @Before
    public void before() throws Exception {
        ME = new ManageEmployee();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addEmployee(String fname, String lname, int salary)
     */
    @Test
    public void testAddEmployee() throws Exception {
//TODO: Test goes here...
        /* Add few employee records in database */
        empID1 = ME.addEmployee("Zara", "Ali", 1000);
        empID2 = ME.addEmployee("Daisy", "Das", 5000);
        empID3 = ME.addEmployee("John", "Paul", 10000);
    }

    /**
     * Method: listEmployees()
     */
    @Test
    public void testListEmployees() throws Exception {
//TODO: Test goes here...
        ME.listEmployees();
    }

    /**
     * Method: updateEmployee(Integer EmployeeID, int salary)
     */
    @Test
    public void testUpdateEmployee() throws Exception {
//TODO: Test goes here...
        /* Update employee's records */
        ME.updateEmployee(empID1, 5000);
    }

    /**
     * Method: deleteEmployee(Integer EmployeeID)
     */
    @Test
    public void testDeleteEmployee() throws Exception {
//TODO: Test goes here...
        ME.deleteEmployee(empID2);
    }
} 
