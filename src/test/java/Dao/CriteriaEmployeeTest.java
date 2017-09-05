package Dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CriteriaEmployee Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since ¾ÅÔÂ 5, 2017
 */
public class CriteriaEmployeeTest {
    CriteriaEmployee ME;
    Integer empID1;
    Integer empID2;
    Integer empID3;

    @Before
    public void before() throws Exception {
        ME = new CriteriaEmployee();
    }

    @After
    public void after() throws Exception {
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
     * Method: countEmployee()
     */
    @Test
    public void testCountEmployee() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: totalSalary()
     */
    @Test
    public void testTotalSalary() throws Exception {
//TODO: Test goes here... 
    }


} 
