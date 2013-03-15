package xeon.cm.gui.search;

import java.util.Map;

import javax.swing.JPanel;

import xeon.cm.gui.factory.Factory;

abstract public class SearchBar extends JPanel {
	
	private static final long serialVersionUID = 6830624753144755505L;
	
	protected Factory factory;
	
	protected SearchBar(Factory factory) {
		this.factory = factory;
	}
	
	abstract public Map<String, String> getSearchCritieras();
}
