/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class UniPersonnel {
    private String uid; // University ID (duy nhất)
    private String name;
    private String dob;
    private String emailAddress;
    private String username;
    private String password;
    private String userRole; // "STUDENT" hoặc "TEACHER"

    public UniPersonnel(String uid, String name, String dob, String userRole) {
        this.uid = uid;
        this.name = setName(name); // Đảm bảo name được khởi tạo trước
        this.dob = setDob(dob);
        this.username = uid;
        this.password = uid;
        this.userRole = userRole.toUpperCase(); // Chuẩn hóa vai trò
        this.emailAddress = generateEmail(); // Gọi sau khi name được khởi tạo
    }

    private String generateEmail() {
        StringBuilder sb = new StringBuilder("");
        String[] a = this.name.split("\\s+");
        sb.append(a[a.length - 1]);
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i].charAt(0));
        }
        sb.append(this.uid);
        sb.append("@ptit.edu.vn");
        return sb.toString();
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "UID: " + uid + ", Name: " + name + ", Role: " + userRole + ", Email: " + emailAddress;
    }

    private String setName(String name) {
        String[] a = name.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for (String x : a) {
            sb.append(Character.toUpperCase(x.charAt(0)));
            sb.append(x.substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String setDob(String dob) {
        dob = dob.trim();
        //Cac dinh dang dau vao
        String[] formats = {
            "dd/MM/yyyy", "d/M/yyyy", "dd-MM-yyyy", "d-M-yyyy",
            "yyyy/MM/dd", "yyyy-MM-dd", "MM/dd/yyyy", "M/d/yyyy"
        };

        // Định dạng đầu ra chuẩn
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Duyệt qua các định dạng đầu vào để tìm định dạng phù hợp
        for (String format : formats) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(format);
                inputFormat.setLenient(false);  // Không cho phép lỗi ngày tháng
                Date date = inputFormat.parse(dob);  // Thử phân tích chuỗi ngày tháng
                return outputFormat.format(date);  // Trả về ngày tháng chuẩn
            } catch (ParseException e) {
                // Nếu gặp lỗi, thử định dạng tiếp theo
            }
        }
        return dob;
    }
}

