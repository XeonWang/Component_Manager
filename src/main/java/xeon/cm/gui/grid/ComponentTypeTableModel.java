package xeon.cm.gui.grid;

import xeon.cm.dao.ComponentTypeDAO;
import xeon.cm.model.ComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class ComponentTypeTableModel extends CMTableModel {

	private static final long serialVersionUID = 7308535920494682060L;

	private ComponentTypeDAO componentTypeDAO;
    private List<ComponentType> componentTypes;

    public ComponentTypeTableModel() {
        componentTypeDAO = new ComponentTypeDAO();
    }

	@Override
	public String getColumnName(int column) {
    	switch (column) {
	        case 0:
	            return "Name";
	    }
	    return "";
	}

	@Override
    public int getRowCount() {
        return componentTypes.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ComponentType componentType = componentTypes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return componentType.getName();
        }
        return "";
    }
    
    @Override
    public void search(Map<String, String> critieras) {
        componentTypes = new ArrayList<ComponentType>();
        ComponentType type;
        if (critieras.get("name") != null) {
            type = componentTypeDAO.getByName(critieras.get("name"));
            if (type != null) {
                componentTypes.add(type);
            }
        } else {
            componentTypes = componentTypeDAO.load();
        }

    	fireTableDataChanged();
    }
    
    @Override
    public void load() {
    	componentTypes = componentTypeDAO.load();
    	fireTableDataChanged();
    }
}
