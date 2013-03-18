package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:46 PM
 */
public class OutTable extends CMTable {

	private static final long serialVersionUID = 879635264103712682L;

	private OutTable(Factory factory, CMTableModel model) {
        super(factory, model);
    }

    private static OutTable instance;

    public static OutTable getInstance(Factory factory, CMTableModel model) {
        if (instance == null) {
            instance = new OutTable(factory, model);
        }
        return instance;
    }
}
