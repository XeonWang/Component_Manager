package xeon.cm.gui.factory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.SearchBar;

public interface Factory {
	
	CMMenu createMenu(JPanel content);
	
	SearchBar createSearchBar();
	
	CMTable createTable();
	
	CMTableModel createTableModel();

    JFrame createRegisterFrame();
	
}
