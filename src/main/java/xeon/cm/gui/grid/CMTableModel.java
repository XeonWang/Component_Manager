package xeon.cm.gui.grid;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

public abstract class CMTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -836108730723531982L;

	public abstract void load();
	
	public abstract void search(Map<String, String> critieras);
}
