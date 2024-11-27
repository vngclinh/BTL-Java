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
public class Person {
    private String id; 
    private String name;
    private String dob;
    private String emailAddress;
    private Users userAccount; // Thông tin tài khoản

    public Person(String id, String name, String dob, String userRole) {
        this.id = id;
        this.name = setName(name); // Đảm bảo name được khởi tạo trước
        this.dob = setDob(dob);
        this.emailAddress = generateEmail(); // Gọi sau khi name được khởi tạo
        this.userAccount = new Users(id, id, userRole.toUpperCase()); // Tạo tài khoản
    }

    private String generateEmail() {
        StringBuilder sb = new StringBuilder("");
        String[] a = this.name.split("\\s+");
        sb.append(a[a.length - 1]);
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i].charAt(0));
        }
        sb.append(this.id);
        sb.append("@ptit.edu.vn");
        return sb.toString();
    }

    public String getId() {
        return id;
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

    public Users getUserAccount() {
        return userAccount;
    }

    @Override
    public String toString() {
        return "UID: " + id + ", Name: " + name + ", Role: " + userAccount.getRole() + ", Email: " + emailAddress;
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
        String[] formats = {
            "dd/MM/yyyy", "d/M/yyyy", "dd-MM-yyyy", "d-M-yyyy",
            "yyyy/MM/dd", "yyyy-MM-dd", "MM/dd/yyyy", "M/d/yyyy"
        };
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String format : formats) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(format);
                inputFormat.setLenient(false);
                Date date = inputFormat.parse(dob);
                return outputFormat.format(date);
            } catch (ParseException e) {
                // Ignored
            }
        }
        return dob;
    }
}

