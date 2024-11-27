package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private String id;
    private String name;
    private String dob;
    private String phoneNum;

    public Person(String id, String name, String dob, String phoneNum) {
        this.id = id;
        this.name = setName(name);
        this.dob = setDob(dob);
        this.phoneNum = setPhoneNumber(phoneNum);
    }

    //Chuẩn hóa tên
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

    //Chuẩn hóa ngày sinh
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
    //Chuẩn hóa số điện thoại
    private String setPhoneNumber(String phone){
        if (phone.charAt(0)!='0'){
            return "0"+phone;
        }
        return phone;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return "UID: " + id + "\nName: " + name + "\nDob: " + dob + "\nPhone number: " + phoneNum;
    }
}
