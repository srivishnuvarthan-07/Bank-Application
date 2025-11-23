package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Gui.Home;
public class Login {
        JFrame frame;
        JButton sumbit,clear;
        JTextField account_no,pin;
        JLabel account_name,pinlabel;
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
            account_name=new JLabel("Account No");
            account_name.setBounds(50,30,100,30);
            frame.add(account_name);
            pinlabel=new JLabel("Pin");
            pinlabel.setBounds(50,70,100,30);
            frame.add(pinlabel);
            account_no=new JTextField();
            account_no.setBounds(150,30,150,30);
            frame.add(account_no);
            pin=new JTextField();
            pin.setBounds(150,70,150,30);
            frame.add(pin);
            sumbit=new JButton("Submit");
            sumbit.setBounds(70,150,100,30);
            frame.add(sumbit);
            clear=new JButton("Clear");
            clear.setBounds(200,150,100,30);
            frame.add(clear);
            frame.setVisible(true);
        }
        void addListeners(){
            clear.addActionListener(e ->{
                account_no.setText("");
                pin.setText("");
            });
            sumbit.addActionListener(e -> {
                frame.dispose();
                String userPin=pin.getText();
                String userAccount=account_no.getText();
                Home homePage=new Home(userAccount,userPin);
            });
        }
}
