package xeon.cm.gui.factory;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.StateTable;
import xeon.cm.gui.grid.StateTableModel;
import xeon.cm.gui.grid.register.ComponentRegisterFrame;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.menu.ComponentStateMenu;
import xeon.cm.gui.search.SearchBar;
import xeon.cm.gui.search.StateSearchBar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StateFactory implements Factory {
	
	private static StateFactory instance = new StateFactory();
	
	private StateFactory() {}
	
	public static StateFactory getInstance(){
		return instance;
	}

	@Override
	public CMMenu createMenu(JPanel content) {
		return ComponentStateMenu.getInstance(this, content);
	}

	@Override
	public SearchBar createSearchBar() {
		return StateSearchBar.getInstance(this);
	}

	@Override
	public CMTable createTable() {
		return StateTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new StateTableModel();
	}

    @Override
    public JFrame createRegisterFrame() {
        return ComponentRegisterFrame.getInstance(this);
    }
}
