package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
public class Login {
        JFrame jf=new JFrame("Login");
        JTextField jtf=new JTextField("Enter pin");
        JButton jb=new JButton("Login");
        public Login(){
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(1000,1000);
            jf.setLayout(new FlowLayout());
            jf.add(jtf);
            jf.add(jb);
            jf.setVisible(true);
        }
}
