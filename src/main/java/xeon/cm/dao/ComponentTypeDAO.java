package xeon.cm.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import xeon.cm.model.ComponentType;
import xeon.cm.util.HibernateUtil;

import java.util.List;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 4:36 PM
 */
public class ComponentTypeDAO {
    public void save(ComponentType componentType) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(componentType);
        session.getTransaction().commit();
    }

    public List<ComponentType> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<ComponentType> results = session.createCriteria(ComponentType.class).list();
        session.getTransaction().commit();
        return results;
    }

    public ComponentType getByName(String name) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        ComponentType result = (ComponentType) session.createCriteria(ComponentType.class).add(Restrictions.eq("name", name)).uniqueResult();
        session.getTransaction().commit();
        return result;
    }
}
