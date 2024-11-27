/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class LopHocPhan {
    private static final int MAX_STUDENTS = 20; // Giới hạn số sinh viên

    private String id;
    private String courseId;
    private String teacherId;
    private HashMap<Student, Diem> studentlist;

    public LopHocPhan(String id, String courseId, String teacherId) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.studentlist = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void addStudent(Student student) {
        if (studentlist.size() >= MAX_STUDENTS) {
            System.out.println("Class is full. Cannot add student: " + student.getUid());
            return;
        }

        if (!studentlist.containsKey(student)) {
            studentlist.put(student, new Diem(0, 0, 0, 0)); // Khởi tạo điểm 0
        }
    }

    public boolean checkAttendance(Student student, int attendedSessions, MonHoc course) {
        double attendanceRate = (double) attendedSessions / course.getTotalSessions();
        if (attendanceRate <= 0.5) {
            System.out.println("Student " + student.getUid() + " failed due to low attendance.");
            return false; // Fail due to attendance
        }
        return true; // Pass attendance check
    }

    public Map<Student, Diem> getStudentGrades() {
        return new HashMap<>(studentlist);
    }
    
    public Diem getStudentGrade(Student student) {
        return studentlist.get(student);
    }
    
    public void updateStudentGrade(Student student, Diem diem) {
        if (studentlist.containsKey(student)) {
            studentlist.put(student, diem);
            System.out.println("Cap nhat diem cho sinh vien: " + student.getUid() + " -> " + diem);
        } else {
            System.out.println("Student not found in this class: " + student.getUid() + ", Class ID: " + this.id);
        }
    }

    public void printStudentList() {
//        System.out.println("Danh sách sinh viên trong lớp " + id + ":");
        for (Student student : studentlist.keySet()) {
            System.out.printf("ID: %s, Name: %s, Birth: %s, email: %s\n", student.getUid(), student.getName(), student.getDob(), student.getEmailAddress());
        }
    }
    
    public void printStudentResult(Student student, Map<String, MonHoc> courses) {
        System.out.printf("ID: %s, Name: %s\n", student.getUid(), student.getName());
        System.out.println("Chi tiet khoa hoc:");

        for (Map.Entry<String, LopHocPhan> entry : student.getRegisteredClasses().entrySet()) {
            String courseId = entry.getKey();
            LopHocPhan classSection = entry.getValue();
            MonHoc monHoc = courses.get(courseId);

            if (monHoc != null) {
                Diem diem = classSection.getStudentGrade(student);
                System.out.printf("- Course: %s (%s), Credits: %d, Grade: %s\n",
                    monHoc.getName(), courseId, monHoc.getCredits(),
                    diem != null ? diem.toString() : "No grade assigned");
            }
        }

        String gpa10 = student.calculateGPA10(courses);
        String gpa4 = student.calculateGPA4(courses);
        System.out.printf("GPA (10-scale): %s, GPA (4-scale): %s\n", gpa10, gpa4);
    }


    
    @Override
    public String toString() {
        return "Class ID: " + id + ", Course ID: " + courseId + ", Teacher ID: " + teacherId;
    }
}





