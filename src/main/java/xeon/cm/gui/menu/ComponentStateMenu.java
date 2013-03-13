package xeon.cm.gui.menu;


import xeon.cm.gui.grid.StateTableModel;
import xeon.cm.gui.search.StateSearchBar;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

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
        JTable table = new JTable(new StateTableModel());
        getContent().add(table, BorderLayout.CENTER);
        getContent().validate();
    }
}
