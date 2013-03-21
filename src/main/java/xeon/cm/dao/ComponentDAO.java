package xeon.cm.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import xeon.cm.model.ActionModel;
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

    public Component getById(String id) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Component component = (Component) session.get(Component.class, id);
        session.getTransaction().commit();
        return component;
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

    public void save(Component component) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(component);
        session.getTransaction().commit();
    }
    
    public List<ActionModel> getActionInfo(String componentId) {
    	List<ActionModel> results = new ArrayList<ActionModel>();
    	Session session = HibernateUtil.sessionFactory.getCurrentSession();
    	session.beginTransaction();
    	Query query = session.createSQLQuery("select cin.actionId, " +
    			"sum(cin.change_count)/count(cin.change_count) - " +
    			"case when sum(action.count) is null " +
    			"then 0 else sum(action.count) end amount " +
    			"from Component_in as cin left join Component_out as cout " +
    			"on cout.component_id = cin.component_id " +
    			"left join Out_action as action " +
    			"on cout.id = action.out_id where cin.component_id = ? " +
    			"group by action.actionId, cin.actionId;");
    	query.setString(0, componentId);
    	@SuppressWarnings("unchecked")
		List<Object[]> sqlresults = query.list();
    	for(Object[] obj : sqlresults) {
    		results.add(new ActionModel((String)obj[0], ((BigDecimal)obj[1]).intValue()));
    	}
    	session.getTransaction().commit();
    	return results;
    }
}
