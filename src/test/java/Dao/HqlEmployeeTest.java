package Dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.Map;

/**
 * HqlEmployee Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>09/05/2017</pre>
 */
public class HqlEmployeeTest {
    HqlEmployee ME;
    Integer empID1;
    Integer empID2;
    Integer empID3;

    @Before
    public void before() throws Exception {
        ME = new HqlEmployee();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: queryFirstName()
     */
    @Test
    public void testQueryFirstName() throws Exception {
//TODO: Test goes here...
        ME.queryFirstName();
    }

    /**
     * Method: noQueryFirstName()
     */
    @Test
    public void testNoQueryFirstName() throws Exception {
//TODO: Test goes here...
        ME.noQueryFirstName();
    }

    /**
     * Method: customSelect(String[] arrays, String className)
     */
    @Test
    public void testCustomSelect() throws Exception {
//TODO: Test goes here...
        String[] array = {"id", "firstName", "lastName", "salary"};
        List<Map> map = ME.customSelect(array, "Employee");
        System.out.println(map);
    }

    /**
     * Method: join(String[] string)
     */
    @Test
    public void testJoin() throws Exception {
//TODO: Test goes here... 
    }


} 
