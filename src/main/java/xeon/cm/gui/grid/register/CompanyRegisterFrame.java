package xeon.cm.gui.grid.register;

import xeon.cm.dao.CompanyDAO;
import xeon.cm.gui.factory.Factory;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.Company;

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
public class CompanyRegisterFrame extends JFrame implements Register {

	private static final long serialVersionUID = -5354471350340778635L;

	private static CompanyRegisterFrame instance;
	private Factory factory;

    private JTextField name;

    private CompanyDAO companyDAO = new CompanyDAO();

    private CompanyRegisterFrame(Factory factory) {
        super("Company Register");
        this.factory = factory;
        build();
    }

    public static CompanyRegisterFrame getInstance(Factory factory) {
        if (instance == null) instance = new CompanyRegisterFrame(factory);
        return instance;
    }

    private void build() {
        setSize(400, 300);
        setLayout(new GridBagLayout());
        addComponents();
        setLocationRelativeTo(null);
    }

    @Override
    public void register() {
        companyDAO.save(buildCompany());
        reloadTableData();
        this.setVisible(false);
    }

	private void reloadTableData() {
		((CMTableModel) factory.createTable().getModel()).load();
	}

	private Company buildCompany() {
		Company company = new Company();
        company.setName(name.getText());
		return company;
	}
	
	private void addComponents() {
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
}
