package xeon.cm.gui.menu;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import xeon.cm.gui.grid.StateTable;
import xeon.cm.gui.grid.StateTableModel;
import xeon.cm.gui.search.StateSearchBar;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentStateMenu extends CMMenu {

    public ComponentStateMenu(JPanel content) {
        super(content);
        this.setText("Component State");
        this.build();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buildPanel();
    }

    private void buildPanel() {
        getContent().add(new StateSearchBar(), BorderLayout.NORTH);
        getContent().add(new JScrollPane(StateTable.getInstance()), BorderLayout.CENTER);
        getContent().validate();
    }
}
