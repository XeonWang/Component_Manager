package xeon.cm.gui.grid;

import javax.swing.JTable;
import javax.swing.table.TableModel;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class StateTable extends JTable {
	
	private StateTable(TableModel model){
		super(model);
	}
	
    public static StateTable getInstance() {
    	return new StateTable(new StateTableModel());
    }
}
