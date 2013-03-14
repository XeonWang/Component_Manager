package xeon.cm.gui.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:59 PM
 */
public abstract class CMMenu extends JButton implements ActionListener {

    protected JPanel content;

    protected CMMenu(JPanel content) {
        this.content = content;
    }

    protected void build() {
        this.addActionListener(this);
    }

    public JPanel getContent() {
        return content;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buildPanel();
    }

    abstract protected void buildPanel();
}
