package xeon.cm.gui.grid.register;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.dao.ComponentOutDAO;
import xeon.cm.dao.PersonDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.Component;
import xeon.cm.model.ComponentOut;
import xeon.cm.model.Person;
import xeon.cm.util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: xeon
 * Date: 3/16/13
 * Time: 8:54 AM
 */
public class OutRegisterFrame extends JFrame implements Register {

	private static final long serialVersionUID = -5354471350340778635L;

	private static OutRegisterFrame instance;
	private Factory factory;

    private JComboBox<String> comps;
    private JFormattedTextField date;
    private JTextField count;
    private JComboBox<String> persons;
    private JTextField eId;
    private JTextField actionId;
    private JTextField remark;

    private ComponentOutDAO componentOutDAO;
    private ComponentDAO componentDAO;
    private PersonDAO personDAO;

    private OutRegisterFrame(Factory factory) {
        super("Out Register");
        this.factory = factory;

        componentDAO = new ComponentDAO();
        componentOutDAO = new ComponentOutDAO();
        personDAO = new PersonDAO();
        
        setSize(400, 300);
        build();
        setLocationRelativeTo(null);
    }

    public static OutRegisterFrame getInstance(Factory factory) {
        if (instance == null) instance = new OutRegisterFrame(factory);
        return instance;
    }

    private void build() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 5, 5, 5);
        constraints.gridwidth = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Comp: "), constraints);
        List<Component> components = componentDAO.load();
        List<String> compOptions = new ArrayList<>();
        for(Component component : components) {
        	compOptions.add(component.getId());
        }
        comps = new JComboBox<>(compOptions.toArray(new String[0]));
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(comps, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new JLabel("Date: "), constraints);
        date = new JFormattedTextField(new SimpleDateFormat(StringUtil.DATA_FORMAT));
        date.setColumns(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(date, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(new JLabel("Count: "), constraints);
        count = new JTextField();
        count.setColumns(10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(count, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(new JLabel("Person: "), constraints);
        List<Person> personEtities = personDAO.load();
        List<String> personOptions = new ArrayList<>();
        for(Person person : personEtities) {
            personOptions.add(person.getName());
        }
        persons = new JComboBox<>(personOptions.toArray(new String[0]));
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(persons, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(new JLabel("EID: "), constraints);
        eId = new JTextField();
        eId.setColumns(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(eId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(new JLabel("ActionID: "), constraints);
        actionId = new JTextField();
        actionId.setColumns(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(actionId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(new JLabel("Remark: "), constraints);
        remark = new JTextField();
        remark.setColumns(25);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        add(remark, constraints);

        add(new RegisterButton(this));
    }

    @Override
    public void register() {
        ComponentOut out = new ComponentOut();

        out.setComponent(componentDAO.getById(comps.getSelectedItem().toString()));
        @SuppressWarnings("deprecation")
		Date dateValue = new Date(date.getValue().toString());
		out.setDate(dateValue);
        out.setCount(Integer.parseInt(count.getText()));
        out.setPerson(personDAO.getByName((String) persons.getSelectedItem()));
        out.setEid(eId.getText());
        out.setActionIds(null);
        out.setMark(remark.getText());

        componentOutDAO.save(out);
        
        ((CMTableModel) factory.createTable().getModel()).load();
        this.setVisible(false);
        this.validate();
    }

}
