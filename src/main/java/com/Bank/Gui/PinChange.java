package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;  
import com.Bank.Dao.Bankdao;
import com.Bank.Gui.Login;

public class PinChange {
    String userAccount,userPin;
    JTextField newPinField;
    JLabel newPinLabel;
    JButton changePinButton,back;
    Bankdao bankdao;
    JFrame frame;

    public PinChange(String userAccount, String userPin) {
        this.userAccount = userAccount;
        this.userPin = userPin;
        frame = new JFrame("PIN Change Page");
        setup();
        addListeners();
    }
    void setup() {
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Color bgColor = new Color(44, 62, 80);     // Midnight Blue
        Color txtColor = Color.WHITE;
        
        frame.getContentPane().setBackground(bgColor);


        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setFont(new Font("System", Font.BOLD, 22));
        title.setForeground(txtColor);
        title.setBounds(160, 40, 300, 30);
        frame.add(title);

        newPinLabel = new JLabel("Enter New PIN:");
        newPinLabel.setFont(new Font("System", Font.BOLD, 16)); // Bigger Font
        newPinLabel.setForeground(txtColor);                    // White Text
        newPinLabel.setBounds(80, 120, 150, 30);
        frame.add(newPinLabel);

        newPinField = new JPasswordField(); 
        newPinField.setFont(new Font("Raleway", Font.BOLD, 22)); 
        newPinField.setBounds(240, 120, 200, 30);
        frame.add(newPinField);

        changePinButton = new JButton("CHANGE"); 
        changePinButton.setBounds(240, 180, 200, 35);
        changePinButton.setBackground(Color.WHITE);
        changePinButton.setForeground(Color.BLACK);
        changePinButton.setFont(new Font("System", Font.BOLD, 14));
        changePinButton.setFocusable(false);
        frame.add(changePinButton);

        back = new JButton("BACK");
        back.setBounds(240, 230, 200, 35);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setFocusable(false);
        frame.add(back);
        frame.setVisible(true);
    }
    void addListeners() {
        changePinButton.addActionListener(e -> {
            String newPin = newPinField.getText();
            bankdao = new Bankdao();
            int row;
            try{
                row=bankdao.changePin(userAccount,newPin);
                if(row>0){
                    JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                    Login loginPage=new Login();
                    frame.dispose();
                }
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        });
        back.addActionListener(e -> {
            frame.dispose();
            Home homePage = new Home(userAccount, userPin);
        });
    }
}
