package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Gui.Home;
import com.Bank.Dao.Bankdao;
public class Login {
    JFrame frame;
    JButton sumbit,clear;
    JTextField account_no,pin;
    JLabel account_name,pinlabel;
    Bankdao bankdao;
    public Login(){
        setup();
        addListeners();
    }
    void setup(){
        frame = new JFrame("Automated Teller Machine"); 
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); 

        Color bgColor = new Color(44, 62, 80);      // Midnight Blue
        Color txtColor = Color.WHITE;               // White Text
        Color fieldColor = new Color(255, 255, 255);// White Fields

        frame.getContentPane().setBackground(bgColor);

        JLabel title = new JLabel("WELCOME TO ATM");
        title.setFont(new Font("Osward", Font.BOLD, 28)); 
        title.setForeground(Color.YELLOW);
        title.setBounds(130, 40, 450, 40);
        frame.add(title);

        account_name = new JLabel("Card No:");
        account_name.setFont(new Font("Raleway", Font.BOLD, 20)); 
        account_name.setForeground(txtColor);
        account_name.setBounds(50, 130, 150, 30);
        frame.add(account_name);

        account_no = new JTextField();
        account_no.setBounds(200, 130, 250, 35); 
        account_no.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(account_no);

        pinlabel = new JLabel("PIN:");
        pinlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        pinlabel.setForeground(txtColor);
        pinlabel.setBounds(50, 190, 150, 30);
        frame.add(pinlabel);

        pin = new JPasswordField(); 
        pin.setBounds(200, 190, 250, 35);
        pin.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(pin);

        sumbit = new JButton("SIGN IN"); 
        sumbit.setBackground(Color.WHITE);
        sumbit.setForeground(Color.BLACK);
        sumbit.setFont(new Font("Arial", Font.BOLD, 14));
        sumbit.setBounds(200, 260, 110, 35);
        sumbit.setFocusable(false);
        frame.add(sumbit);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK); 
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(340, 260, 110, 35);
        clear.setFocusable(false);
        frame.add(clear);

        frame.setVisible(true);
    }
    void addListeners(){
        clear.addActionListener(e ->{
            bankdao=new Bankdao();
            bankdao.clearFields(account_no,pin);
        });
        sumbit.addActionListener(e -> {
            String userPin=pin.getText();
            String userAccount=account_no.getText();
            bankdao=new Bankdao();
            try{
                boolean a=bankdao.validateLogin(userAccount,userPin);
                if(a){
                    frame.dispose();
                    Home homePage=new Home(userAccount,userPin);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Incorrect Account Number or PIN","Error",JOptionPane.ERROR_MESSAGE);
                    bankdao.clearFields(account_no,pin);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame, "Error in Login","Error",JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
