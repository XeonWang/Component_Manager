package xeon.cm.dao;

import java.util.List;

import org.hibernate.Session;

import xeon.cm.model.Component;
import xeon.cm.model.ComponentIn;
import xeon.cm.util.HibernateUtil;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 11:01 PM
 */
public class ComponentInDAO {

    public List<ComponentIn> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<ComponentIn> ins = session.createCriteria(ComponentIn.class).list();
        session.getTransaction().commit();
        return ins;
    }

    public void save(ComponentIn componentIn) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Component component = componentIn.getComponent();
        component.setAmount(component.getAmount() + componentIn.getCount());
        session.saveOrUpdate(component);
        session.save(componentIn);
        session.getTransaction().commit();
    }
}
