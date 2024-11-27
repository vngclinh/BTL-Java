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
public class Class{
    private static final int MAX_STUDENTS = 20; // Giới hạn số sinh viên

    private String id;
    private String courseId;
    private String teacherId;
    private HashMap<Student, Score> studentlist;

    public Class(String id, String courseId, String teacherId) {
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
            System.out.println("Class is full. Cannot add student: " + student.getId());
            return;
        }

        if (!studentlist.containsKey(student)) {
            studentlist.put(student, new Score(0, 0, 0, 0)); // Khởi tạo điểm 0
        }
    }

    public boolean checkAttendance(Student student, int attendedSessions, Course course) {
        double attendanceRate = (double) attendedSessions / course.getTotalSessions();
        if (attendanceRate <= 0.5) {
            System.out.println("Student " + student.getId() + " failed due to low attendance.");
            return false; // Fail vì đi học không quá nửa số buổi
        }
        return true; // Điểm chuyên cần đủ điều kiện
    }

    public Map<Student, Score> getStudentGrades() {
        return new HashMap<>(studentlist);
    }
    
    public Score getStudentGrade(Student student) {
        return studentlist.get(student);
    }
    
    public void updateStudentGrade(Student student, Score diem) {
        if (studentlist.containsKey(student)) {
            studentlist.put(student, diem);
            System.out.println("Cap nhat diem cho sinh vien: " + student.getId() + " -> " + diem);
        } else {
            System.out.println("Khong tim thay sinh vien: " + student.getId() + "trong lop hoc nay: " + this.id);
        }
    }

    public void printStudentList() {
//        System.out.println("Danh sách sinh viên trong lớp " + id + ":");
        for (Student student : studentlist.keySet()) {
            System.out.printf("ID: %s, Name: %s, Birth: %s, email: %s\n", student.getId(), student.getName(), student.getDob(), student.getEmailAddress());
        }
    }
    
    public void printStudentResult(Student student, Map<String, Course> courses) {
        System.out.printf("ID: %s, Name: %s\n", student.getId(), student.getName());
        System.out.println("Chi tiet khoa hoc:");

        for (Map.Entry<String, Class> entry : student.getRegisteredClasses().entrySet()) {
            String courseId = entry.getKey();
            Class classSection = entry.getValue();
            Course monHoc = courses.get(courseId);

            if (monHoc != null) {
                Score diem = classSection.getStudentGrade(student);
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





