package xeon.cm.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class SystemManageMenu extends JMenu {

	private static final long serialVersionUID = -3656200783336311895L;

    private JMenuItem componentItem;
    private JMenuItem typeItem;
    private JMenuItem companyItem;
    private JMenuItem personItem;

	public SystemManageMenu() {
        setText("System Manage");

        buildComponentItem();
        buildTypeItem();
        buildCompanyItem();
        buildPersonItem();

        add(componentItem);
        add(typeItem);
        add(companyItem);
        add(personItem);
    }

    private void buildComponentItem() {
        componentItem = new JMenuItem("Component Manage");
    }

    private void buildTypeItem() {
        typeItem = new JMenuItem("Type Manage");
    }

    private void buildCompanyItem() {
        companyItem = new JMenuItem("Company Manage");
    }

    private void buildPersonItem() {
        personItem = new JMenuItem("Person Manage");
    }
}
