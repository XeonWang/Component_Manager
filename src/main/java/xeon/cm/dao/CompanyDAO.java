package xeon.cm.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import xeon.cm.model.Company;
import xeon.cm.util.HibernateUtil;

import java.util.List;

/**
 * User: xeon
 * Date: 3/17/13
 * Time: 10:39 PM
 */
public class CompanyDAO {

    public void save(Company company) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
    }

	public List<Company> load() {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List <Company> companies = (List<Company>) session.createCriteria(Company.class).list();
        session.getTransaction().commit();
        return companies;
	}
	
    public Company getById(int id) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = (Company) session.get(Company.class, id);
        session.getTransaction().commit();
        return company;
    }

    public Company getByName(String name) {
        Session session = HibernateUtil.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = (Company) session.createCriteria(Company.class).add(Restrictions.eq("name", name)).uniqueResult();
        session.getTransaction().commit();
        return company;
    }
}
