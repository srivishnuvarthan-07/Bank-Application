package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import com.Bank.Dao.Bankdao;

public class Withdraw {
    JFrame frame;
    JButton withdrawButton, backButton;
    JLabel amountLabel;
    JTextField amountField;
    String userAccount,userPin;
    Bankdao bankdao;
    public Withdraw(String userAccount,String userPin){
        this.userAccount=userAccount;
        this.userPin=userPin;
        setup();
        addListeners(userPin);
    }
    void setup(){
        frame = new JFrame("Withdraw Page");
        frame.setSize(550, 400); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Color bgColor = new Color(44, 62, 80);      // Midnight Blue
        Color txtColor = Color.WHITE;

        frame.getContentPane().setBackground(bgColor);

        JLabel title = new JLabel("MAXIMUM WITHDRAWAL IS RS 10,000");
        title.setForeground(txtColor);
        title.setFont(new Font("System", Font.BOLD, 18));
        title.setBounds(110, 40, 400, 25);
        frame.add(title);

        amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(txtColor);
        amountLabel.setFont(new Font("System", Font.BOLD, 16));
        amountLabel.setBounds(100, 120, 150, 30);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22)); 
        amountField.setBounds(230, 120, 200, 30);
        frame.add(amountField);

        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(230, 200, 200, 35);
        withdrawButton.setBackground(Color.WHITE);
        withdrawButton.setForeground(Color.BLACK);
        withdrawButton.setFont(new Font("System", Font.BOLD, 14));
        withdrawButton.setFocusable(false);
        frame.add(withdrawButton);

        backButton = new JButton("BACK");
        backButton.setBounds(230, 250, 200, 35);
        backButton.setBackground(Color.RED); 
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("System", Font.BOLD, 14));
        backButton.setFocusable(false);
        frame.add(backButton);
        frame.setVisible(true);
    }  
    void addListeners(String userPin){
        backButton.addActionListener(e -> {
            frame.dispose();
            Home homePage=new Home(userAccount,userPin);
        });
        withdrawButton.addActionListener(e -> {
            String amountText=amountField.getText();
            Date date = new Date();
            bankdao=new Bankdao();
            try{
                int row=bankdao.withdraw(userAccount,amountText,date);
                if(row>0){
                    JOptionPane.showMessageDialog(frame, "Amount $"+amountText+" Withdrawn Successfully");
                    frame.dispose();
                    Home homePage=new Home(userAccount,userPin);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame, "Error in withdrawing amount","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }    
}
