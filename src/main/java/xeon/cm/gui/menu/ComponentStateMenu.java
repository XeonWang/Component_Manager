package xeon.cm.gui.menu;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import xeon.cm.gui.grid.StateTable;
import xeon.cm.gui.grid.StateTableModel;
import xeon.cm.gui.search.StateSearchBar;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentStateMenu extends CMMenu {
	
	private StateSearchBar stateSearchBar = StateSearchBar.getInstance();
	private StateTable stateTable = StateTable.getInstance();
	
	private static ComponentStateMenu instance;

    private ComponentStateMenu(JPanel content) {
        super(content);
        this.setText("Component State");
        this.build();
    }
    
    public static ComponentStateMenu getInstance(JPanel content) {
    	if(instance == null) {
    		instance = new ComponentStateMenu(content);
    	}
    	return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buildPanel();
    }

    private void buildPanel() {
        getContent().add(stateSearchBar, BorderLayout.NORTH);
        getContent().add(stateTable, BorderLayout.CENTER);
        getContent().validate();
    }

	public StateSearchBar getStateSearchBar() {
		return stateSearchBar;
	}

	public StateTable getStateTable() {
		return stateTable;
	}
    
}
