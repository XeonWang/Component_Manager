package xeon.cm.gui.menu;


import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentInMenu extends CMMenu {

	private static final long serialVersionUID = -7835164409305743978L;
	
	private static ComponentInMenu instance;

    private ComponentInMenu(Factory factory, JPanel content) {
        super(factory, content);
        setText("Component In");
        addActionListener(this);
    }

    public static ComponentInMenu getInstance(Factory factory, JPanel content) {
        if (instance == null) instance = new ComponentInMenu(factory, content);
        return instance;
    }

}
