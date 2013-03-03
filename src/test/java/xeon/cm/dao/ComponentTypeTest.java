package xeon.cm.dao;

import junit.framework.TestCase;
import xeon.cm.model.ComponentType;
import xeon.cm.model.TypeField;

/**
 * User: xeon
 * Date: 3/3/13
 * Time: 4:59 PM
 */
public class ComponentTypeTest extends TestCase {
    public void testSave() {
        ComponentType componentType = new ComponentType();
        componentType.setName("Company1");
        TypeField typeField = new TypeField();
        typeField.setName("package");
        typeField.setType("string");
        TypeField typeField1 = new TypeField();
        typeField1.setName("ISDN");
        typeField1.setType("string");
        componentType.getFields().add(typeField);
        componentType.getFields().add(typeField1);
        ComponentTypeDAO componentTypeDAO = new ComponentTypeDAO();
        componentTypeDAO.save(componentType);
    }
}
