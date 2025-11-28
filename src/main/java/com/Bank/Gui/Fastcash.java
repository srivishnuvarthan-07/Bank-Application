package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Gui.Home;
import com.Bank.Dao.Bankdao;

public class Fastcash {
    JButton b1, b2, b3, b4, b5, b6, back;
    String userAccount, userpin;
    Bankdao bankdao;
    JFrame frame;

    public Fastcash(String accountNo, String pin) {
        this.userAccount = accountNo;
        this.userpin = pin;
        setup();
        addListeners();
    } 
    void setup() {
        frame = new JFrame("Fast Cash");
        frame.setSize(700, 500); // Slightly wider for better spacing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        // --- 1. THEME COLORS ---
        Color bgColor = new Color(44, 62, 80);     // Midnight Blue
        Color txtColor = Color.WHITE;
        
        frame.getContentPane().setBackground(bgColor);

        // --- 2. HEADER LABEL ---
        JLabel title = new JLabel("SELECT WITHDRAWAL AMOUNT");
        title.setBounds(210, 30, 400, 30);
        title.setForeground(txtColor);
        title.setFont(new Font("System", Font.BOLD, 18));
        frame.add(title);

        // --- 3. BUTTONS (With Helper Function for Style) ---
        
        // Row 1
        b1 = new JButton("$100");
        b1.setBounds(60, 100, 200, 45); // Bigger buttons
        styleButton(b1);
        frame.add(b1);

        b2 = new JButton("$500");
        b2.setBounds(400, 100, 200, 45);
        styleButton(b2);
        frame.add(b2);

        // Row 2
        b3 = new JButton("$1000");
        b3.setBounds(60, 170, 200, 45);
        styleButton(b3);
        frame.add(b3);

        b4 = new JButton("$2000");
        b4.setBounds(400, 170, 200, 45);
        styleButton(b4);
        frame.add(b4);

        // Row 3
        b5 = new JButton("$5000");
        b5.setBounds(60, 240, 200, 45);
        styleButton(b5);
        frame.add(b5);

        b6 = new JButton("$10000");
        b6.setBounds(400, 240, 200, 45);
        styleButton(b6);
        frame.add(b6);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(250, 350, 180, 40);
        back.setBackground(Color.RED); // Distinct color for navigation
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 14));
        frame.add(back);

        frame.setVisible(true);
    }
    void styleButton(JButton btn) {
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setFocusable(false);
        // Add listener automatically
    }
    void addListeners() {
        back.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(back);
            frame.dispose();
            Home homePage = new Home(userAccount, userpin);
        });
        b1.addActionListener(e -> handleFastCash(100));
        b2.addActionListener(e -> handleFastCash(500));
        b3.addActionListener(e -> handleFastCash(1000));
        b4.addActionListener(e -> handleFastCash(2000));
        b5.addActionListener(e -> handleFastCash(5000));
        b6.addActionListener(e -> handleFastCash(10000));
    }
    void handleFastCash(int amount) {
       bankdao=new Bankdao();
       try{
            int a=bankdao.withdraw(userAccount, String.valueOf(amount), new java.util.Date());
            if(a>0){
                JOptionPane.showMessageDialog(null, "Amount $" + amount + " Withdrawn Successfully");
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(b1);
                frame.dispose();
                Home homePage = new Home(userAccount, userpin);
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error in Fast Cash Transaction","Error",JOptionPane.ERROR_MESSAGE);
       }
    }
}
