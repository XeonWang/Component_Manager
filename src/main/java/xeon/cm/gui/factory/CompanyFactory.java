package xeon.cm.gui.factory;

import xeon.cm.gui.grid.CMTable;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.grid.CompanyTable;
import xeon.cm.gui.grid.CompanyTableModel;
import xeon.cm.gui.grid.register.CompanyRegisterFrame;
import xeon.cm.gui.menu.CMMenu;
import xeon.cm.gui.search.CompanySearchBar;
import xeon.cm.gui.search.SearchBar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CompanyFactory implements Factory {

	private static CompanyFactory instance = new CompanyFactory();

	private CompanyFactory() {}
	
	public static CompanyFactory getInstance(){
		return instance;
	}

	@SuppressWarnings("serial")
	@Override
	public CMMenu createMenu(JPanel content) {
		return new CMMenu(this, content) {};
	}

	@Override
	public SearchBar createSearchBar() {
		return CompanySearchBar.getInstance(this);
	}

	@Override
	public CMTable createTable() {
		return CompanyTable.getInstance(this, createTableModel());
	}

	@Override
	public CMTableModel createTableModel() {
		return new CompanyTableModel();
	}

    @Override
    public JFrame createRegisterFrame() {
        return CompanyRegisterFrame.getInstance(this);
    }
}
