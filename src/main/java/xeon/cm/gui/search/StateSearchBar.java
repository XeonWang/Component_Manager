package xeon.cm.gui.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.factory.Factory;
import xeon.cm.util.StringUtil;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:15 PM
 */
public class StateSearchBar extends SearchBar {
	
	private static final long serialVersionUID = 4388181040127724396L;
	
	private int width = MainFrame.width;
	private int height = 40;
	
	private JTextField idField = new JTextField(10);
	private JTextField typeField = new JTextField(10);
	private JTextField amountBeginField = new JTextField(5);
	private JTextField amountEndField = new JTextField(5);
	
	private static StateSearchBar instance;
	
    private StateSearchBar(Factory factory) {
    	super(factory);
    	init();
    	addChildren();
    }
    
    public static StateSearchBar getInstance(Factory factory) {
    	if(instance == null) instance = new StateSearchBar(factory);
    	return instance;
    }
    
    private void init() {
        setLayout(new BorderLayout());
        setSize(width, height);
        setBackground(Color.GRAY);
    }
    
    private void addChildren() {
    	FlowLayout critieraLayout = new FlowLayout();
    	critieraLayout.setHgap(15);
		JPanel critieras = new JPanel(critieraLayout);
    	critieras.setBackground(Color.GRAY);
    	
    	critieras.add(new JLabel("ID: "));
    	critieras.add(idField);
    	
    	critieras.add(new JLabel("Type: "));
    	critieras.add(typeField);
    	
    	critieras.add(new JLabel("Amount: "));
    	critieras.add(amountBeginField);
    	critieras.add(new JLabel("-"));
    	critieras.add(amountEndField);
    	
    	add(critieras, BorderLayout.LINE_START);
        add(new SearchButton(this, factory.createTable()), BorderLayout.LINE_END);
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
}
