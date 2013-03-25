package xeon.cm.gui.factory;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.ComponentTypeTable;
import xeon.cm.gui.grid.ComponentTypeTableModel;
import xeon.cm.gui.grid.register.ComponentTypeRegisterFrame;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.ComponentTypeSearchBar;
import xeon.cm.gui.search.SearchBar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentTypeFactory implements Factory {

	private static ComponentTypeFactory instance = new ComponentTypeFactory();

	private ComponentTypeFactory() {}
	
	public static ComponentTypeFactory getInstance(){
		return instance;
	}

	@SuppressWarnings("serial")
	@Override
	public CMMenu createMenu(JPanel content) {
		return new CMMenu(this, content) {};
	}

	@Override
	public SearchBar createSearchBar() {
		return ComponentTypeSearchBar.getInstance(this);
	}

	@Override
	public CMTable createTable() {
		return ComponentTypeTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new ComponentTypeTableModel();
	}

    @Override
    public JFrame createRegisterFrame() {
        return ComponentTypeRegisterFrame.getInstance(this);
    }
}
