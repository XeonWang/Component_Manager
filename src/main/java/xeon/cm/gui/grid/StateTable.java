package xeon.cm.gui.grid;

import javax.swing.table.TableModel;

import xeon.cm.gui.factory.Factory;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class StateTable extends CMTable {

	private static final long serialVersionUID = -3751487942557336545L;
	
	private static StateTable instance;
	
	private StateTable(Factory factory, TableModel model){
		super(factory, model);
	}
	
    public static StateTable getInstance(Factory factory, TableModel model) {
    	if (instance == null) {
    		instance = new StateTable(factory, model);
    	}
    	return instance;
    }
}
