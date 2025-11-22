package com.Bank.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit{
    
    JTextField amountField;
    JButton depositBtn, backBtn;
    String pin;
    JFrame frame;

    Deposit(String pin){
        this.pin = pin;
        frame=new JFrame("Deposit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setLayout(null);
        
        JLabel text = new JLabel("ENTER AMOUNT TO DEPOSIT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 30, 400, 20);
        frame.add(text);

        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(170, 65, 320, 25);
        frame.add(amountField);

        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(355, 485, 150, 30);
        frame.add(depositBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(355, 520, 150, 30);
        frame.add(backBtn);

        frame.setSize(900, 900);
        frame.setLocation(300, 0);
        frame.setVisible(true);
    }
}
