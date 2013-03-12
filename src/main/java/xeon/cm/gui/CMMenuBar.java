package xeon.cm.gui;

import xeon.cm.gui.menu.*;

import javax.swing.*;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:10 PM
 */
public class CMMenuBar extends JMenuBar {

    public CMMenuBar(JPanel content) {
        this.add(new ComponentStateMenu(content));
        this.add(new ComponentInMenu(content));
        this.add(new ComponentOutMenu(content));
        this.add(new ComponentModifyMenu(content));
        this.add(new SystemManageMenu());
    }

}
