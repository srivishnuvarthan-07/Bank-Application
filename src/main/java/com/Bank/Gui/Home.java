package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Gui.Deposit;
import com.Bank.Gui.Withdraw;
import com.Bank.Gui.Balance;
import com.Bank.Gui.Login;
import com.Bank.Gui.PinChange;

public class Home {
    JFrame frame;
    JButton deposit,withdraw,balance,pin_change,logout;
    JLabel welcomeLabel;
    String userAccount,userPin;
    public Home(String userAccount,String userPin){
        this.userAccount=userAccount;
        this.userPin=userPin;
        setup();
        addListeners();
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
        pin_change=new JButton("pint Change");
        pin_change.setBounds(250,160,150,30);
        frame.add(pin_change);
        logout=new JButton("Logout");
        logout.setBounds(170,220,150,30);
        frame.add(logout);
        frame.setVisible(true);
    }  
    void addListeners(){
        logout.addActionListener(e -> {
            frame.dispose();
            Login login=new Login();
        });
        deposit.addActionListener(e -> {
            frame.dispose();
            Deposit depositPage=new Deposit(userAccount,userPin);
        });
        withdraw.addActionListener(e -> {
            frame.dispose();
            Withdraw withdrawPage=new Withdraw(userAccount,userPin);
        });
        balance.addActionListener(e -> {
            frame.dispose();
            Balance balancePage=new Balance(userAccount,userPin);
        });
        pin_change.addActionListener(e -> {
            frame.dispose();
            PinChange pinChangePage=new PinChange(userAccount,userPin);
        });
    }     
}
