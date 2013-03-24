package xeon.cm.gui.grid.register;

import xeon.cm.dao.PersonDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.Person;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * User: xeon
 * Date: 3/16/13
 * Time: 8:54 AM
 */
public class PersonRegisterFrame extends JFrame implements Register {


	private static PersonRegisterFrame instance;
	private Factory factory;

    private JTextField name;

    private PersonDAO personDAO;

    private PersonRegisterFrame(Factory factory) {
        super("Person Register");
        this.factory = factory;

        personDAO = new PersonDAO();

        setSize(400, 300);
        build();
        setLocationRelativeTo(null);
    }

    public static PersonRegisterFrame getInstance(Factory factory) {
        if (instance == null) instance = new PersonRegisterFrame(factory);
        return instance;
    }

    private void build() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 5, 5, 5);
        constraints.gridwidth = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Name: "), constraints);
        name = new JTextField();
        name.setColumns(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(name, constraints);

        add(new RegisterButton(this));
    }

    @Override
    public void register() {
        Person person = new Person();

        person.setName(name.getText());

        personDAO.save(person);
        
        ((CMTableModel) factory.createTable().getModel()).load();
        this.setVisible(false);
        this.validate();
    }

}
