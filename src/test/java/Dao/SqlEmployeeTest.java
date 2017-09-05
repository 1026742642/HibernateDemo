package Dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SqlEmployee Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since ¾ÅÔÂ 5, 2017
 */
public class SqlEmployeeTest {
    SqlEmployee ME;

    @Before
    public void before() throws Exception {
        ME = new SqlEmployee();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: listEmployeesScalar()
     */
    @Test
    public void testListEmployeesScalar() throws Exception {
//TODO: Test goes here...
        ME.listEmployeesScalar();
    }

    /**
     * Method: listEmployeesEntity()
     */
    @Test
    public void testListEmployeesEntity() throws Exception {
//TODO: Test goes here...
        ME.listEmployeesEntity();
    }


} 
