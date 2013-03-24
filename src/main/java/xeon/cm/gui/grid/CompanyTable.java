package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

import javax.swing.table.TableModel;


/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:40 PM
 */
public class CompanyTable extends CMTable {


	private static CompanyTable instance;

	private CompanyTable(Factory factory, TableModel model){
		super(factory, model);
	}
	
    public static CompanyTable getInstance(Factory factory, TableModel model) {
    	if (instance == null) {
    		instance = new CompanyTable(factory, model);
    	}
    	return instance;
    }
}
