package com.Bank.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import com.Bank.Dao.Bankdao;

public class Deposit{
    
    JTextField amountField;
    JButton depositBtn, backBtn;
    String account_no,pin_no;
    JFrame frame;
    Bankdao bankdao;

    Deposit(String account_no,String pin_no){
        this.account_no=account_no;
        this.pin_no=pin_no;
        initialsteps();
        addListeners();
    }

    void initialsteps(){
        bankdao = new Bankdao();
        frame = new JFrame("Deposit Page");
        frame.setSize(550, 400); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Color bgColor = new Color(44, 62, 80);      // Midnight Blue
        Color txtColor = Color.WHITE;

        frame.getContentPane().setBackground(bgColor);

        JLabel title = new JLabel("DEPOSIT MONEY");
        title.setForeground(txtColor);
        title.setFont(new Font("System", Font.BOLD, 22));
        title.setBounds(170, 40, 300, 30);
        frame.add(title);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setForeground(txtColor);
        amountLabel.setFont(new Font("System", Font.BOLD, 16));
        amountLabel.setBounds(90, 120, 150, 30);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22)); // Large font for numbers
        amountField.setBounds(230, 120, 200, 30);
        frame.add(amountField);

        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(230, 200, 200, 35);
        depositBtn.setBackground(Color.WHITE);
        depositBtn.setForeground(Color.BLACK);
        depositBtn.setFont(new Font("System", Font.BOLD, 14));
        depositBtn.setFocusable(false);
        frame.add(depositBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(230, 250, 200, 35);
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("System", Font.BOLD, 14));
        backBtn.setFocusable(false);
        frame.add(backBtn);

        frame.setVisible(true);
    }

    void addListeners(){
        depositBtn.addActionListener(e->{
            String amountText=amountField.getText();
            Date date = new Date();
            try{
                int row=bankdao.deposit(account_no,amountText,date);
                if(row>0){
                    JOptionPane.showMessageDialog(frame, "Amount Deposited Successfully");
                    frame.dispose();
                    Home homePage=new Home(account_no,pin_no);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame, "Error in depositing amount","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        backBtn.addActionListener(e->{
            frame.dispose();
            Home homePage=new Home(account_no,pin_no);
        });

    }
}
