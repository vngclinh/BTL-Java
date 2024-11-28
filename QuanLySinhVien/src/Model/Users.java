package Model;

import java.util.ArrayList;

public class Users {
    private String username;
    private String password;

    // Static list để lưu users
    private static ArrayList<Users> userList = new ArrayList<>();

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        // Tự động thêm user mới vào list
        userList.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    // lấy list users
    public static ArrayList<Users> getUserList() {
        return userList;
    }

    // cập nhật mật khẩu bằng username
    public static boolean updatePassword(String username, String newPassword) {
        for (Users user : userList) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                return true; // Password đã cập nhật thành công
            }
        }
        return false; // Không tìm thấy user
    }

    // in ra tất cả users
    public static void printUsers() {
        for (Users user : userList) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }   
}