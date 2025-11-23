package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Dao.Bankdao;
public class Balance{
    JFrame frame;
    JLabel balanceLabel;
    JButton backButton;
    String userAccount,userpin;
    Bankdao bankdao;
    int balance;
    public Balance(String userAccount,String userpin){
        this.userAccount=userAccount;
        this.userpin=userpin;
        setup();
        addListeners();
    }
    void setup(){
        bankdao=new Bankdao();
        frame=new JFrame("Balance Page");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        try{
        balance=bankdao.getBalance(userAccount);
        balanceLabel=new JLabel();
        balanceLabel.setText("Your Balance is: " + balance);
        }catch(Exception e){
            balanceLabel=new JLabel("Error retrieving balance Retry later");
        }
        balanceLabel.setBounds(130,80,200,30);
        frame.add(balanceLabel);
        backButton=new JButton("Back");
        backButton.setBounds(150,150,100,30);
        frame.add(backButton);
        frame.setVisible(true);
    }  
    void addListeners(){
        backButton.addActionListener(e -> {
            frame.dispose();
            Home homePage=new Home(userAccount,userpin);
        });        
    }    
}
