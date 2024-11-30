package Model;

import java.util.*;

public class Course {

    private static int cnt = 0; // Biến đếm để tạo ID duy nhất cho các khóa học
    private static TreeMap<String, Course> allCourses = new TreeMap<>(); // Lưu trữ tất cả các khóa học của trung tâm
    private String id; // ID khóa học
    private String name; // Tên khóa học
    private int totalSessions; // Tổng số buổi học
    private Set<Class> classes; // Danh sách các lớp thuộc khóa học này

    // Constructor mặc định
    public Course() {
    }

    // Constructor khởi tạo khóa học
    public Course(String id, String name, int totalSessions) {
        this.id = id.toUpperCase();
        this.name = setName(name);
        this.totalSessions = totalSessions;
        this.classes = new TreeSet<>();
        addCourse(); // Tự động thêm vào danh sách khóa học
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

    // Getter cho ID
    public String getId() {
        return id;
    }

    // Getter cho tên
    public String getName() {
        return name;
    }

    // Getter cho tổng số buổi học
    public int getTotalSessions() {
        return totalSessions;
    }

    // Getter cho danh sách các lớp thuộc khóa học
    public Set<Class> getClasses() {
        return classes;
    }

    // Getter cho danh sách tất cả các khóa học
    public static TreeMap<String, Course> getAllCourses() {
        return allCourses;
    }

    // Thêm khóa học vào danh sách allCourses
    private void addCourse() {
        allCourses.put(this.id, this);
    }

    // Thêm lớp vào khóa học
    public void addClass(Class c) {
        classes.add(c);
    }
    //Dùng để lưu vào file
    public String save() {
        return this.id + "\n" + this.name + "\n" + this.totalSessions;
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Class x : this.classes) {
            //Lấy những lớp học còn đăng ký vào được
            if (x.getStudentList().size() < 20 && x.removeExpiredClasses(x)) {
                res.append(x.getClassId()).append(" ");
            }
        }
        return "ID Course: " + this.id
                + "\nCourse name: " + this.name
                + "\nNumber of sessions: " + this.totalSessions
                + "\nAvailable classes: " + res.toString().trim();
    }
}
