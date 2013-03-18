package xeon.cm.gui.menu;



import javax.swing.JPanel;
import javax.swing.JTable;

import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.search.SearchBar;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentStateMenu extends CMMenu {

	private static final long serialVersionUID = -2036918408329425419L;
	
	private static ComponentStateMenu instance;

    private ComponentStateMenu(Factory factory, JPanel content) {
        super(factory, content);
        setText("Component State");
        addActionListener(this);
    }
    
    public static ComponentStateMenu getInstance(Factory factory, JPanel content) {
    	if(instance == null) {
    		instance = new ComponentStateMenu(factory, content);
    	}
    	return instance;
    }

	public SearchBar getStateSearchBar() {
		return searchBar;
	}

	public JTable getStateTable() {
		return table;
	}
}
