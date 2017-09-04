package Dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.Configuration;
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
    }

    /**
     * Method: deleteEmployee(Integer EmployeeID)
     */
    @Test
    public void testDeleteEmployee() throws Exception {
//TODO: Test goes here... 
    }

    @Test
    public void testQueryFirstName() throws Exception {
        ME.queryFirstName();
    }

    @Test
    public void testNoQueryFirstName() throws Exception {
        ME.noQueryFirstName();
    }

    @Test
    public void testjoin() throws Exception {
        String[] array = {"a", "b", "c", "d"};
        System.out.println(ME.join(array));
    }

    @Test
    public void testSelect() throws Exception {
        String[] array = {"a", "b", "c", "d"};
        System.out.println(StringUtils.join(array, "-"));
    }
    @Test
    public void testCustomSelect() throws Exception {
        String[] array = {"id", "firstName", "lastName", "salary"};
        List<Map> map = ME.customSelect(array, "Employee");
        System.out.println(map);
    }

} 
