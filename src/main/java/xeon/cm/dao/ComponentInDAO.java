package xeon.cm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import xeon.cm.model.Component;
import xeon.cm.model.ComponentIn;
import xeon.cm.util.HibernateUtil;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 11:01 PM
 */
public class ComponentInDAO {
	
	@SuppressWarnings("deprecation")
	public List<ComponentIn> search(Map<String, String> critieras) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria hibernateCriteria = session.createCriteria(ComponentIn.class);
		Set<String> keySet = critieras.keySet();
		for (String key : keySet) {
			switch(key) {
			case "componentId":
				hibernateCriteria.add(Restrictions.like("component.id", critieras.get(key) + "%"));
				break;
			case "date":
				hibernateCriteria.add(Restrictions.eq("date", new Date(critieras.get(key))));
				break;
			case "countBegin":
				hibernateCriteria.add(Restrictions.ge("count", Integer.parseInt(critieras.get(key))));
				break;
			case "countEnd":
				hibernateCriteria.add(Restrictions.le("count", Integer.parseInt(critieras.get(key))));
				break;
			case "priceBegin":
				hibernateCriteria.add(Restrictions.ge("price", Double.parseDouble(critieras.get(key))));
				break;
			case "priceEnd":
				hibernateCriteria.add(Restrictions.le("price", Double.parseDouble(critieras.get(key))));
				break;
			case "company":
				hibernateCriteria.createCriteria("company").add(Restrictions.like("name", critieras.get(key) + "%"));
				break;
			case "actionId":
				hibernateCriteria.add(Restrictions.eq("actionId", critieras.get(key)));
				break;
			}
		}
		@SuppressWarnings("unchecked")
		List<ComponentIn> results = (List<ComponentIn>) hibernateCriteria.list();
		session.getTransaction().commit();
		return results;
	}

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
