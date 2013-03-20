package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public abstract class CMTable extends JTable {

	private static final long serialVersionUID = -5038194229644048935L;
	
	protected Factory factory;
	public CMTable(Factory factory, TableModel model){
		super(model);
		this.factory = factory;
	}
}
