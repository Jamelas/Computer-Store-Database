/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Main Class
 *  Initializes the program
 */

public class Main {

    public static void main(String[] args) {

        //load the data for the computer class
        Computer.loadComputers();
        Staff.loadStaff();

        //create the login frame
        Frame frame = new Frame();

        //create the login button and add the ActionListener
        LoginButton loginButton = new LoginButton();
        loginButton.addActionListener(new LoginButtonListener(frame, loginButton));

        //add the button to the frame
        frame.createFrame(loginButton);
    }
}
