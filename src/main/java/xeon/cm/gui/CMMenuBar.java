package xeon.cm.gui;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.factory.InFactory;
import xeon.cm.gui.factory.StateFactory;
import xeon.cm.gui.menu.SystemManageMenu;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:10 PM
 */
public class CMMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1364258261329504302L;
	
	private Factory stateFactory = StateFactory.getInstance();
	private Factory inFactory = InFactory.getInstance();

    public CMMenuBar(JPanel content) {
        this.add(stateFactory.createMenu(content));
        this.add(inFactory.createMenu(content));
//        this.add(new ComponentOutMenu(content));
//        this.add(new ComponentModifyMenu(content));
        this.add(new SystemManageMenu());
    }

}
