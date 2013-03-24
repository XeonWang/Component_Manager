package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

import javax.swing.table.TableModel;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class PersonTable extends CMTable {


	private static PersonTable instance;

	private PersonTable(Factory factory, TableModel model){
		super(factory, model);
	}
	
    public static PersonTable getInstance(Factory factory, TableModel model) {
    	if (instance == null) {
    		instance = new PersonTable(factory, model);
    	}
    	return instance;
    }
}
