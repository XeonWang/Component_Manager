package xeon.cm.gui.grid;

import xeon.cm.dao.ComponentInDAO;
import xeon.cm.model.ComponentIn;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:51 PM
 */
public class InTableModel extends AbstractTableModel {

    private ComponentInDAO componentInDAO;
    private List<ComponentIn> ins;
    private JTable table;

    public InTableModel() {
        componentInDAO = new ComponentInDAO();
        ins = componentInDAO.load();
    }

    public void setTable(JTable table) {
        this.table = table;
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
                return "Price";
            case 4:
                return "Company";
            case 5:
                return "ActionID";
            case 6:
                return "Remark";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return ins.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ComponentIn in = ins.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return in.getComponent().getId();
            case 1:
                return in.getDate();
            case 2:
                return in.getCount();
            case 3:
                return in.getPrice();
            case 4:
                return in.getCompany();
            case 5:
                return in.getActionId();
            case 6:
                return in.getMark();
        }
        return "";
    }
}
