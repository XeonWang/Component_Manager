package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

import javax.swing.table.TableModel;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class ComponentTypeTable extends CMTable {


	private static ComponentTypeTable instance;

	private ComponentTypeTable(Factory factory, TableModel model){
		super(factory, model);
	}
	
    public static ComponentTypeTable getInstance(Factory factory, TableModel model) {
    	if (instance == null) {
    		instance = new ComponentTypeTable(factory, model);
    	}
    	return instance;
    }
}
