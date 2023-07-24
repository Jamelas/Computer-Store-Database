/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  LoginButton Class
 *  Creates the login/logout button
 */

import javax.swing.*;
import java.awt.*;

public class LoginButton extends JButton{

    public static Boolean loggedIn = false;

    public Boolean getIsLoggedIn() {
        return loggedIn;
    }

    //keeps track if the system is being used
    public static void loginStatus(Boolean status) {
        loggedIn = status;
    }


    public LoginButton() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //add image to the button
        JLabel image = new JLabel(new ImageIcon("../logo.png"));
        c.gridx = 0;
        c.gridy = 0;
        panel.add(image, c);

        //add the appropriate text, dependent on 'login Status'
        JLabel label = new JLabel();
        if (!loggedIn) label.setText("Click to login");
        else label.setText("Click to log out");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,20,0,0);
        label.setFont(new Font("Ariel", Font.BOLD, 20));

        panel.add(label, c);
        panel.setOpaque(false);
        this.add(panel);
    }
}
