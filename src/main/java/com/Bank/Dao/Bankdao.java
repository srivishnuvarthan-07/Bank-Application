package com.Bank.Dao;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Bank.Util.DataBase;  
import javax.swing.*;
import java.util.Date;

public class Bankdao {
    String query="INSERT INTO bank_his(account_no, date, type, amount) VALUES (?,?,?,?)";
    public int deposit(String account_no,String amount,Date date) throws SQLException{
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, account_no);
            pstmt.setDate(2, new java.sql.Date(date.getTime()));
            pstmt.setString(3,"deposit");
            pstmt.setString(4, amount);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected;
        }
    }
    public int withdraw(String account_no,String amount,Date date) throws SQLException{
        int balance;
        try{
            balance=getBalance(account_no);
            System.out.println("Current Balance: "+balance);
            System.out.println("Requested Withdraw Amount: "+amount);
            if(balance<(Integer.parseInt(amount))){
                throw new SQLException("Insufficient Balance");
            }
        }
        catch(Exception e){
            throw new SQLException("Error retrieving balance");
        }
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, account_no);
            pstmt.setDate(2, new java.sql.Date(date.getTime()));
            pstmt.setString(3,"withdraw");
            pstmt.setString(4, amount);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected;
        }
    }
    public int getBalance(String account_no) throws SQLException{
        String balanceQuery="SELECT SUM(CASE WHEN type='deposit' THEN amount ELSE -amount END) AS balance FROM bank_his WHERE account_no=?";
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(balanceQuery)) {
            pstmt.setString(1, account_no);
            var rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("balance");
            }
            return 0;
        }
    }
    public int changePin(String account_no,String newpin) throws SQLException{
        String pinQuery="UPDATE bank_acc SET pin=? WHERE account_no=?";
        if(newpin.length()!=4){
            throw new SQLException("PIN must be 4 digits");
        }
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(pinQuery)) {
            pstmt.setString(1, newpin);
            pstmt.setString(2, account_no);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected;
        }catch(Exception e){
            throw new SQLException("Error changing PIN");
        }
    }
    public void getmini(StringBuilder text,String account_no){
        String miniQuery="SELECT date, type, amount FROM bank_his WHERE account_no=? ORDER BY date DESC LIMIT 10";
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(miniQuery)) {
            pstmt.setString(1, account_no);
            var rs = pstmt.executeQuery();
            while(rs.next()){
                String date=rs.getDate("date").toString();
                String type=rs.getString("type");
                String amount=rs.getString("amount");
                text.append(date).append(" - ").append(type).append(" - $").append(amount).append("<br>");
            }
            text.append("</html>");
        }catch(Exception e){
            text.append("Error retrieving mini statement</html>");
        }
    }
    public boolean validateLogin(String account_no,String pin) throws SQLException{
        String loginQuery="SELECT * FROM bank_acc WHERE account_no=? AND pin=?";
        try (Connection conn = DataBase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(loginQuery)) {
            pstmt.setString(1, account_no);
            pstmt.setString(2, pin);
            var rs = pstmt.executeQuery();
            return rs.next();
        }
    }
    public void clearFields(JTextField account_no,JTextField pin){
        account_no.setText("");
        pin.setText("");
    }
    
}