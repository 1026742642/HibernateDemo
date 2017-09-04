package Dao;

import entry.Employee;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.annotations.QueryBinder;
import org.hibernate.transform.Transformers;

import java.util.*;

/**
 * Created by lenovo on 2017/9/2.
 */
public class ManageEmployee<T> {
    private static SessionFactory factory;
    static {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static void main(String[] args) {

        ManageEmployee ME = new ManageEmployee();

      /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);

      /* List down all the employees */
        ME.listEmployees();

      /* Update employee's records */
        ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
        ME.deleteEmployee(empID2);

      /* List down new list of the employees */
        ME.listEmployees();
    }
    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to  READ all the employees */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /*only return first_name */
    public void queryFirstName(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List results = session.createQuery("select t.firstName from Employee t").list();
            for(Iterator iterator =
                results.iterator(); iterator.hasNext();){
                String firstName = (String) iterator.next();
                System.out.println("First Name: " + firstName);
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /*No return first_name */
    public void noQueryFirstName(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT t.firstName, t.lastName from Employee t";
            Query query = session.createQuery(hql);
            List<List<Object>> results = query.setResultTransformer(Transformers.TO_LIST).list();
            for(Iterator iterator =
                results.iterator(); iterator.hasNext();){
                List<Object> employee =(List<Object>) iterator.next();
                System.out.print("First Name: " + employee.get(0));
                System.out.println(" last Name: " + employee.get(1));
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Map> customSelect(String[] arrays, String className){
        if(arrays == null)
            return null;
        Session session = factory.openSession();
        Transaction tx = null;
        List<Map> result = new LinkedList<Map>();
        try{
            tx = session.beginTransaction();
            StringBuffer hql = new StringBuffer("SELECT ");
            hql.append(StringUtils.join(arrays, ", "));
            hql.append(" from "+className);
            Query query = session.createQuery(hql.toString());
            List<Map<String, Object>> results = query.setResultTransformer(Transformers.TO_LIST).list();
            int i=0;
            for(Iterator iterator =
                results.iterator(); iterator.hasNext();){
                List<List> employee =(List<List>) iterator.next();
                Map<String, Object> map = new HashMap<String, Object>();
                i= 0;
                for (Object object: employee) {
                    map.put(arrays[i], String.valueOf(object));
                    i++;
                }
                result.add(map);
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }
    public String join(String[] string){
        return String.join(",", string);
    }
    public static String selectString(Object[] a){
        if(a == null)
            return "null";
        int iMax = a.length -1;
        if(iMax == -1)
            return "* ";
        StringBuilder b = new StringBuilder();
        for(int i=0; ; i++){
            b.append(String.valueOf(a[i]));
            if(i == iMax)
                return b.toString();
            b.append(", ");
        }
    }

}
