package xeon.hibernate.model;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * User: xeon
 * Date: 2/26/13
 * Time: 10:00 PM
 */
public class Test extends TestCase {

    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
         sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    protected void tearDown() throws Exception {
         if (sessionFactory != null) {
             sessionFactory.close();
         }
    }

    public void testUserInsert() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = new User();
        user.setName("Xeon");
        user.setAge(25);
        Address address = new Address();
        address.setAddr1("address1");
        address.setAddr2("address2");
        user.setAddress(address);
        session.save(user);
        session.getTransaction().commit();
    }
}
