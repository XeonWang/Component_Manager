package xeon.cm.gui.grid;

import java.util.List;
import java.util.Map;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.model.Component;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class StateTableModel extends CMTableModel {

	private static final long serialVersionUID = 7308535920494682060L;
	
	private ComponentDAO componentDAO;
    private List<Component> components;

    public StateTableModel() {
        componentDAO = new ComponentDAO();
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
    
    @Override
    public void search(Map<String, String> critieras) {
    	components = componentDAO.search(critieras);
    	fireTableDataChanged();
    }
    
    @Override
    public void load() {
    	components = componentDAO.load();
    	fireTableDataChanged();
    }
}
