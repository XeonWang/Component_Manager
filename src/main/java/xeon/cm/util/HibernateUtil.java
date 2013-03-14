package xeon.cm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 3:53 PM
 */
public class HibernateUtil {
    public static SessionFactory sessionFactory;
    
    public static void init() {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
