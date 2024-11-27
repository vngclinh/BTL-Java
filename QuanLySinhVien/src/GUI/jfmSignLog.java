package GUI;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class jfmSignLog {

    // Lớp tạo viền bo tròn cho nút
    static class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setOpaque(false);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(48, 25, 52)); // màu nền của nút đăng nhập
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Bo tròn 30px
            super.paintComponent(g);
        }

        @Override
        public void paintBorder(Graphics g) {
            g.setColor(new Color(211, 211, 211));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30); // Viền bo tròn màu xám nhạt
        }
    }
    
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
        JFrame frame = new JFrame("Đăng nhập");
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Asus\\Downloads\\462548923_450733668031516_7549142968576693174_n.jpg");

        // Lấy kích thước của panel đăng nhập
        int panelWidth = 300; 
        int panelHeight = 300; 

        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH); // Thay đổi kích thước hình ảnh

        // Tạo ImageIcon mới từ hình ảnh đã thay đổi kích thước
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        JLabel titleLabel = new JLabel("QUẢN LÝ SINH VIÊN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        titleLabel.setBounds(0, 10, panelWidth, 40); 
        frame.add(titleLabel);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(20, 40, panelWidth, panelHeight); 
        frame.add(imageLabel);
        // Panel đăng nhập
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(350, 40, 300, 300);
        loginPanel.setBackground(Color.LIGHT_GRAY);
        Border loginPanelBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        loginPanel.setBorder(loginPanelBorder);
        frame.add(loginPanel);

        // Các thành phần trong panel
        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsername.setBounds(20, 20, 100, 30);
        loginPanel.add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(120, 20, 150, 30);
        // Bỏ viền bo tròn
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Viền xám bình thường
        loginPanel.add(txtUsername);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lblPassword.setBounds(20, 70, 100, 30);
        loginPanel.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 150, 30);
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
        loginPanel.add(txtPassword);

        JLabel lblSelect = new JLabel("Bạn là:");
        lblSelect.setBounds(20, 140, 50, 30);
        loginPanel.add(lblSelect);

        ButtonGroup group = new ButtonGroup();
        JRadioButton rbTeacher = new JRadioButton("Giáo viên");
        rbTeacher.setBounds(100, 140, 80, 30);
        group.add(rbTeacher);
        loginPanel.add(rbTeacher);

        JRadioButton rbStudent = new JRadioButton("Sinh viên");
        rbStudent.setBounds(200, 140, 80, 30);
        group.add(rbStudent);
        loginPanel.add(rbStudent);


        RoundButton btnSign = new RoundButton("Đăng nhập");
        btnSign.setForeground(Color.WHITE);
        btnSign.setFont(new Font("Arial", Font.BOLD, 12));
        btnSign.setBounds(75, 220, 150, 40); // Căn giữa trong loginPanel
        loginPanel.add(btnSign);

        frame.setVisible(true);

        btnSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
    }
}