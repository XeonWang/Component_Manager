package xeon.cm.gui.grid;

import javax.swing.JTable;
import javax.swing.table.TableModel;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class StateTable extends JTable {
	
	private static StateTable instance;
	
	private StateTable(TableModel model){
		super(model);
	}
	
    public static StateTable getInstance() {
    	if (instance == null) {
    		StateTableModel model = new StateTableModel();
    		instance = new StateTable(model);
    		model.setTable(instance);
    	}
    	return instance;
    }
}
