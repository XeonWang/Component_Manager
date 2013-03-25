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
public class ComponentTypeSearchBar extends SearchBar {

	private static final long serialVersionUID = 3141004904402822231L;
	
	private int width = MainFrame.width;
	private int height = 40;

	private JTextField name;

	private static ComponentTypeSearchBar instance;

    private ComponentTypeSearchBar(Factory factory) {
    	super(factory);
    }

    public static ComponentTypeSearchBar getInstance(Factory factory) {
    	if(instance == null) instance = new ComponentTypeSearchBar(factory);
    	return instance;
    }

    @Override
	protected JPanel createButtonGroup() {
		JPanel buttonGroup = new JPanel();
        buttonGroup.setBackground(Color.GRAY);
        buttonGroup.add(new SearchButton(this, factory.createTable()));
        buttonGroup.add(new RegisterButton(factory));
		return buttonGroup;
	}

    @Override
	protected JPanel createCritieras() {
		JPanel critieras = new JPanel(getALayout());
    	critieras.setBackground(Color.GRAY);

    	critieras.add(new JLabel("Name: "));
    	critieras.add(name);
		return critieras;
	}
    
    @Override
    public Map<String, String> getSearchCritieras() {
    	Map<String, String> critieras = new HashMap<String, String>();
    	if(!StringUtil.isEmpty(name.getText())) {
    		critieras.put("name", name.getText());
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
		name = new JTextField(5);		
	}
}
