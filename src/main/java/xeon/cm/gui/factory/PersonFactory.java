package xeon.cm.gui.factory;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.PersonTable;
import xeon.cm.gui.grid.register.PersonRegisterFrame;
import xeon.cm.gui.grid.register.PersonTableModel;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.PersonSearchBar;
import xeon.cm.gui.search.SearchBar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonFactory implements Factory {

	private static PersonFactory instance = new PersonFactory();

	private PersonFactory() {}
	
	public static PersonFactory getInstance(){
		return instance;
	}

	@SuppressWarnings("serial")
	@Override
	public CMMenu createMenu(JPanel content) {
		return new CMMenu(this, content) {};
	}

	@Override
	public SearchBar createSearchBar() {
		return PersonSearchBar.getInstance(this);
	}

	@Override
	public CMTable createTable() {
		return PersonTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new PersonTableModel();
	}

    @Override
    public JFrame createRegisterFrame() {
        return PersonRegisterFrame.getInstance(this);
    }
}
