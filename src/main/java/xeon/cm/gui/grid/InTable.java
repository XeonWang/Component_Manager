package xeon.cm.gui.grid;

import xeon.cm.gui.factory.Factory;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:46 PM
 */
public class InTable extends CMTable {

	private static final long serialVersionUID = 879635264103712682L;

	private InTable(Factory factory, CMTableModel model) {
        super(factory, model);
    }

    private static InTable instance;

    public static InTable getInstance(Factory factory, CMTableModel model) {
        if (instance == null) {
            instance = new InTable(factory, model);
        }
        return instance;
    }
}
