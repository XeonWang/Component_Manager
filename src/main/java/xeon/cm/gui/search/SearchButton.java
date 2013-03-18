package xeon.cm.gui.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTable;

import xeon.cm.gui.grid.CMTableModel;

public class SearchButton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = -7003415055684685446L;
	
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
		Map<String, String> critieras = searchBar.getSearchCritieras();
		((CMTableModel) table.getModel()).search(critieras);
	}

}
