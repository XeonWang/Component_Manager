package xeon.cm.gui.grid;

import javax.swing.table.AbstractTableModel;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class StateTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 3;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "0023T31";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
