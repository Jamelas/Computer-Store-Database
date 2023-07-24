/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Browse ProductsPanel Class
 *      Used to create the JPanel that is displayed when the
 *      'Browse Products' tab is selected
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;


public class BrowseProductsPanel extends JPanel implements ActionListener{

    private static JComboBox<String> categoryCombo;
    private static JComboBox<String> typeCombo;
    private static Hashtable<String, String[]> hash = new Hashtable<>();
    private  BrowseProductTable table;
    private GridBagConstraints c;


    public BrowseProductsPanel() {
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        //Creates the labels, comboboxes, and initialises the table
        JLabel categoryLabel = new JLabel("Computer Category");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        this.add(categoryLabel, c);

        String[] items = {"All", "Desktop PC", "Laptop", "Tablet"};
        categoryCombo = new JComboBox<String>(items);
        categoryCombo.addActionListener(this);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 137;
        this.add(categoryCombo, c);

        JLabel typeLabel = new JLabel("Computer Type");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        this.add(typeLabel, c);

        typeCombo = new JComboBox<String>();
        String[] hash1 = {"Select Desktop PC", "Gaming", "Home & Study", "Business", "Compact"};
        hash.put(items[1], hash1);
        String[] hash2 = {"Select Laptop", "Business", "Home & Study", "Thin & Light", "Gaming"};
        hash.put(items[2], hash2);
        String[] hash3 = {"Select Tablet", "Android", "Apple", "Windows"};
        hash.put(items[3], hash3);
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = 200;
        c.gridx = 1;
        c.gridy = 1;
        typeCombo.addActionListener(this);
        this.add(typeCombo, c);

        table = new BrowseProductTable();
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(8,5,15,5);
        this.add(table.getContentPane(), c);
    }


    //Action listener is initialised when items in the comboboxes are selected
    @Override
    public void actionPerformed(ActionEvent e) {
        //reset the table
        table = new BrowseProductTable();
        this.add(table.getContentPane(), c);
        this.revalidate();
        this.repaint();
        ArrayList<Computer> b = new ArrayList<Computer>();


        //if 'Computer Category' combobox is selected
        if (e.getSource() == categoryCombo) {
            String str = (String) categoryCombo.getSelectedItem();
            Object o = hash.get(str);


            //if Computer category shows all
            if (o == null) {
                typeCombo.setModel(new DefaultComboBoxModel<String>());
                this.add(table.getContentPane(), c);
                this.revalidate();
                this.repaint();

            //Show options for computer type based on the 'Computer Category' selected
            //computers that match the selected category are added to a new arraylist
            } else {
                typeCombo.setModel(new DefaultComboBoxModel<String>((String[]) o));

                switch (typeCombo.getItemAt(typeCombo.getSelectedIndex())) {

                    case "Select Desktop PC":
                        for (Computer a : Computer.getComputers()) {
                            if (a.getCategory().equals("Desktop PC")) b.add(a);
                        }
                        break;

                    case "Select Laptop":
                        for (Computer a : Computer.getComputers()) {
                            if (a.getCategory().equals("Laptop")) b.add(a);
                        }
                        break;

                    case "Select Tablet":
                        for (Computer a : Computer.getComputers()) {
                            if (a.getCategory().equals("Tablet")) b.add(a);
                        }
                        break;
                    default:
                        for (Computer a : Computer.getComputers()) {
                            if (typeCombo.getItemAt(typeCombo.getSelectedIndex()).equals(a.getType()) && categoryCombo.getItemAt(categoryCombo.getSelectedIndex()).equals(a.getCategory())) {
                                b.add(a);
                            }
                        }
                }
                //repopulate the table with new arraylist
                table = new BrowseProductTable(b);
                this.add(table.getContentPane(), c);
                this.revalidate();
                this.repaint();
            }
        }


        //'Computer Type' combobox is selected
        if (e.getSource() == typeCombo) {
            //computers that match the selected type are added to a new arraylist
            switch (typeCombo.getItemAt(typeCombo.getSelectedIndex())) {

                case "Select Desktop PC":
                    for (Computer a : Computer.getComputers()) {
                        if (a.getCategory().equals("Desktop PC")) b.add(a);
                    }
                    break;

                case "Select Laptop":
                    for (Computer a : Computer.getComputers()) {
                        if (a.getCategory().equals("Laptop")) b.add(a);
                    }
                    break;

                case "Select Tablet":
                    for (Computer a : Computer.getComputers()) {
                        if (a.getCategory().equals("Tablet")) b.add(a);
                    }
                    break;

                default:
                    for (Computer a : Computer.getComputers()) {
                        if (typeCombo.getItemAt(typeCombo.getSelectedIndex()).equals(a.getType()) && categoryCombo.getItemAt(categoryCombo.getSelectedIndex()).equals(a.getCategory())) {
                            b.add(a);
                        }
                    }
            }
            //repopulate the table with the new arraylist
            table = new BrowseProductTable(b);
            this.add(table.getContentPane(), c);
            this.revalidate();
            this.repaint();
        }
    }
}






