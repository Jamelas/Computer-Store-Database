/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  CheckProducts panel Class
 *  Creates the panel used when the 'Check Products' tab is displayed
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import static javax.swing.SwingConstants.RIGHT;


public class CheckProductsPanel extends JPanel implements ActionListener {

    private JLabel modelLabel = new JLabel("Model ID:", RIGHT);
    private JTextField modelText = new JTextField();
    private JLabel categoryLabel = new JLabel("Category:", RIGHT);
    private static JComboBox<String> categoryCombo = new JComboBox<>();
    private JLabel typeLabel = new JLabel("Type:", RIGHT);
    private static JComboBox<String> typeCombo = new JComboBox<>();
    private JLabel brandLabel = new JLabel("Brand:", RIGHT);
    private JTextField brandText = new JTextField();
    private JLabel cpuLabel = new JLabel("CPU Family:", RIGHT);
    private JTextField cpuText = new JTextField();
    private JLabel memoryLabel = new JLabel("Memory Size:", RIGHT);
    private JTextField memoryText = new JTextField();
    private JLabel ssdLabel = new JLabel("SSD Capacity:", RIGHT);
    private JTextField ssdText = new JTextField();
    private JLabel screenLabel = new JLabel("Screen Size:", RIGHT);
    private JTextField screenText = new JTextField();
    private JLabel priceLabel = new JLabel("Price:", RIGHT);
    private JTextField priceText = new JTextField();
    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton clearButton = new JButton("Clear");
    private CheckProductsButtonDialog dialog;

    private static Hashtable<String, String[]> hash = new Hashtable<>();


    public CheckProductsPanel() {
        createLayout();
    }


    //constructor used to auto-populate the the textfields/comboboxes
    public CheckProductsPanel(Computer computer) {
        createLayout();
        modelText.setText(computer.getId());
        categoryCombo.setSelectedItem(computer.getCategory());
        typeCombo.setSelectedItem(computer.getType());
        brandText.setText(computer.getBrand());
        cpuText.setText(computer.getCpu());
        memoryText.setText(computer.getMemory());
        ssdText.setText(computer.getSsd());
        screenText.setText(computer.getScreenSize());
        priceText.setText(computer.getPrice());
    }


    public void createLayout() {
        this.setLayout(new GridLayout(0, 2, 6, 0));

        this.add(modelLabel);
        this.add(modelText = new JTextField());

        this.add(categoryLabel);
        String[] items = {"Desktop PC", "Laptop", "Tablet"};
        categoryCombo = new JComboBox<String>(items);
        categoryCombo.addActionListener(this);
        categoryCombo.addActionListener(this);
        this.add(categoryCombo);

        this.add(typeLabel);
        String[] hash1 = {"Gaming", "Home & Study", "Business", "Compact"};
        hash.put(items[0], hash1);
        String[] hash2 = {"Business", "Home & Study", "Thin & Light", "Gaming"};
        hash.put(items[1], hash2);
        String[] hash3 = {"Android", "Apple", "Windows"};
        hash.put(items[2], hash3);
        String[] str = {"Gaming", "Home & Study", "Business", "Compact"};
        typeCombo = new JComboBox<String>(str);
        this.add(typeCombo);

        this.add(brandLabel);
        this.add(brandText);

        this.add(cpuLabel);
        this.add(cpuText);

        this.add(memoryLabel);
        this.add(memoryText);

        this.add(ssdLabel);
        this.add(ssdText);

        this.add(screenLabel);
        this.add(screenText);

        this.add(priceLabel);
        this.add(priceText);


        addButton.addActionListener(this);
        this.add(addButton);
        updateButton.addActionListener(this);
        this.add(updateButton);
        deleteButton.addActionListener(this);
        this.add(deleteButton);
        clearButton.addActionListener(this);
        this.add(clearButton);

        //if the staff is not a manager, they are unable to make any changes
        Staff staff = new Staff();
        if (!staff.getLoggedIn().startsWith("m")) {
            modelText.setEnabled(false);
            categoryCombo.setEnabled(false);
            typeCombo.setEnabled(false);
            brandText.setEnabled(false);
            cpuText.setEnabled(false);
            memoryText.setEnabled(false);
            ssdText.setEnabled(false);
            screenText.setEnabled(false);
            priceText.setEnabled(false);
            addButton.setEnabled(false);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            clearButton.setEnabled(false);
        }
    }


    //activates when a button or combobox is selected
    @Override
    public void actionPerformed(ActionEvent e) {
        //populates the 'Type' combobox with the appropriate options
        if (e.getSource() == categoryCombo) {
            String str = (String) categoryCombo.getSelectedItem();
            Object o = hash.get(str);
            typeCombo.setModel(new DefaultComboBoxModel<String>((String[]) o));
        }

        //the 'Add' button is selected
        if (e.getSource() == addButton) {
            if (modelText.getText().isEmpty()) return;
            Computer c = new Computer();
            c.setId(modelText.getText());
            c.setCategory(String.valueOf(categoryCombo.getSelectedItem()));
            c.setType(String.valueOf(typeCombo.getSelectedItem()));
            c.setBrand(brandText.getText());
            c.setCpu(cpuText.getText());
            c.setMemory(memoryText.getText());
            c.setSsd(ssdText.getText());
            c.setScreenSize(brandText.getText());
            c.setPrice(priceText.getText());
            Computer.addComputer(c);
            CheckProductsButtonDialog.setString("The record for the computer is added successfully");
            new CheckProductsButtonDialog();
        }

        //the 'Update' button is selected
        if (e.getSource() == updateButton) {
            if (modelText.getText().isEmpty()) return;
            Computer c = new Computer();
            c.setId(modelText.getText());
            c.setCategory(String.valueOf(categoryCombo.getSelectedItem()));
            c.setType(String.valueOf(typeCombo.getSelectedItem()));
            c.setBrand(brandText.getText());
            c.setCpu(cpuText.getText());
            c.setMemory(memoryText.getText());
            c.setSsd(ssdText.getText());
            c.setScreenSize(brandText.getText());
            c.setPrice(priceText.getText());
            Computer.updateComputer(c);
            CheckProductsButtonDialog.setString("The record for the computer is updated successfully");
            new CheckProductsButtonDialog();
        }

        //the 'Delete' button is selected
        if (e.getSource() == deleteButton) {
            if (modelText.getText().isEmpty()) return;
            Computer.deleteComputer(modelText.getText());
            CheckProductsButtonDialog.setString("The record for the computer is deleted successfully");
            new CheckProductsButtonDialog();
        }

        //the 'Clear' button is selected
        if (e.getSource() == clearButton) {
            modelText.setText("");
            categoryCombo.setSelectedIndex(0);
            typeCombo.setSelectedIndex(0);
            brandText.setText("");
            cpuText.setText("");
            memoryText.setText("");
            ssdText.setText("");
            screenText.setText("");
            priceText.setText("");
        }
    }
}
