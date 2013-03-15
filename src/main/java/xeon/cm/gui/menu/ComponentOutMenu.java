package xeon.cm.gui.menu;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentOutMenu extends CMMenu {

	private static final long serialVersionUID = -650727042250332717L;

	public ComponentOutMenu(Factory factory, JPanel content) {
        super(factory, content);
        this.setText("Component Out");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void buildPanel() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
