package xeon.cm.gui.search;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:15 PM
 */
public class StateSearchBar extends JPanel {
    public StateSearchBar() {
        setLayout(new FlowLayout());
        setSize(800, 40);
        setBackground(Color.GRAY);
        add(new JLabel("ID: "));
        add(new JTextField(10));
        add(new JLabel("Type: "));
        add(new JTextField(10));
        add(new JLabel("Amount: "));
        add(new JTextField(10));
        add(new JButton("Search"));
    }
}
