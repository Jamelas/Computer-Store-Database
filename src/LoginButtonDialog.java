/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  LoginButtonDialog Class
 *  Opens a window to allow the user to log in
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginButtonDialog extends JDialog implements ActionListener {

    private static JFrame frame;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton cancelButton;
    private static Frame externalFrame;


    public LoginButtonDialog() {

    }

    public LoginButtonDialog(Frame externalFrame) {
        this.externalFrame = externalFrame;
    }


    public void loginDialog() {
        //create and add components to the dialog
        frame = new Frame();
        userLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        userText = new JTextField(20);
        passwordText = new JPasswordField(20);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        JPanel panel = new JPanel();
        frame = new JFrame("Sales Person Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        panel.setLayout(new GridLayout(0, 2));
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        loginButton.addActionListener(new LoginButtonDialog());
        panel.add(loginButton);
        cancelButton.addActionListener(new LoginButtonDialog());
        panel.add(cancelButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //activates when the 'login' or 'cancel' buttons are selected
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = String.valueOf(passwordText.getPassword());

        //if the 'login' button is selected
        if (e.getSource().equals(loginButton)) {
            for(Staff s : Staff.getStaff()) {
                //check for valid username/password combination
                if(user.equals(s.getUsername()) && password.equals(s.getPassword())) {
                    frame.dispose();    //the dialog window is closed
                    s.setLoggedIn(user);    //staff username is recorded
                    LoginButton.loginStatus(true);    //a user is logged in, the button text can change to 'log out'
                    externalFrame.dispose();   //the initial login window is closed
                    new ProductFrame();   //a new window is opened
                    break;
                }
            }
        //the 'cancel' button is selected
        } else if (e.getSource().equals(cancelButton)) {
           frame.dispose(); //close the window
        }
    }
}
