package xeon.cm.dao;

import org.hibernate.Session;
import xeon.cm.model.ComponentIn;
import xeon.cm.util.HibernateUtil;

import java.util.List;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 11:01 PM
 */
public class ComponentInDAO {

    public List<ComponentIn> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
//        List<ComponentIn> ins = session.createCriteria(ComponentIn.class).list();
        List<ComponentIn> ins = session.createQuery("FROM ComponentIn").list();
        session.getTransaction().commit();
        return ins;
    }
}
