package xeon.cm.gui;

import xeon.cm.gui.menu.*;

import javax.swing.*;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:10 PM
 */
public class CMMenuBar extends JMenuBar {

    public CMMenuBar() {
        this.add(new ComponentStateMenu());
        this.add(new ComponentInMenu());
        this.add(new ComponentOutMenu());
        this.add(new ComponentModifyMenu());
        this.add(new SystemManageMenu());
    }

}
