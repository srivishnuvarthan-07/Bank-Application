import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class main extends JFrame {
    public static void main(String[] args) {
//        Database database = new Database();
//        try (Connection conn = database.getConnection()) {
//            System.out.println("Connected to the database");
//
//            SwingUtilities.invokeLater(() -> {
//                todogui gui = new todogui();
//                gui.setVisible(true);
//            });
//
//        } catch (SQLException e) {
//            System.out.println("Database.java Connection Failed: " + e.getMessage());
//        }
        JFrame frame = new JFrame("Bank Management System");
        JButton b=new JButton("Add Account");
        JButton b1=new JButton("Update Account");
        frame.add(b);
        frame.add(b1);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
