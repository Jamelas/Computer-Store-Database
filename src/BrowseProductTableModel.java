/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  BrowseProductTableModel Class
 *  Used to create the JTable
 */

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BrowseProductTableModel extends AbstractTableModel {
    private static ArrayList<Computer> comp;

    public BrowseProductTableModel(){
        comp = Computer.getComputers();
    }

    //constructor containing the updated arraylist of computers
    public BrowseProductTableModel(ArrayList<Computer> c) {
        comp = c;
    }

    public int getColumnCount() {
        return 6;
    }

    public int getRowCount() {
        return comp.size();
    }

    public Object getValueAt(int row, int col) {
        Computer c = comp.get(row);

        switch (col) {
            case 0:
                return c.getCategory();
            case 1:
                return c.getType();
            case 2:
                return c.getId();
            case 3:
                return c.getBrand();
            case 4:
                return c.getCpu();
            case 5:
                return c.getPrice();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
               return "Category";
            case 1:
                return "Type";
            case 2:
                return "ID";
            case 3:
                return "Brand";
            case 4:
                return "CPU Family";
            case 5:
                return "Price($)";
        }
        return null;
    }
}
