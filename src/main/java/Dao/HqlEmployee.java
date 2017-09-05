package Dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import java.util.*;

/**
 * Created by lenovo on 2017/9/5.
 */
public class HqlEmployee<T>  extends EmployeeDao{

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
}
