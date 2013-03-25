package xeon.cm.gui.search;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.factory.Factory;
import xeon.cm.util.StringUtil;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:27 PM
 */
public class OutSearchBar extends SearchBar {

	private static final long serialVersionUID = 2550846914402232333L;
	
	private int width = MainFrame.width;
    private int height = 60;

    private static OutSearchBar instance;

    private JTextField componentId;
    private JFormattedTextField date;
    private JTextField countBegin;
    private JTextField countEnd;
    private JTextField eId;
    private JTextField person;

    private OutSearchBar(Factory factory){
    	super(factory);
    }

    public static OutSearchBar getInstance(Factory factory) {
        if (instance == null) instance = new OutSearchBar(factory);
        return instance;
    }

	private JPanel createCritieras2() {
		JPanel critieras2 = new JPanel(getALayout());
        critieras2.setSize(700, critieras2.getHeight());
        critieras2.setBackground(Color.GRAY);

        critieras2.add(new JLabel("EID: "));
        critieras2.add(eId);

        critieras2.add(new JLabel("Person: "));
        critieras2.add(person);
		return critieras2;
	}

	private JPanel createCritieras1() {
		JPanel critieras1 = new JPanel(getALayout());
        critieras1.setSize(700, critieras1.getHeight());
        critieras1.setBackground(Color.GRAY);

        critieras1.add(new JLabel("Comp: "));
        critieras1.add(componentId);

        critieras1.add(new JLabel("Date: "));
        date.setColumns(10);
        date.setFocusLostBehavior(JFormattedTextField.COMMIT);
        critieras1.add(date);

        critieras1.add(new JLabel("Count: "));
        critieras1.add(countBegin);
        critieras1.add(new JLabel("-"));
        critieras1.add(countEnd);
		return critieras1;
	}

    @Override
    public Map<String, String> getSearchCritieras() {
        Map<String, String> critieras = new HashMap<>();
        if(!StringUtil.isEmpty(componentId.getText())) {
            critieras.put("componentId", componentId.getText());
        }
        if(!StringUtil.isEmpty(date.getText())) {
            critieras.put("date", date.getText());
        }
        if(!StringUtil.isEmpty(countBegin.getText())) {
            critieras.put("countBegin", countBegin.getText());
        }
        if(!StringUtil.isEmpty(countEnd.getText())) {
            critieras.put("countEnd", countEnd.getText());
        }
        if(!StringUtil.isEmpty(eId.getText())) {
            critieras.put("eId", eId.getText());
        }
        if(!StringUtil.isEmpty(person.getText())) {
            critieras.put("person", person.getText());
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
	protected JPanel createCritieras() {
		JPanel critierasContainer = new JPanel();
        critierasContainer.setLayout(new BoxLayout(critierasContainer, BoxLayout.Y_AXIS));
        critierasContainer.add(createCritieras1());
        critierasContainer.add(createCritieras2());
		return critierasContainer;
	}

	@Override
	protected JPanel createButtonGroup() {
		JPanel buttons = new JPanel();
        buttons.setBackground(Color.GRAY);
        LayoutManager buttonsLayout = new GridLayout(2, 1, 0, 5);
        buttons.setLayout(buttonsLayout);
        buttons.add(new SearchButton(this, factory.createTable()));
        buttons.add(new RegisterButton(factory));
		return buttons;
	}

	@Override
	protected void initChildren() {
	    componentId = new JTextField(10);
	    date = new JFormattedTextField(new SimpleDateFormat(StringUtil.DATA_FORMAT));
	    countBegin = new JTextField(5);
	    countEnd = new JTextField(5);
	    eId = new JTextField(10);
	    person = new JTextField(5);
	}
}
