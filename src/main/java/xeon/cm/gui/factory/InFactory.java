package xeon.cm.gui.factory;

import javax.swing.JPanel;
import javax.swing.JTable;

import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.InTable;
import xeon.cm.gui.grid.InTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.menu.ComponentInMenu;
import xeon.cm.gui.search.InSearchBar;
import xeon.cm.gui.search.SearchBar;

public class InFactory implements Factory {
	
	private static InFactory instance = new InFactory();
	
	private InFactory() {}
	
	public static InFactory getInstance(){
		return instance;
	}

	@Override
	public CMMenu createMenu(JPanel content) {
		return ComponentInMenu.getInstance(this, content);
	}

	@Override
	public SearchBar createSearchBar() {
		return InSearchBar.getInstance(this);
	}

	@Override
	public JTable createTable() {
		return InTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new InTableModel();
	}

}
