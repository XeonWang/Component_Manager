package xeon.cm.dao;

import junit.framework.TestCase;
import xeon.cm.model.Person;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 4:04 PM
 */
public class PersonDAOTest extends TestCase {

    public void testSave() {
        Person person = new Person();
        person.setName("Xeon");
        PersonDAO personDAO = new PersonDAO();
        personDAO.save(person);
    }
}
