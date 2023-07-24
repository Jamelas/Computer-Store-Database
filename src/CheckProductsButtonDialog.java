/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  CheckProductsButtonDialog Class
 *  Displays pop-up when a button in the 'Check Products' tab is pressed
 */

import javax.swing.*;
import java.awt.*;


public class CheckProductsButtonDialog extends JDialog {

    private static String string;

    public CheckProductsButtonDialog() {
        //create and add components to the dialog
        JFrame frame = new JFrame("Message");
        JLabel label = new JLabel(string, SwingConstants.CENTER);
        JButton okButton = new JButton("OK");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 80));

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(new GridLayout(2,0));
        panel.add(label);
        okButton.addActionListener(e-> {
            frame.dispose();
        });

        panel.add(okButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setString(String str) {
        string = str;
    }
}
