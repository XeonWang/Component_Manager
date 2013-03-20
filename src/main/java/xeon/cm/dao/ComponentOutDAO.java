package xeon.cm.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import xeon.cm.model.ComponentOut;
import xeon.cm.util.HibernateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComponentOutDAO {
	
	public List<ComponentOut> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<ComponentOut> outs = session.createCriteria(ComponentOut.class).list();
        session.getTransaction().commit();
        return outs;
	}

    public void save(ComponentOut componentOut) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(componentOut);
        session.getTransaction().commit();
    }
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<ComponentOut> search(Map<String, String> criterias) {
        List<ComponentOut> results;
        Set<String> keys = criterias.keySet();
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ComponentOut.class);
        for (String key : keys) {
            switch (key) {
                case "componentId":
                    criteria.add(Restrictions.like("component.id", criterias.get(key) + "%"));
                    break;
                case "date":
                    criteria.add(Restrictions.eq("date", new Date(criterias.get(key))));
                    break;
                case "countBegin":
                    criteria.add(Restrictions.ge("count", Integer.parseInt(criterias.get(key))));
                    break;
                case "countEnd":
                    criteria.add(Restrictions.le("count", Integer.parseInt(criterias.get(key))));
                    break;
                case "eId":
                    criteria.add(Restrictions.like("eid", criterias.get(key) + "%"));
                    break;
                case "person":
                    criteria.createCriteria("person").add(Restrictions.eq("name", criterias.get(key)));
                    break;
            }
        }
        results = criteria.list();
        session.getTransaction().commit();
		return results;
	}
}
