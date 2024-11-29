package GUI.Controller;

import GUI.Admin.AdminFrame;
import Model.Users;
import java.awt.event.ActionEvent;

public class CheckLogin {

    private GUI.Admin.AdminFrame adminframe;
    private GUI.Login.Login loginframe;

    public CheckLogin(AdminFrame adminframe, GUI.Login.Login loginframe) {
        this.adminframe = adminframe;
        this.loginframe = loginframe;
        addAction();
    }

    public void show() {
        if (loginframe.jCheckBox1.isSelected()) {
            loginframe.jPasswordField1.setEchoChar((char) 0); // Hiển thị mật khẩu
        } else {
            loginframe.jPasswordField1.setEchoChar('*'); // Ẩn mật khẩu
        }
    }

    public void login() {
        String username = loginframe.jTextField1.getText();
        String password = new String(loginframe.jPasswordField1.getPassword()); // Chuyển char[] thành String
        System.out.println(username);
        System.out.println(password);

        for (Users admin : Model.Users.getUserList()) {
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                loginframe.setVisible(false);
                adminframe.setVisible(true);
                return; // Thoát khỏi vòng lặp khi đăng nhập thành công
            }
        }

        // Nếu không khớp tài khoản nào, thông báo lỗi
        javax.swing.JOptionPane.showMessageDialog(loginframe, "Sai tên tài khoản hoặc mật khẩu!");
    }

    public void addAction() {
        loginframe.jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show();
            }
        });
        loginframe.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
}
