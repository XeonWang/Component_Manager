package xeon.cm.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import xeon.cm.model.Person;
import xeon.cm.util.HibernateUtil;

import java.util.List;

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

    @SuppressWarnings("unchecked")
	public List<Person> load() {
        List<Person> results;
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        results = session.createCriteria(Person.class).list();
        session.getTransaction().commit();
        return results;
    }

    public Person getByName(String name) {
        Person result;
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class).add(Restrictions.eq("name", name));
        result = (Person) criteria.uniqueResult();
        session.getTransaction().commit();
        return result;
    }

}
