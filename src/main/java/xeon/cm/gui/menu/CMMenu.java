package xeon.cm.gui.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.gui.search.SearchBar;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:59 PM
 */
public abstract class CMMenu extends JButton implements ActionListener {

	private static final long serialVersionUID = 6561954541290933397L;

	protected JPanel content;
    
    protected SearchBar searchBar;
    protected JTable table;
    protected Factory factory;

    protected CMMenu(Factory factory, JPanel content) {
    	this.factory = factory;
        this.content = content;
    }

    public JPanel getContent() {
        return content;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buildPanel();
    }
    
    protected void buildPanel() {
    	getContent().removeAll();
        searchBar = factory.createSearchBar();
    	table = factory.createTable();
    	((CMTableModel) table.getModel()).load();
        getContent().add(searchBar, BorderLayout.NORTH);
        getContent().add(new JScrollPane(table), BorderLayout.CENTER);
        getContent().revalidate();
        getContent().repaint();
    }
}
