package com.brainacad.java.flyer;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton OKButton;

    public static void main(String[] args) {
        System.out.println("Hi!");
        JFrame jframe = new JFrame("GUI");
        jframe.setContentPane(new GUI().panel1);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);

    }


    //Container container = new Container();

}
