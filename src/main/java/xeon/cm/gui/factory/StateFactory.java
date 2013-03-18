package xeon.cm.gui.factory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.StateTable;
import xeon.cm.gui.grid.StateTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.menu.ComponentStateMenu;
import xeon.cm.gui.search.SearchBar;
import xeon.cm.gui.search.StateSearchBar;

import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

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
        throw new ActionNotSupportedException("This factory can not create Regist Frame");
    }
}
