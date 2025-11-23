package com.Bank;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
// import com.Bank.Gui.BankGui;
import com.Bank.Gui.Home;
import com.Bank.Gui.Login;
import com.Bank.Util.DataBase;
public class Main extends JFrame {
    public static void main(String[] args) {
        DataBase db=new DataBase();
        try(Connection conn=db.getConnection()){
            System.out.println("Database connected");
            new Login();
        }
        catch (Exception e){
            System.out.println("Database not connected");
        }
    }
}
