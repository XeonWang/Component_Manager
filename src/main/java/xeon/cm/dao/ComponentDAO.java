package xeon.cm.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import xeon.cm.model.Component;
import xeon.cm.util.HibernateUtil;

/**
 * User: xeon
 * Date: 3/13/13
 * Time: 8:40 PM
 */
public class ComponentDAO {
    public List<Component> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
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
    
	@SuppressWarnings("unchecked")
	public List<Component> search(Map<String, String> critieras) {
    	Session session = HibernateUtil.sessionFactory.getCurrentSession();
    	session.beginTransaction();
    	Criteria hibernateCriteria = session.createCriteria(Component.class);
    	Set<String> keySet = critieras.keySet();
    	for (String key : keySet) {
    		switch(key) {
    		case "id":
    			hibernateCriteria.add(Restrictions.like("id", critieras.get(key) + "%"));
    			break;
    		case "type":
    			hibernateCriteria.createCriteria("componentType").add(Restrictions.like("name", critieras.get(key) + "%"));
    			break;
    		case "amountBegin":
    			hibernateCriteria.add(Restrictions.ge("amount", Long.parseLong(critieras.get(key))));
    			break;
    		case "amountEnd":
    			hibernateCriteria.add(Restrictions.le("amount", Long.parseLong(critieras.get(key))));
    			break;
    		}
    	}
    	List<Component> components = hibernateCriteria.list();
    	session.getTransaction().commit();
    	return components;
    }
}
