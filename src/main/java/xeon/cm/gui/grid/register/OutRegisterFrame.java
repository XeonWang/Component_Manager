package xeon.cm.gui.grid.register;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import xeon.cm.dao.ComponentDAO;
import xeon.cm.dao.ComponentOutDAO;
import xeon.cm.dao.PersonDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.ActionModel;
import xeon.cm.model.Component;
import xeon.cm.model.ComponentOut;
import xeon.cm.model.Person;
import xeon.cm.util.StringUtil;

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
    private JList<ActionModel> actionIds;
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
        
        buildComponentField();
        buildDateField();
        buildCountField();
        buildPersonField();
        buildEidField();
        buildActionsField();
        buildRemarkField();
        
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
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(comps, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new JLabel("Date: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(date, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(new JLabel("Count: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(count, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(new JLabel("Person: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(persons, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(new JLabel("EID: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(eId, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(new JLabel("ActionIDs: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(actionIds, constraints);
        

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(new JLabel("Remark: "), constraints);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        add(remark, constraints);

        add(new RegisterButton(this));
    }

	private void buildRemarkField() {
		remark = new JTextField();
        remark.setColumns(25);
	}

	private void buildActionsField() {
		List<ActionModel> models = componentDAO.getActionInfo((String)comps.getSelectedItem());
		if (actionIds == null) {
			actionIds = new JList<ActionModel>(models.toArray(new ActionModel[0]));
			actionIds.setFixedCellWidth(150);
			actionIds.setListData(models.toArray(new ActionModel[0]));
		}
		actionIds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() >= 2) {
					final JDialog dialog = new JDialog(OutRegisterFrame.this, "Out Count", true);
					dialog.setSize(200, 100);
					dialog.setLayout(new GridLayout(0,1));
					Container container = dialog.getContentPane();
					final ActionModel selectedAction = actionIds.getSelectedValue();
					container.add(new JLabel(selectedAction.toString()));
					final JTextField countField = new JTextField();
					container.add(countField);
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							selectedAction.setCount(Integer.parseInt(countField.getText()));
							dialog.setVisible(false);
						}
						
					});
					container.add(okButton);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
			}
		});
	}

	private void buildEidField() {
		eId = new JTextField();
        eId.setColumns(10);
	}

	private void buildPersonField() {
		List<Person> personEtities = personDAO.load();
        List<String> personOptions = new ArrayList<>();
        for(Person person : personEtities) {
            personOptions.add(person.getName());
        }
        persons = new JComboBox<>(personOptions.toArray(new String[0]));
	}

	private void buildCountField() {
		count = new JTextField();
        count.setColumns(10);
	}

	private void buildDateField() {
		date = new JFormattedTextField(new SimpleDateFormat(StringUtil.DATA_FORMAT));
        date.setColumns(10);
	}

	private void buildComponentField() {
		List<Component> components = componentDAO.load();
        List<String> compOptions = new ArrayList<>();
        for(Component component : components) {
        	compOptions.add(component.getId());
        }
        comps = new JComboBox<>(compOptions.toArray(new String[0]));
        comps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buildActionsField();
			}
		});
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
        ListModel<ActionModel> actions = actionIds.getModel();
        Map<String, Integer> actionMap = new HashMap<>();
        for (int i = 0; i < actions.getSize(); i++) {
        	ActionModel model = actions.getElementAt(i);
			actionMap.put(model.getId(), model.getCount());
		}
        out.setActions(actionMap);
        out.setMark(remark.getText());

        componentOutDAO.save(out);
        
        ((CMTableModel) factory.createTable().getModel()).load();
        this.setVisible(false);
        this.validate();
    }

}
