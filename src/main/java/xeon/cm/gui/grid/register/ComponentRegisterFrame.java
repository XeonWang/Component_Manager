package xeon.cm.gui.grid.register;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.dao.ComponentTypeDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.Component;
import xeon.cm.model.ComponentType;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xeon
 * Date: 3/16/13
 * Time: 8:54 AM
 */
public class ComponentRegisterFrame extends JFrame implements Register {

	private static final long serialVersionUID = -5354471350340778635L;

	private static ComponentRegisterFrame instance;
	private Factory factory;

    private JTextField name;
    private JComboBox<String> type;

    private ComponentDAO componentDAO;
    private ComponentTypeDAO componentTypeDAO;

    private ComponentRegisterFrame(Factory factory) {
        super("Component Register");
        this.factory = factory;

        componentDAO = new ComponentDAO();
        componentTypeDAO = new ComponentTypeDAO();

        setSize(400, 300);
        build();
        setLocationRelativeTo(null);
    }

    public static ComponentRegisterFrame getInstance(Factory factory) {
        if (instance == null) instance = new ComponentRegisterFrame(factory);
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

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new JLabel("Type: "), constraints);
        List<ComponentType> types = componentTypeDAO.load();
        List<String> typeOptions = new ArrayList<>();
        for(ComponentType type : types) {
        	typeOptions.add(type.getName());
        }
        type = new JComboBox<>(typeOptions.toArray(new String[0]));
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(type, constraints);

        add(new RegisterButton(this));
    }

    @Override
    public void register() {
        Component component = new Component();

        component.setId(name.getText());
        component.setComponentType(componentTypeDAO.getByName((String)type.getSelectedItem()));
        component.setAmount(0);

        componentDAO.save(component);
        
        ((CMTableModel) factory.createTable().getModel()).load();
        this.setVisible(false);
        this.validate();
    }

}
