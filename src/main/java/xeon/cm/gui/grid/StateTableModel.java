package xeon.cm.gui.grid;

import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.model.Component;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class StateTableModel extends AbstractTableModel {

    private ComponentDAO componentDAO;
    private List<Component> components;
    private JTable table;

    public StateTableModel() {
        componentDAO = new ComponentDAO();
        components = componentDAO.load();
    }
    
    public void setTable(JTable table) {
		this.table = table;
	}

	@Override
	public String getColumnName(int column) {
    	switch (column) {
	        case 0:
	            return "ID";
	        case 1:
	            return "Type";
	        case 2:
	            return "Amount";
	    }
	    return "";
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
    
    public void search(Map<String, String> critieras) {
    	components = componentDAO.search(critieras);
    	fireTableDataChanged();
    }
}
