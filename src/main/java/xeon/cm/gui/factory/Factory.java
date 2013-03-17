package xeon.cm.gui.factory;

import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.SearchBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public interface Factory {
	
	CMMenu createMenu(JPanel content);
	
	SearchBar createSearchBar();
	
	JTable createTable();
	
	CMTableModel createTableModel();

    JFrame createRegisterFrame();
	
}
