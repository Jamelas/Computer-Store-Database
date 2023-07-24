/*
 *  159.234 Assignment 3 - 20019829, Jamie Douglas
 *  Frame Class
 */

import javax.swing.*;


public class Frame extends JFrame {



    public Frame() {
    }


    public void createFrame(JComponent component) {
        this.setTitle("Computer Products Management System");
        this.add(component);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
