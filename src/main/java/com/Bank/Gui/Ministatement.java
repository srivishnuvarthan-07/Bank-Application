package com.Bank.Gui;
import javax.swing.*;
import java.awt.*;
import com.Bank.Dao.Bankdao;

public class Ministatement {
    JButton back;
    String userAccount,userpin;
    Bankdao bankdao;
    JFrame frame;

    public Ministatement(String userAccount,String userpin){
        this.userAccount=userAccount;
        this.userpin=userpin;
        setup();
        addListeners();
    }
    void setup(){
        frame=new JFrame();
        frame.setTitle("Mini Statement");
        frame.setLayout(null);
        frame.setSize(400, 600); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(44, 62, 80)); 

        JPanel receiptPanel = new JPanel();
        receiptPanel.setBackground(Color.WHITE);
        receiptPanel.setBounds(20, 20, 345, 450);
        receiptPanel.setLayout(null);
        frame.add(receiptPanel);

        JLabel bankName = new JLabel("A B C BANK");
        bankName.setBounds(80, 20, 200, 20);
        bankName.setFont(new Font("System", Font.BOLD, 16));
        bankName.setForeground(Color.BLACK);
        receiptPanel.add(bankName);

        JLabel subHeader = new JLabel("Mini Statement");
        subHeader.setBounds(115, 40, 150, 20);
        subHeader.setFont(new Font("System", Font.PLAIN, 12));
        receiptPanel.add(subHeader);

        String displayCard = userAccount;
        if(userAccount.length() > 4) {
             displayCard = userAccount.substring(0, 4) + "XXXXXXXX" + userAccount.substring(userAccount.length()-2);
        }
        
        JLabel card = new JLabel("Card No: " + displayCard);
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("System", Font.BOLD, 12));
        receiptPanel.add(card);
        
        JLabel columns = new JLabel("Date              Type           Amount");
        columns.setBounds(20, 110, 300, 20);
        columns.setFont(new Font("Monospaced", Font.BOLD, 12));
        receiptPanel.add(columns);
        
        JLabel line = new JLabel("---------------------------------------");
        line.setBounds(20, 120, 300, 20);
        receiptPanel.add(line);

        JLabel transactions = new JLabel();
        transactions.setBounds(20, 140, 320, 300);
        transactions.setFont(new Font("Monospaced", Font.PLAIN, 12));
        transactions.setVerticalAlignment(JLabel.TOP);
        receiptPanel.add(transactions);    
        StringBuilder text = new StringBuilder("<html>");
        fetch(text);
        transactions.setText(text.toString());
        back = new JButton("Exit");
        back.setBounds(20, 500, 345, 40);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System", Font.BOLD, 14));
        frame.add(back);
        frame.setVisible(true);
    }
    void fetch(StringBuilder text){
        bankdao=new Bankdao();
        bankdao.getmini(text,userAccount);
    }

    void addListeners(){
        back.addActionListener(e -> {
            frame.dispose();
            Home homePage=new Home(userAccount,userpin);
        });        
    }

}
