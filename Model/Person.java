package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private String id;
    private String name;

    public Person() {
    }

    public Person(String id, String name, String dob, String email) {
        this.id = id;
        this.setName(name);
        this.dob = dob;
        this.email = email;
    }
    private String dob;
    private String email;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = formatName(name);
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String formatName(String n) {
        String[] a = n.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for (String x : a) {
            sb.append(Character.toUpperCase(x.charAt(0)));
            sb.append(x.substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String formatDate(String n) {
        n = n.trim();
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
                Date date = inputFormat.parse(n);  // Thử phân tích chuỗi ngày tháng
                return outputFormat.format(date);  // Trả về ngày tháng chuẩn
            } catch (ParseException e) {
                // Nếu gặp lỗi, thử định dạng tiếp theo
            }
        }
        return n;
    }

    public String generateEmail() {
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

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + formatDate(this.dob) + " " + generateEmail();
    }

}
