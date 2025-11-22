package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
public class Login {
        JFrame frame;
        JButton sumbit,clear;
        JTextField password;
        JLabel passwordlabel;
        public Login(){
            setup();
            addListeners();
        }
        void setup(){
            frame=new JFrame("Login Page");
            frame.setSize(400,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            passwordlabel=new JLabel("Password:");
            passwordlabel.setBounds(50,70,100,30);
            frame.add(passwordlabel);
            password=new JTextField();
            password.setBounds(150,70,150,30);
            frame.add(password);
            sumbit=new JButton("Submit");
            sumbit.setBounds(70,150,100,30);
            frame.add(sumbit);
            clear=new JButton("Clear");
            clear.setBounds(200,150,100,30);
            frame.add(clear);
            frame.setVisible(true);
        }
        void addListeners(){
            clear.addActionListener(e -> password.setText(""));
            sumbit.addActionListener(e -> {
                String pass=password.getText();
                if(pass.equals("admin")){
                    frame.dispose();
                    Home home=new Home();
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Incorrect Password","Error",JOptionPane.ERROR_MESSAGE);
                }
            });
        }
}
