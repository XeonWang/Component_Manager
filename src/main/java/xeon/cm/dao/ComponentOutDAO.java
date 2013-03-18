package xeon.cm.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import xeon.cm.model.ComponentOut;
import xeon.cm.util.HibernateUtil;

public class ComponentOutDAO {
	
	public List<ComponentOut> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<ComponentOut> outs = session.createCriteria(ComponentOut.class).list();
        session.getTransaction().commit();
        return outs;
	}
	
	public List<ComponentOut> search(Map<String, String> criterias) {
		return null;
	}
}
