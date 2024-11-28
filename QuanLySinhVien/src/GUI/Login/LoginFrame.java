package GUI.Login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {

    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("Đăng nhập");
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);

        // Hiển thị JFrame trước khi thêm hình nền
        loginFrame.setVisible(true);

        // Tạo JLabel chứa hình ảnh
        ImageIcon backgroundIcon = new ImageIcon(LoginFrame.class.getResource("/GUI/icon/background.png"));
        if (backgroundIcon == null) {
            System.out.println("Hình ảnh không tìm thấy!");
            return;
        }

        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(loginFrame.getWidth(), loginFrame.getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
        backgroundLabel.setBounds(0, 0, loginFrame.getWidth(), loginFrame.getHeight());

        // Thêm background vào JFrame
        loginFrame.add(backgroundLabel);
        loginFrame.repaint();
    }
}
