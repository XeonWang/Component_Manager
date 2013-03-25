package xeon.cm.gui.search;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.factory.Factory;
import xeon.cm.util.StringUtil;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
    private int height = 40;

    private static OutSearchBar instance;

    private JTextField componentId = new JTextField(10);
    private JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat(StringUtil.DATA_FORMAT));
    private JTextField countBegin = new JTextField(5);
    private JTextField countEnd = new JTextField(5);
    private JTextField eId = new JTextField(10);
    private JTextField person = new JTextField(5);

    private OutSearchBar(Factory factory){
    	super(factory);
        init();
        addChildren();
    }

    public static OutSearchBar getInstance(Factory factory) {
        if (instance == null) instance = new OutSearchBar(factory);
        return instance;
    }

    private void init() {
        setLayout(new BorderLayout());
        setSize(width, height);
        setBackground(Color.GRAY);
    }

    private void addChildren() {
        
        add(createCritieraContainer(createCritieras1(), createCritieras2()), 
        		BorderLayout.LINE_START);

        add(createButtons(), BorderLayout.LINE_END);
    }

	private JPanel createButtons() {
		JPanel buttons = new JPanel();
        buttons.setBackground(Color.GRAY);
        LayoutManager buttonsLayout = new GridLayout(2, 1, 0, 5);
        buttons.setLayout(buttonsLayout);
        buttons.add(new SearchButton(this, factory.createTable()));
        buttons.add(new RegisterButton(factory));
		return buttons;
	}

	private JPanel createCritieraContainer(JPanel critieras1, JPanel critieras2) {
		JPanel critierasContainer = new JPanel();
        critierasContainer.setLayout(new BoxLayout(critierasContainer, BoxLayout.Y_AXIS));
        critierasContainer.add(critieras1);
        critierasContainer.add(critieras2);
		return critierasContainer;
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

	private FlowLayout getALayout() {
		FlowLayout critieraLayout = new FlowLayout(FlowLayout.LEADING);
        critieraLayout.setHgap(5);
		return critieraLayout;
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
}
