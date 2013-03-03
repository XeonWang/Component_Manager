package xeon.cm.dao;

import org.hibernate.Session;
import xeon.cm.model.ComponentType;
import xeon.cm.util.HibernateUtil;

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
}
