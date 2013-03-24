package xeon.cm.gui.search;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.factory.Factory;
import xeon.cm.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/12/13
 * Time: 9:15 PM
 */
public class ComponentTypeSearchBar extends SearchBar {


	private int width = MainFrame.width;
	private int height = 40;

	private JTextField name = new JTextField(5);

	private static ComponentTypeSearchBar instance;

    private ComponentTypeSearchBar(Factory factory) {
    	super(factory);
    	init();
    	addChildren();
    }

    public static ComponentTypeSearchBar getInstance(Factory factory) {
    	if(instance == null) instance = new ComponentTypeSearchBar(factory);
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

    	critieras.add(new JLabel("Name: "));
    	critieras.add(name);


    	add(critieras, BorderLayout.LINE_START);

        JPanel buttonGroup = new JPanel();
        buttonGroup.setBackground(Color.GRAY);
        buttonGroup.add(new SearchButton(this, factory.createTable()));
        buttonGroup.add(new RegisterButton(factory));

        add(buttonGroup, BorderLayout.LINE_END);
    }
    
    @Override
    public Map<String, String> getSearchCritieras() {
    	Map<String, String> critieras = new HashMap<String, String>();
    	if(!StringUtil.isEmpty(name.getText())) {
    		critieras.put("name", name.getText());
    	}
    	return critieras;
    }
}
