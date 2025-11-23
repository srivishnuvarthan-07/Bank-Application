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
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel amountLabel = new JLabel("Enter Amount to Deposit:");
        amountLabel.setBounds(50,50,200,30);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(200,50,100,30);
        frame.add(amountField);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50,100,100,30);
        frame.add(depositBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200,100,100,30);
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
