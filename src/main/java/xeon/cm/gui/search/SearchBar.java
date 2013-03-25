package xeon.cm.gui.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;

abstract public class SearchBar extends JPanel {
	
	private static final long serialVersionUID = 6830624753144755505L;
	
	protected Factory factory;
	
	protected SearchBar(Factory factory) {
		this.factory = factory;
    	init();
    	addChildren();
	}
	
	abstract public Map<String, String> getSearchCritieras();
	
	abstract protected JPanel createCritieras();
	
	abstract protected JPanel createButtonGroup();
	
	abstract protected void initChildren();
	
    protected void init() {
        setLayout(new BorderLayout());
        setSize(getWidth(), getHeight());
        setBackground(Color.GRAY);
    }
	
	protected void addChildren() {
		initChildren();
    	add(createCritieras(), BorderLayout.LINE_START);
        add(createButtonGroup(), BorderLayout.LINE_END);
	}
	
	protected FlowLayout getALayout() {
		FlowLayout critieraLayout = new FlowLayout();
    	critieraLayout.setHgap(15);
		return critieraLayout;
	}
}
