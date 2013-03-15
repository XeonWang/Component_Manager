package xeon.cm.gui.factory;

import javax.swing.JPanel;
import javax.swing.JTable;

import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.SearchBar;

public interface Factory {
	
	public CMMenu createMenu(JPanel content);
	
	public SearchBar createSearchBar();
	
	public JTable createTable();
	
	public CMTableModel createTableModel();
	
}
