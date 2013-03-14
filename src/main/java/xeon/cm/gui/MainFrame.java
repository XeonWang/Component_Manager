package xeon.cm.gui;

import javax.swing.*;

import xeon.cm.util.HibernateUtil;

import java.awt.*;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:05 PM
 */
public class MainFrame extends JFrame {

    public static final int width = 800;
    public static final int height = 600;
    private JPanel content = new JPanel(new BorderLayout());

    private void init() {
        setSize(new Dimension(width, height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContent().setOpaque(true);
    }

    public JPanel getContent() {
        return content;
    }

    public static void main(String[] args) {
    	HibernateUtil.init();
        MainFrame mainFrame = new MainFrame();
        mainFrame.init();

        JMenuBar menuBar = new CMMenuBar(mainFrame.getContent());
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setContentPane(mainFrame.getContent());
//        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
