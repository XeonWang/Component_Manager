package xeon.cm.gui;

import xeon.cm.util.HibernateUtil;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:05 PM
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -1647333493938517746L;
	
	public static final int width = 800;
    public static final int height = 600;
    private JPanel content = new JPanel(new BorderLayout());

    private void init() {
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContent().setOpaque(true);
    }

    public JPanel getContent() {
        return content;
    }

	private static void createAndShowFrame() {
		MainFrame mainFrame = new MainFrame();
        mainFrame.init();
        mainFrame.setJMenuBar(new CMMenuBar(mainFrame.getContent()));
        mainFrame.setContentPane(mainFrame.getContent());
        mainFrame.setVisible(true);
	}
	
    public static void main(String[] args) {
    	HibernateUtil.init();
        createAndShowFrame();
    }
}
