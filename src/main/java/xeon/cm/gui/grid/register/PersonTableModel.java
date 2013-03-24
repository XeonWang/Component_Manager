package xeon.cm.gui.grid.register;

import xeon.cm.dao.PersonDAO;
import xeon.cm.gui.grid.CMTableModel;
import xeon.cm.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 10:17 PM
 */
public class PersonTableModel extends CMTableModel {


	private PersonDAO personDAO;
    private List<Person> persons;

    public PersonTableModel() {
        personDAO = new PersonDAO();
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
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getName();
        }
        return "";
    }
    
    @Override
    public void search(Map<String, String> critieras) {
        persons = new ArrayList<Person>();
        Person person;
        if (critieras.get("name") != null) {
            person = personDAO.getByName(critieras.get("name"));
            if (person != null) {
                persons.add(person);
            }
        } else {
            persons = personDAO.load();
        }

    	fireTableDataChanged();
    }
    
    @Override
    public void load() {
        persons = personDAO.load();
    	fireTableDataChanged();
    }
}
