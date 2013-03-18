package xeon.cm.gui.grid.register;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: xeon
 * Date: 3/17/13
 * Time: 10:22 PM
 */
public class RegisterButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 5756402537319586568L;
	
	private Register register;

    public RegisterButton(Register register) {
        this.register = register;
        setText("Register");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        register.register();
    }
}
