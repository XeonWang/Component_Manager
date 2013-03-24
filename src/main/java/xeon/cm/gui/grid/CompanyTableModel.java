package xeon.cm.gui.grid;

import xeon.cm.dao.CompanyDAO;
import xeon.cm.model.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class CompanyTableModel extends CMTableModel {

	private static final long serialVersionUID = 7308535920494682060L;

	private CompanyDAO companyDAO;
    private List<Company> companies;

    public CompanyTableModel() {
        companyDAO = new CompanyDAO();
    }

	@Override
	public String getColumnName(int column) {
    	switch (column) {
	        case 0:
	            return "Name";
	    }
	    return "";
	}

	@Override
    public int getRowCount() {
        return companies.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Company company = companies.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return company.getName();
        }
        return "";
    }
    
    @Override
    public void search(Map<String, String> critieras) {
        companies = new ArrayList<Company>();
        Company company;
        if (critieras.get("name") != null) {
            company = companyDAO.getByName(critieras.get("name"));
            if (company != null) {
                companies.add(company);
            }
        } else {
            companies = companyDAO.load();
        }

    	fireTableDataChanged();
    }
    
    @Override
    public void load() {
    	companies = companyDAO.load();
    	fireTableDataChanged();
    }
}
