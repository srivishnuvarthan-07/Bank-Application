package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;  
import com.Bank.Dao.Bankdao;
import com.Bank.Gui.Login;

public class PinChange {
    String userAccount,userPin;
    JTextField newPinField;
    JLabel newPinLabel;
    JButton changePinButton;
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
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        newPinLabel = new JLabel("Enter New PIN:");
        newPinLabel.setBounds(50, 50, 200, 30);
        frame.add(newPinLabel);

        newPinField = new JTextField();
        newPinField.setBounds(200, 50, 100, 30);
        frame.add(newPinField);

        changePinButton = new JButton("Change PIN");
        changePinButton.setBounds(150, 100, 100, 30);
        frame.add(changePinButton);

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
    }
}
