/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  BrowseProductTable Class
 *  Loads and applies the Table Model
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class BrowseProductTable extends JFrame {

    private BrowseProductTableModel productModel;
    public static JTabbedPane tab;

    public void setTab(JTabbedPane tab) {
        this.tab = tab;
    }


    public BrowseProductTable() {
        super();
        productModel = new BrowseProductTableModel();
        JTable table = new JTable(productModel);
        add(table.getTableHeader(), BorderLayout.NORTH);
        table.addMouseListener(new MouseAdapter() {
            //activates when a cell on the table is selected
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.rowAtPoint(e.getPoint());
                table.getValueAt(row, 2);
                for (Computer c : Computer.getComputers()) {
                    //finds the selected computer from the Computer Class
                    if (c.getId() == table.getValueAt(row, 2)) {
                        System.out.println(c.getId() + c.getCpu());
                        tab.setSelectedIndex(1);
                        tab.setComponentAt(1, new CheckProductsPanel(c));
                        tab.revalidate();
                        tab.repaint();
                        break;
                    }
                }
            }
        });

        Container container = getContentPane();
        container.add(table);
    }


    //creates a table based on updated information
    public BrowseProductTable(ArrayList<Computer> b) {
        super();
        productModel = new BrowseProductTableModel(b);
        JTable table = new JTable(productModel);
        add(table.getTableHeader(), BorderLayout.NORTH);
        Container container = getContentPane();
        container.add(table);
    }
}
