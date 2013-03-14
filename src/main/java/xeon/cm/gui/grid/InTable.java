package xeon.cm.gui.grid;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:46 PM
 */
public class InTable extends JTable {
    private InTable(TableModel model) {
        super(model);
    }

    private static InTable instance;

    public static InTable getInstance() {
        if (instance == null) {
            InTableModel model = new InTableModel();
            instance = new InTable(model);
            model.setTable(instance);
        }
        return instance;
    }
}
