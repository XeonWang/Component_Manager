package xeon.cm.gui;

import javax.swing.*;
import java.awt.*;

/**
 * User: xeon
 * Date: 3/10/13
 * Time: 4:05 PM
 */
public class MainFrame extends JFrame {

    private int width = 800;
    private int height = 600;

    private void init() {
        this.setSize(new Dimension(this.width, this.height));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.init();

        JMenuBar menuBar = new CMMenuBar();
        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);
    }
}
