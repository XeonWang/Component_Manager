package xeon.cm.gui.menu;

import xeon.cm.gui.factory.CompanyFactory;
import xeon.cm.gui.factory.ComponentTypeFactory;
import xeon.cm.gui.factory.PersonFactory;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class SystemManageMenu extends JMenu {

	private static final long serialVersionUID = -3656200783336311895L;

    private JPanel context;


    private JMenuItem typeItem;
    private JMenuItem companyItem;
    private JMenuItem personItem;

	public SystemManageMenu(JPanel context) {
        this.context = context;
        setText("System Manage");

        buildTypeItem();
        buildCompanyItem();
        buildPersonItem();

        add(typeItem);
        add(companyItem);
        add(personItem);
    }

    private void buildTypeItem() {
        ComponentTypeFactory factory = ComponentTypeFactory.getInstance();
        CMMenu typeMenu = factory.createMenu(context);
        typeItem = new JMenuItem("Type Manage");
        typeItem.addActionListener(typeMenu);
    }

    private void buildCompanyItem() {
        CompanyFactory factory = CompanyFactory.getInstance();
        CMMenu typeMenu = factory.createMenu(context);
        companyItem = new JMenuItem("Company Manage");
        companyItem.addActionListener(typeMenu);
    }

    private void buildPersonItem() {
        PersonFactory factory = PersonFactory.getInstance();
        CMMenu typeMenu = factory.createMenu(context);
        personItem = new JMenuItem("Person Manage");
        personItem.addActionListener(typeMenu);
    }
}
