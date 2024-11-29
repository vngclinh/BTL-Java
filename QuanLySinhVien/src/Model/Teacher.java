package Model;

import java.util.*;

public class Teacher extends Person {

    private static int cnt =0;
    private TreeSet<String> teachingCourses = new TreeSet<>(); // ID các lớp học phần đang dạy
    private String email;
    private static TreeMap<String, Teacher> allTeachers = new TreeMap<>(); // Lưu trữ tất cả các giáo viên

    public Teacher() {

    }

    public Teacher(String name, String dob, String phoneNum) {
        super("TC" + String.format("%03d", ++cnt), name, dob, phoneNum);
        this.email = generateEmail();
        addTeacherToList();
    }

    public static TreeMap<String, Teacher> getAllTeachers() {
        return allTeachers;
    }

    // Thêm giáo viên vào danh sách nếu chưa tồn tại
    public void addTeacherToList() {
        if (!allTeachers.containsKey(super.getId())) {
            allTeachers.put(super.getId(), this);
        }
    }

    public void addTeachingClass(String classID){
        this.teachingCourses.add(classID);
    }
    //Tạo tài khoản email
    private String generateEmail() {
        StringBuilder sb = new StringBuilder("");
        String[] a = super.getName().split("\\s+");
        sb.append(a[a.length - 1]);
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i].charAt(0));
        }
        sb.append(super.getId());
        sb.append("@BaL.edu.vn");
        return sb.toString();
    }

    public void assignCourse(String courseId) {
        teachingCourses.add(courseId);
    }

    public TreeSet<String> getTeachingCourses() {
        return teachingCourses;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nEmail: " + email
                + "\nTeaching Courses: " + String.join(", ", teachingCourses);
    }
}
