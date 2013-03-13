package xeon.cm.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import xeon.cm.model.Component;
import xeon.cm.util.HibernateUtil;

import java.util.List;

/**
 * User: xeon
 * Date: 3/13/13
 * Time: 8:40 PM
 */
public class ComponentDAO {
    public List<Component> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Component> components = session.createQuery("FROM Component").list();
        session.getTransaction().commit();
        return components;
    }

    public int count() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(*) FROM Component");
        int count = (Integer) query.uniqueResult();
        session.getTransaction().commit();
        return count;
    }
}
