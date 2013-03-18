package xeon.cm.gui.grid;

import java.util.List;
import java.util.Map;

import xeon.cm.dao.ComponentOutDAO;
import xeon.cm.model.ComponentOut;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:51 PM
 */
public class OutTableModel extends CMTableModel {

	private static final long serialVersionUID = -1519300740529845992L;
	
	private ComponentOutDAO componentOutDAO;
    private List<ComponentOut> outs;

    public OutTableModel() {
    	componentOutDAO = new ComponentOutDAO();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Comp";
            case 1:
                return "Date";
            case 2:
                return "Count";
            case 3:
                return "EID";
            case 4:
                return "Person";
            case 5:
                return "Remark";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return outs.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ComponentOut out = outs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return out.getComponent().getId();
            case 1:
                return out.getDate();
            case 2:
                return out.getCount();
            case 3:
                return out.getEId();
            case 4:
                return out.getPerson();
            case 5:
                return out.getMark();
        }
        return "";
    }

	@Override
	public void load() {
		outs = componentOutDAO.load();
		fireTableDataChanged();
	}

	@Override
	public void search(Map<String, String> critieras) {
    	outs = componentOutDAO.search(critieras);
    	fireTableDataChanged();
	}
}
