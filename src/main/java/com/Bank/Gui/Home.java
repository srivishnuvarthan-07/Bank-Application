package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;

public class Home {
    JFrame frame;
    JButton deposit,withdraw,balance,transfer,logout;
    JLabel welcomeLabel;
    public Home(){
        setup();
    }
    void setup(){
        frame=new JFrame("Home Page");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        welcomeLabel=new JLabel("Welcome to Bank");
        welcomeLabel.setBounds(180,30,200,30);
        frame.add(welcomeLabel);
        deposit=new JButton("Deposit");
        deposit.setBounds(50,100,150,30);
        frame.add(deposit);
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(250,100,150,30);
        frame.add(withdraw);
        balance=new JButton("Balance");
        balance.setBounds(50,160,150,30);
        frame.add(balance);
        transfer=new JButton("Transfer");
        transfer.setBounds(250,160,150,30);
        frame.add(transfer);
        logout=new JButton("Logout");
        logout.setBounds(170,220,150,30);
        frame.add(logout);
        frame.setVisible(true);
    }    
}
