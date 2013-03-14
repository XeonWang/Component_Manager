package xeon.cm.gui.search;

import xeon.cm.gui.MainFrame;
import xeon.cm.gui.grid.InTable;
import xeon.cm.util.StringUtil;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * User: xeon
 * Date: 3/14/13
 * Time: 10:27 PM
 */
public class InSearchBar extends JPanel implements SearchBar {

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

    private InSearchBar(){
        init();
        addChildren();
    }

    public static InSearchBar getInstance() {
        if (instance == null) instance = new InSearchBar();
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

        critieras.add(new JLabel("Comp: "));
        critieras.add(componentId);

        critieras.add(new JLabel("Date: "));
        critieras.add(date);

        critieras.add(new JLabel("Count: "));
        critieras.add(countBegin);
        critieras.add(new JLabel("-"));
        critieras.add(countEnd);

        critieras.add(new JLabel("Price: "));
        critieras.add(priceBegin);
        critieras.add(new JLabel("-"));
        critieras.add(priceEnd);

        critieras.add(new JLabel("Company: "));
        critieras.add(company);

        critieras.add(new JLabel("Action: "));
        critieras.add(actionId);

        add(critieras, BorderLayout.LINE_START);
        add(new SearchButton(this, InTable.getInstance()), BorderLayout.LINE_END);
    }

    @Override
    public Map<String, String> getSearchCritieras() {
        Map<String, String> critieras = new HashMap<String, String>();
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
