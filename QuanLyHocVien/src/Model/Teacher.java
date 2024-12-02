package Model;

import java.util.TreeMap;
import java.util.TreeSet;

public class Teacher extends Person {

    private static int cnt = 0;
    private TreeSet<String> teachingCourses = new TreeSet<>();
    private String email;
    private static TreeMap<String, Teacher> allTeachers = new TreeMap<>();

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

    public void addTeacherToList() {
        if (!allTeachers.containsKey(super.getId())) {
            allTeachers.put(super.getId(), this);
        }
    }

    public void addTeachingClass(String classID) {
        this.teachingCourses.add(classID);
    }

    private String generateEmail() {
        StringBuilder sb = new StringBuilder();
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
    public String save() {
        // Lưu thông tin giáo viên vào file
        return super.getId() + "," + super.getName() + "," + super.getDob() + "," + super.getPhoneNum() + "," + email;
    }

    @Override
    public String toString() {
        String classIds = this.getTeachingCourses().isEmpty() ? "Hien khong co lop"
                : this.getTeachingCourses().toString().replaceAll("[\\[\\]]", "");
        return super.toString()
                + "\nEmail: " + email
                + "\nTeaching Courses: " + classIds;
    }
}
