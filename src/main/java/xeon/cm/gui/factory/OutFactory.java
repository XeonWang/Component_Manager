package xeon.cm.gui.factory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.OutTable;
import xeon.cm.gui.grid.OutTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.menu.ComponentOutMenu;
import xeon.cm.gui.search.OutSearchBar;
import xeon.cm.gui.search.SearchBar;

public class OutFactory implements Factory {
	
	private OutFactory() {} 
	
	private static OutFactory instance;
	
	public static OutFactory getInstance() {
		if(instance == null) instance = new OutFactory();
		return instance;
	}

	@Override
	public CMMenu createMenu(JPanel content) {
		return ComponentOutMenu.getInstance(this, content);
	}

	@Override
	public SearchBar createSearchBar() {
		return OutSearchBar.getInstance(this);
	}

	@Override
	public CMTable createTable() {
		return OutTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new OutTableModel();
	}

	@Override
	public JFrame createRegisterFrame() {
		return null;
	}

}
