package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Gui.Deposit;
import com.Bank.Gui.Withdraw;
import com.Bank.Gui.Balance;
import com.Bank.Gui.Login;
import com.Bank.Gui.PinChange;
import com.Bank.Gui.Fastcash;
import com.Bank.Gui.Ministatement;

public class Home {
    JFrame frame;
    JLabel welcomeLabel;
    JButton deposit, withdraw, fast_cash, mini_statement, balance, pin_change, logout;
    String userAccount,userPin;
    public Home(String userAccount,String userPin){
        this.userAccount=userAccount;
        this.userPin=userPin;
        setup();
        addListeners();
    }
    void setup(){
        frame = new JFrame("Bank Dashboard");
        frame.setSize(600, 500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); 

        Color bgColor = new Color(44, 62, 80);      // Dark Blue Background
        Color btnColor = new Color(255, 255, 255); // White for buttons
        Color txtColor = new Color(236, 240, 241);  // Light Grey for text
        Font mainFont = new Font("SansSerif", Font.BOLD, 14);

        frame.getContentPane().setBackground(bgColor);
        welcomeLabel = new JLabel("Welcome to Your Bank");
        welcomeLabel.setForeground(Color.YELLOW);
        welcomeLabel.setFont(new Font("Osward", Font.BOLD, 26));
        welcomeLabel.setBounds(150, 40, 400, 40);
        frame.add(welcomeLabel);

        deposit = new JButton("Deposit");
        deposit.setBounds(60, 130, 200, 40); 
        styleButton(deposit);
        frame.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(320, 130, 200, 40);
        styleButton(withdraw);
        frame.add(withdraw);

        fast_cash = new JButton("Fast Cash");
        fast_cash.setBounds(60, 200, 200, 40);
        styleButton(fast_cash);
        frame.add(fast_cash);

        mini_statement = new JButton("Mini Statement");
        mini_statement.setBounds(320, 200, 200, 40);
        styleButton(mini_statement);
        frame.add(mini_statement);

        balance = new JButton("Check Balance");
        balance.setBounds(60, 270, 200, 40);
        styleButton(balance);
        frame.add(balance);

        pin_change = new JButton("Change PIN");
        pin_change.setBounds(320, 270, 200, 40);
        styleButton(pin_change);
        frame.add(pin_change);

        logout = new JButton("LOGOUT");
        logout.setBounds(200, 360, 180, 40);
        logout.setBackground(Color.RED); 
        logout.setForeground(Color.WHITE);
        logout.setFont(mainFont);
        frame.add(logout);

        frame.setVisible(true);
    }  
    void styleButton(JButton btn) {
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setFocusable(false); 
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
        fast_cash.addActionListener(e -> {
            frame.dispose();
            Fastcash fastCashPage=new Fastcash(userAccount,userPin);
        });
        mini_statement.addActionListener(e -> {
            frame.dispose();
            Ministatement miniStatementPage=new Ministatement(userAccount,userPin);
        });

    }     
}
