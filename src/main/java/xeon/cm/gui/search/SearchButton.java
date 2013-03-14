package xeon.cm.gui.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTable;

import xeon.cm.gui.grid.StateTableModel;

public class SearchButton extends JButton implements ActionListener {
	
	private SearchBar searchBar;
	private JTable table;
	
	public SearchButton(SearchBar searchBar, JTable table) {
		this.searchBar = searchBar;
		this.table = table;
		setText("Search");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		StateSearchBar stateSearchBar = StateSearchBar.getInstance();
		Map<String, String> critieras = searchBar.getSearchCritieras();
//		StateTable stateTable = StateTable.getInstance();
		((StateTableModel) table.getModel()).search(critieras);
	}

}
