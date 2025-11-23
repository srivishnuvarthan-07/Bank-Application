package com.Bank.Dao;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Bank.Util.DataBase;
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
}