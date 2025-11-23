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
        frame=new JFrame("Withdraw Page");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        amountLabel=new JLabel("Enter Amount to Withdraw:");
        amountLabel.setBounds(50,50,200,30);
        frame.add(amountLabel);
        amountField=new JTextField();
        amountField.setBounds(200,50,100,30);
        frame.add(amountField);
        withdrawButton=new JButton("Withdraw");
        withdrawButton.setBounds(50,100,100,30);
        frame.add(withdrawButton);
        backButton=new JButton("Back");
        backButton.setBounds(200,100,100,30);
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
