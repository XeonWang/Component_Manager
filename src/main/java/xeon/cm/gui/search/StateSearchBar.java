package xeon.cm.gui.search;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.factory.Factory;
import xeon.cm.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:15 PM
 */
public class StateSearchBar extends SearchBar {
	
	private static final long serialVersionUID = 4388181040127724396L;
	
	private int width = MainFrame.width;
	private int height = 40;
	
	private JTextField idField;
	private JTextField typeField;
	private JTextField amountBeginField;
	private JTextField amountEndField;
	
	private static StateSearchBar instance;
	
    private StateSearchBar(Factory factory) {
    	super(factory);
    }
    
    public static StateSearchBar getInstance(Factory factory) {
    	if(instance == null) instance = new StateSearchBar(factory);
    	return instance;
    }

    @Override
    protected JPanel createButtonGroup() {
		JPanel buttonGroup = new JPanel();
        buttonGroup.setBackground(Color.GRAY);
        buttonGroup.add(new SearchButton(this, factory.createTable()));
        buttonGroup.add(new xeon.cm.gui.search.RegisterButton(factory));
		return buttonGroup;
	}

    @Override
    protected JPanel createCritieras() {
		JPanel critieras = new JPanel(getALayout());
    	critieras.setBackground(Color.GRAY);
    	
    	critieras.add(new JLabel("ID: "));
    	critieras.add(idField);
    	
    	critieras.add(new JLabel("Type: "));
    	critieras.add(typeField);
    	
    	critieras.add(new JLabel("Amount: "));
    	critieras.add(amountBeginField);
    	critieras.add(new JLabel("-"));
    	critieras.add(amountEndField);
		return critieras;
	}
    
    @Override
    public Map<String, String> getSearchCritieras() {
    	Map<String, String> critieras = new HashMap<String, String>();
    	if(!StringUtil.isEmpty(idField.getText())) {
    		critieras.put("id", idField.getText());
    	}
    	if(!StringUtil.isEmpty(typeField.getText())) {
    		critieras.put("type", typeField.getText());
    	}
    	if(!StringUtil.isEmpty(amountBeginField.getText())) {
    		critieras.put("amountBegin", amountBeginField.getText());
    	}
    	if(!StringUtil.isEmpty(amountEndField.getText())) {
    		critieras.put("amountEnd", amountEndField.getText());
    	}
    	return critieras;
    }
    
    @Override
	public int getWidth() {
		return width;
	}
    
    @Override
	public int getHeight() {
		return height;
	}

	@Override
	protected void initChildren() {
		idField = new JTextField(10);
		typeField = new JTextField(10);
		amountBeginField = new JTextField(5);
		amountEndField = new JTextField(5);
	}
}

