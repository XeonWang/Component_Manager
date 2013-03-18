package xeon.cm.gui.menu;

import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentOutMenu extends CMMenu {

	private static final long serialVersionUID = -650727042250332717L;

	private static ComponentOutMenu instance;
	
	private ComponentOutMenu(Factory factory, JPanel content) {
        super(factory, content);
        this.setText("Component Out");
        addActionListener(this);
    }
	
	public static ComponentOutMenu getInstance(Factory factory, JPanel content) {
		if(instance == null) instance = new ComponentOutMenu(factory, content);
		return instance;
	}
}
