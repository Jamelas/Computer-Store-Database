/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Staff Class
 */

import java.util.ArrayList;

public class Staff {
    protected String username;
    protected String password;
    protected static String loggedIn;
    private static ArrayList<Staff> staff;

    public Staff() {

    }


    //set methods
    protected void setUsername(String username) {
        this.username = username;
    }
    protected void setPassword(String password) {
        this.password = password;
    }
    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }


    //get methods
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getLoggedIn() {
        return loggedIn;
    }
    public static ArrayList<Staff> getStaff() {
        return staff;
    }


    //creates an arraylist of staff usernames and passwords
    public static void loadStaff() {
        staff = new ArrayList<Staff>();
        staff.add(new Salesperson("p1", "p1"));
        staff.add(new Salesperson("p2", "p2"));
        staff.add(new Salesperson("p3", "p3"));
        staff.add(new Manager("m1", "m1"));
        staff.add(new Manager("m2", "m2"));
    }

}
