package xeon.cm.gui.grid.register;

import javax.swing.JFrame;

/**
 * User: xeon
 * Date: 3/16/13
 * Time: 8:54 AM
 */
public class InRegisterFrame extends JFrame {

    private static InRegisterFrame instance;

    private InRegisterFrame() {
        super("In Register");
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static InRegisterFrame getInstance() {
        if (instance == null) instance = new InRegisterFrame();
        return instance;
    }
}
