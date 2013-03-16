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
public class InSearchBar extends SearchBar {
	
	private static final long serialVersionUID = -8462639444144619063L;
	
	private int width = MainFrame.width;
    private int height = 40;

    private static InSearchBar instance;

    private JTextField componentId = new JTextField(10);
    private JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));
    private JTextField countBegin = new JTextField(5);
    private JTextField countEnd = new JTextField(5);
    private JTextField company = new JTextField(10);
    private JTextField priceBegin = new JTextField(5);
    private JTextField priceEnd = new JTextField(5);
    private JTextField actionId = new JTextField(10);

    private InSearchBar(Factory factory){
    	super(factory);
        init();
        addChildren();
    }

    public static InSearchBar getInstance(Factory factory) {
        if (instance == null) instance = new InSearchBar(factory);
        return instance;
    }

    private void init() {
        setLayout(new BorderLayout());
        setSize(width, height);
        setBackground(Color.GRAY);
    }

    private void addChildren() {
        FlowLayout critieraLayout = new FlowLayout(FlowLayout.LEADING);
        critieraLayout.setHgap(5);
        JPanel critieras1 = new JPanel(critieraLayout);
        critieras1.setSize(700, critieras1.getHeight());
        critieras1.setBackground(Color.GRAY);

        critieras1.add(new JLabel("Comp: "));
        critieras1.add(componentId);

        critieras1.add(new JLabel("Date: "));
        date.setColumns(10);
        critieras1.add(date);

        critieras1.add(new JLabel("Count: "));
        critieras1.add(countBegin);
        critieras1.add(new JLabel("-"));
        critieras1.add(countEnd);
        
        JPanel critieras2 = new JPanel(critieraLayout);
        critieras2.setSize(700, critieras1.getHeight());
        critieras2.setBackground(Color.GRAY);

        critieras2.add(new JLabel("Price: "));
        critieras2.add(priceBegin);
        critieras2.add(new JLabel("-"));
        critieras2.add(priceEnd);

        critieras2.add(new JLabel("Company: "));
        critieras2.add(company);

        critieras2.add(new JLabel("Action: "));
        critieras2.add(actionId);
        
        JPanel critierasContainer = new JPanel();
        critierasContainer.setLayout(new BoxLayout(critierasContainer, BoxLayout.Y_AXIS));
        critierasContainer.add(critieras1);
        critierasContainer.add(critieras2);

        add(critierasContainer, BorderLayout.LINE_START);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.GRAY);
        LayoutManager buttonsLayout = new GridLayout(2, 1, 0, 5);
        buttons.setLayout(buttonsLayout);
        buttons.add(new SearchButton(this, factory.createTable()));
        buttons.add(new RegisterButton(factory));

        add(buttons, BorderLayout.LINE_END);
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
        if(!StringUtil.isEmpty(priceBegin.getText())) {
            critieras.put("priceBegin", priceBegin.getText());
        }
        if(!StringUtil.isEmpty(priceEnd.getText())) {
            critieras.put("priceEnd", priceEnd.getText());
        }
        if(!StringUtil.isEmpty(company.getText())) {
            critieras.put("company", company.getText());
        }
        if(!StringUtil.isEmpty(actionId.getText())) {
            critieras.put("actionId", actionId.getText());
        }
        return critieras;
    }
}
