/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */
import java.util.*;

public class Student extends Person {
    private Map<String, LopHocPhan> registeredClasses = new HashMap<>(); // Map<classId, LopHocPhan>

    public Student(String uid, String name, String dob) {
        super(uid, name, dob, "STUDENT");
    }

    public void registerClassSection(String courseId, LopHocPhan lopHocPhan) {
        if (!registeredClasses.containsKey(lopHocPhan.getId())) {
            registeredClasses.put(lopHocPhan.getId(), lopHocPhan);
            lopHocPhan.addStudent(this);
            System.out.println("Sinh vien " + this.getId() + " da dang ky lop: " + lopHocPhan.getId());
        } else {
            System.out.println("Ban da dang ky lop nay roi.");
        }
    }

    public Map<String, LopHocPhan> getRegisteredClasses() {
        return registeredClasses;
    }

    public String calculateGPA10(Map<String, MonHoc> courses) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (LopHocPhan lopHocPhan : registeredClasses.values()) {
            String courseId = lopHocPhan.getCourseId();
            MonHoc course = courses.get(courseId);

            if (course != null) {
                Diem diem = lopHocPhan.getStudentGrades().get(this);
                int attendedSessions = diem != null ? (int) diem.getDiemCC() : 0; // Dùng điểm CC làm số buổi chuyên cần

                if (!lopHocPhan.checkAttendance(this, attendedSessions, course)) {
                    System.out.println("Sinh vien " + this.getId() + " da truot vi nghi qua 50% so buoi: " + course.getName());
                    continue;
                }

                int credits = course.getCredits();
                if (diem != null) {
                    double finalScore = diem.tinhDiemTongKet();
                    totalPoints += finalScore * credits;
                    totalCredits += credits;
                }
            }
        }

        double gpa10 = totalCredits > 0 ? totalPoints / totalCredits : 0;
        return String.format("%.2f", gpa10);
    }

    private double convertToScale4(double gpa10) {
        if (gpa10 >= 9.0) return 4.0;
        if (gpa10 >= 8.5) return 3.7;
        if (gpa10 >= 8.0) return 3.5;
        if (gpa10 >= 7.0) return 3.0;
        if (gpa10 >= 6.5) return 2.5;
        if (gpa10 >= 5.5) return 2.0;
        if (gpa10 >= 5.0) return 1.5;
        if (gpa10 >= 4.0) return 1.0;
        return 0.0;
    }

    public String calculateGPA4(Map<String, MonHoc> courses) {
        String gpa10 = calculateGPA10(courses);
        double gpa10Value = Double.parseDouble(gpa10);
        double gpa4 = convertToScale4(gpa10Value);
        return String.format("%.2f", gpa4);
    }

    private String convertToLetterGPA(double gpa10) {
        if (gpa10 >= 9.0) return "A+";
        if (gpa10 >= 8.5) return "A";
        if (gpa10 >= 8.0) return "B+";
        if (gpa10 >= 7.0) return "B";
        if (gpa10 >= 6.5) return "C+";
        if (gpa10 >= 5.5) return "C";
        if (gpa10 >= 5.0) return "D+";
        if (gpa10 >= 4.0) return "D";
        return "F";
    }

    public String calculateGPALetter(Map<String, MonHoc> courses) {
        String gpa10 = calculateGPA10(courses);
        double gpa10Value = Double.parseDouble(gpa10);
        return convertToLetterGPA(gpa10Value);
    }

    @Override
    public String toString() {
        return super.toString() + ", Danh sach lop da dang ky: " + registeredClasses.keySet();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return this.getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}

