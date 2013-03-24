package xeon.cm.gui.grid.register;

import xeon.cm.dao.ComponentTypeDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.ComponentType;

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
public class ComponentTypeRegisterFrame extends JFrame implements Register {

	private static final long serialVersionUID = -5354471350340778635L;

	private static ComponentTypeRegisterFrame instance;
	private Factory factory;

    private JTextField name;

    private ComponentTypeDAO componentTypeDAO;

    private ComponentTypeRegisterFrame(Factory factory) {
        super("Component Type Register");
        this.factory = factory;

        componentTypeDAO = new ComponentTypeDAO();

        setSize(400, 300);
        build();
        setLocationRelativeTo(null);
    }

    public static ComponentTypeRegisterFrame getInstance(Factory factory) {
        if (instance == null) instance = new ComponentTypeRegisterFrame(factory);
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
        ComponentType componentType = new ComponentType();

        componentType.setName(name.getText());

        componentTypeDAO.save(componentType);
        
        ((CMTableModel) factory.createTable().getModel()).load();
        this.setVisible(false);
        this.validate();
    }

}
