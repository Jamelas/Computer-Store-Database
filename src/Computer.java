/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Computer Class
 *  Contains various getter and setter methods,
 *   as well as ability to load the initial data from the text file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Computer {

    protected String category;  //Desktop, Laptop, Tablet
    protected String type;      //Gaming, Home & Study, Business, etc.
    protected String id;
    protected String brand;
    protected String cpu;
    protected String price;
    protected String memory;     //Desktop, Laptop
    protected String ssd;        //Desktop, Laptop
    protected String screenSize; //Laptop, Tablet

    //arraylist to access and store computers currently available
    private static ArrayList<Computer> computers;


    public Computer() {

    }


    //set methods
    protected void setCategory(String category) {
        this.category = category;
    }
    protected void setType(String type) {
        this.type = type;
    }
    protected void setId(String id) {
        this.id = id;
    }
    protected void setBrand(String brand) {
        this.brand = brand;
    }
    protected void setCpu(String cpu) {
        this.cpu = cpu;
    }
    protected void setPrice(String price) {
        this.price = price;
    }
    protected void setMemory(String memory) {
        this.memory = memory;
    }
    protected void setSsd(String ssd) {
        this.ssd = ssd;
    }
    protected void setScreenSize(String screenSize) {
        this.screenSize = screenSize + ".0";
    }


    //get methods
    public String getCategory() {
        return category;
    }
    public String getType() {
        return type;
    }
    public String getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getCpu() {
        return cpu;
    }
    public String getPrice() {
        return price;
    }
    public String getMemory() {
        return memory;
    }
    public String getSsd() {
        return ssd;
    }
    public String getScreenSize() {
        return screenSize;
    }
    public static ArrayList<Computer> getComputers() {
        return computers;
    }



    //*** Methods for the buttons from the 'Check/Update Product Details' tab ***//
    //add button
    public static void addComputer(Computer computer) {
        for (Computer c : computers) {
            if (c.getId().equals(computer.getId())) {
                System.out.println("ERROR: This model number is already in the system");
                return;
            }
        }
        computers.add(computer);
    }
    //update button
    public static void updateComputer(Computer computer) {
        for (Computer c : computers) {
            if (c.getId().equals(computer.getId())) {
                computers.remove(c);
                computers.add(computer);
                return;
            }
        }
        System.out.println("ERROR: ID not found in system");
    }
    //delete button
    public static void deleteComputer(String id) {
        for (Computer c : computers) {
            if (c.getId().equals(id)) {
                computers.remove(c);
                return;
            }
        }
        System.out.println("ERROR: ID not found in system");
    }
    //**********************************************************//


    //load data from 'computers.txt'
    public static ArrayList<Computer> loadComputers() {
        computers  = new ArrayList<Computer>();
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("computers.txt"));

            try {
                String line = "";
                while ((line = inputStream.readLine()) != null) {

                    //create objects based on computer type
                    switch (line.charAt(0)) {
                        case 'D':
                            computers.add(new Desktop(line));
                            break;
                        case 'L':
                            computers.add(new Laptop(line));
                            break;
                        case 'T':
                            computers.add(new Tablet(line));
                            break;
                        default:
                            System.out.println("Error in file");
                            System.exit(1);
                    }
                }
            } finally {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return computers;
    }
}
