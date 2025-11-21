// package com.Bank.Gui;
// import com.Bank.Dao.Bankdao;
// import java.awt.*;
// import javax.swing.*;

// public class BankGui extends JFrame{
//     private JButton button=new JButton("Working");
//     JButton createbutton=new JButton("Create Account");
//     JButton depositbutton=new JButton("Deposit");
//     JButton withdrawbutton=new JButton("Withdraw");
//     JButton transferbutton=new JButton("Transfer");
//     JButton viewbutton=new JButton("View");
//     JButton deletebutton=new JButton("Delete");
//     JFrame frame=new JFrame("Bank Management System");
//     public BankGui(){

//         initialstep();
//         setup();
//         setuplisten();

//     }
//     private void initialstep(){
//         frame.setSize(700,600);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//         frame.setResizable(false);
//         frame.setLocationRelativeTo(null);
//     }
//     private void setup(){
//         JPanel panel = new JPanel(new GridLayout(2, 3, 20, 20));
//         panel.add(createbutton);
//         panel.add(depositbutton);
//         panel.add(withdrawbutton);
//         panel.add(transferbutton);
//         panel.add(viewbutton);
//         panel.add(deletebutton);
//         frame.add(panel,BorderLayout.NORTH);
//     }
//     private void setuplisten(){
//         createbutton.addActionListener(e -> create());
//         depositbutton.addActionListener(e -> deposit());
//         withdrawbutton.addActionListener(e -> withdraw());
//         transferbutton.addActionListener(e -> transfer());
//         viewbutton.addActionListener(e -> view());
//         deletebutton.addActionListener(e -> delete());
//     }
//     void create(){
//         JFrame creat=new JFrame();
//         creat.setTitle("CREATE ACCOUNT");
//         creat.setSize(300,300);
//         creat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         creat.setLocationRelativeTo(null);
//         creat.setResizable(false);
//         creat.setVisible(true);

//     }
//     void deposit(){
//         JFrame deposit=new JFrame();
//         deposit.setTitle("Deposit");
//         deposit.setSize(300,300);
//         deposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         deposit.setLocationRelativeTo(null);
//         deposit.setResizable(false);
//         deposit.setVisible(true);
//     }
//     void withdraw(){
//         JFrame withdraw=new JFrame();
//         withdraw.setTitle("Withdraw");
//         withdraw.setSize(300,300);
//         withdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         withdraw.setLocationRelativeTo(null);
//         withdraw.setResizable(false);
//         withdraw.setVisible(true);
//     }
//     void transfer(){
//         JFrame transfer=new JFrame();
//         transfer.setTitle("Transfer");
//         transfer.setSize(300,300);
//         transfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         transfer.setLocationRelativeTo(null);
//         transfer.setResizable(false);
//         transfer.setVisible(true);
//     }
//     void view(){
//         JFrame view=new JFrame();
//         view.setTitle("VIEW");
//         view.setSize(300,300);
//         view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         view.setLocationRelativeTo(null);
//         view.setResizable(false);
//         view.setVisible(true);
//     }
//     void delete(){
//         JFrame delete=new JFrame();
//         delete.setTitle("DELETE");
//         delete.setSize(300,300);
//         delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         delete.setLocationRelativeTo(null);
//         delete.setResizable(false);
//         delete.setVisible(true);
//     }

// }