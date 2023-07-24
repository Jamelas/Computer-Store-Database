/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  ProductTabListener Class
 *  Activates when a tab is selected
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ProductTabListener implements ChangeListener {

    private JTabbedPane tabs;

    public ProductTabListener() {

    }

    public ProductTabListener(JTabbedPane tabs) {
        this.tabs = tabs;
    }


    //When a tab is selected, the appropriate tabs opened
    @Override
    public void stateChanged(ChangeEvent e) {
        //'Browse Products' tab selected
        if (tabs.getSelectedIndex() == 0) {
            tabs.setComponentAt(0, new BrowseProductsPanel());
        }

        //'Check/Update Products' tab selected
        if (tabs.getSelectedIndex() == 1) {
            tabs.setComponentAt(1, new CheckProductsPanel());
        }
    }
}
