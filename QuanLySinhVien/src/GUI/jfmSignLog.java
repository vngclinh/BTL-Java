package GUI;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class jfmSignLog {

    private static void checkLogin(String un, String pw, int role) throws SQLException {
        var server = "LAPTOP-BT14K5NE\\SQLEXPRESS";
        var user = "sa";
        var password = "123";
        var db = "QuanLySinhVien";
        var port = 1500;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setEncrypt(false);
        try (Connection conn = ds.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";

            // Sử dụng PreparedStatement để tránh SQL Injection
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, un);  // Gán giá trị username
            pstmt.setString(2, pw);  // Gán giá trị password
            pstmt.setInt(3, role);   // Gán giá trị role

            ResultSet rs = pstmt.executeQuery();  // Thực hiện truy vấn

            // Kiểm tra xem có kết quả trả về hay không
            if (rs.next()) {
                // Nếu có dòng kết quả, tức là đăng nhập thành công
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Nếu không có dòng nào, tức là thông tin không khớp
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại! Kiểm tra lại thông tin.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLServerException ex) {
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign in");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsername.setBounds(45, 40, 100, 30);
        frame.add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(190, 40, 150, 30);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        frame.add(txtUsername);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lblPassword.setBounds(45, 90, 100, 30);
        frame.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(190, 90, 150, 30);
        //txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        frame.add(txtPassword);

        JLabel lblSelect = new JLabel("Bạn là: ");
        lblSelect.setBounds(45, 140, 50, 30);
        frame.add(lblSelect);

        ButtonGroup group = new ButtonGroup();
        JRadioButton rbTeacher = new JRadioButton("Giáo viên");
        rbTeacher.setBounds(130, 140, 80, 30);
        group.add(rbTeacher);
        frame.add(rbTeacher);
        JRadioButton rbStudent = new JRadioButton("Sinh viên");
        rbStudent.setBounds(260, 140, 80, 30);
        group.add(rbStudent);
        frame.add(rbStudent);

        JButton btnSign = new JButton("Đăng nhập");
        btnSign.setBounds(45, 190, 300, 30);
        btnSign.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(btnSign);
        
        frame.setVisible(true);

        btnSign.addActionListener((ActionEvent e) -> {
            String username = txtUsername.getText();
            char[] password = txtPassword.getPassword();
            int selectedRole = rbTeacher.isSelected() ? 1 : (rbStudent.isSelected() ? 0 : -1);
            if (username.isEmpty() || password.length == 0 || selectedRole == -1) {
                JOptionPane.showMessageDialog(frame, "Thông tin không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    checkLogin(username, new String(password), selectedRole);
                } catch (SQLException ex) {
                    Logger.getLogger(jfmSignLog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
