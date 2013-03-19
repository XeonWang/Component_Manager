package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public abstract class CMTable extends JTable {

	protected Factory factory;
	public CMTable(Factory factory, TableModel model){
		super(model);
		this.factory = factory;
	}
}
