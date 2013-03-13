package xeon.cm.gui.grid;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.model.Component;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class StateTableModel extends AbstractTableModel {

    private ComponentDAO componentDAO;
    private List<Component> components;

    public StateTableModel() {
        componentDAO = new ComponentDAO();
        components = componentDAO.load();
    }

    @Override
    public int getRowCount() {
        return components.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Component component = components.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return component.getId();
            case 1:
                return component.getComponentType().getName();
            case 2:
                return component.getAmount();
        }
        return "";
    }
}
