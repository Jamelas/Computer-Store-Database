/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  ProductFrame Class
 *  Frame that is created after logging in
 */

import javax.swing.*;
import java.awt.*;


public class ProductFrame extends Frame {

    private static JTabbedPane tabbedPane;


    public ProductFrame() {
        this.setTitle("Computer Products Management System");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        tabbedPane = new JTabbedPane();
        BrowseProductTable table = new BrowseProductTable();

        //create and add the tabs
        tabbedPane.add("Browse Products", new BrowseProductsPanel());
        tabbedPane.add("Check/Update Products Details", new CheckProductsPanel());
        table.setTab(tabbedPane);


        Staff s = new Staff();
        //disables the 'check products' tab is the staff is not a manager
        if (!s.getLoggedIn().startsWith("m")) tabbedPane.setEnabledAt(1, false);
        tabbedPane.addChangeListener(new ProductTabListener(tabbedPane));
        c.gridy = 0;
        c.insets = new Insets(5,5,5,5);
        panel.add(new JScrollPane(tabbedPane), c);


        //adds the login button to the bottom of the frame
        LoginButton button = new LoginButton();
        button.addActionListener(new LoginButtonListener(this, button));
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(button, c);


        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
