package com.Bank.Gui;

import javax.swing.*;
import java.awt.*;
import com.Bank.Dao.Bankdao;

public class CreateAccount {
    JFrame frame;
    JTextField accountNoField;
    JPasswordField pinField;
    JPasswordField confirmPinField;
    JButton createButton;
    JButton backButton;
    Bankdao bankdao;

    public CreateAccount() {
        setup();
        addListeners();
    }

    void setup() {
        frame = new JFrame("Create New Account");
        frame.setSize(550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Color bgColor = new Color(44, 62, 80);
        Color txtColor = Color.WHITE;

        frame.getContentPane().setBackground(bgColor);

        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setFont(new Font("Osward", Font.BOLD, 28));
        title.setForeground(Color.YELLOW);
        title.setBounds(160, 40, 300, 40);
        frame.add(title);

        JLabel accountLabel = new JLabel("Account No:");
        accountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        accountLabel.setForeground(txtColor);
        accountLabel.setBounds(50, 130, 150, 30);
        frame.add(accountLabel);

        accountNoField = new JTextField();
        accountNoField.setBounds(220, 130, 250, 35);
        accountNoField.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(accountNoField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        pinLabel.setForeground(txtColor);
        pinLabel.setBounds(50, 190, 150, 30);
        frame.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(220, 190, 250, 35);
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(pinField);

        JLabel confirmPinLabel = new JLabel("Confirm PIN:");
        confirmPinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        confirmPinLabel.setForeground(txtColor);
        confirmPinLabel.setBounds(50, 250, 150, 30);
        frame.add(confirmPinLabel);

        confirmPinField = new JPasswordField();
        confirmPinField.setBounds(220, 250, 250, 35);
        confirmPinField.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(confirmPinField);

        createButton = new JButton("CREATE ACCOUNT");
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(Color.BLACK);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBounds(220, 320, 250, 35);
        createButton.setFocusable(false);
        frame.add(createButton);

        backButton = new JButton("BACK TO LOGIN");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(220, 380, 250, 35);
        backButton.setFocusable(false);
        frame.add(backButton);

        frame.setVisible(true);
    }

    void addListeners() {
        createButton.addActionListener(e -> {
            String accountNo = accountNoField.getText().trim();
            String pin = new String(pinField.getPassword()).trim();
            String confirmPin = new String(confirmPinField.getPassword()).trim();

            if (accountNo.isEmpty() || pin.isEmpty() || confirmPin.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!pin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(frame, "PIN and Confirm PIN must match.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (pin.length() != 4) {
                JOptionPane.showMessageDialog(frame, "PIN must be 4 digits.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            bankdao = new Bankdao();
            try {
                int rows = bankdao.createAccount(accountNo, pin);
                if (rows > 0) {
                    JOptionPane.showMessageDialog(frame, "Account created successfully.\nPlease login with your new account.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to create account.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error creating account: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            new Login();
        });
    }
}
