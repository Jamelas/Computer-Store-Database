/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  LoginButtonListener Class
 *  Activates when the login button is clicked
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {
    private static Frame frame;
    private static LoginButton button;


    public LoginButtonListener() {

    }

    public LoginButtonListener(Frame frame, LoginButton button) {
        this.frame = frame;
        this.button = button;
    }


    //Activates when the login button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            //user wants to log in
            if (!button.getIsLoggedIn()) {
                LoginButtonDialog l = new LoginButtonDialog(frame);
                l.loginDialog();

            //user wants to log out
            } else if (button.getIsLoggedIn()) {
                frame.dispose();
                Staff staff = new Staff();
                staff.setLoggedIn(null);    //there are no staff logged in
                Frame frame = new Frame();
                LoginButton.loginStatus(false);  //change the button text from 'login' to 'log out'
                LoginButton loginButton = new LoginButton();
                loginButton.addActionListener(new LoginButtonListener(frame, loginButton));
                frame.createFrame(loginButton);
            }
        }

    }
}
