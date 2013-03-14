package xeon.cm.gui.menu;

import xeon.cm.gui.grid.InTable;
import xeon.cm.gui.search.InSearchBar;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:49 PM
 */
public class ComponentInMenu extends CMMenu {

    private InSearchBar inSearchBar = InSearchBar.getInstance();
    private InTable inTable = InTable.getInstance();

    private static ComponentInMenu instance;

    private ComponentInMenu(JPanel content) {
        super(content);
        setText("Component In");
        build();
    }

    public static ComponentInMenu getInstance(JPanel content) {
        if (instance == null) instance = new ComponentInMenu(content);
        return instance;
    }

    @Override
    protected void buildPanel() {
        getContent().add(inSearchBar, BorderLayout.NORTH);
        getContent().add(inTable, BorderLayout.CENTER);
        getContent().validate();
    }
}
