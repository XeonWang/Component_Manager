package xeon.cm.dao;

import org.hibernate.Session;
import xeon.cm.model.Person;
import xeon.cm.util.HibernateUtil;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 3:52 PM
 */
public class PersonDAO {
    public void save(Person person) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }
}
