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
    private String id; // ID lớp học phần
    private String courseId; // ID môn học liên kết
    private String teacherId; // ID giảng viên
    private HashMap<Student, Diem> studentlist; // Danh sách sinh viên và điểm
    private MonHoc monHoc; // Tham chiếu tới môn học

    public LopHocPhan(String id, MonHoc monHoc, String teacherId) {
        this.id = id;
        this.courseId = monHoc.getId();
        this.teacherId = teacherId;
        this.monHoc = monHoc;
        this.studentlist = new HashMap<>();
        monHoc.addLopHocPhan(this); // Liên kết với môn học
    }


    public String getId() {
        return id;
    }
    
    public MonHoc getMonHoc() {
        return this.monHoc;
    }

    public String getCourseId() {
        return courseId;
    }

    public void addStudent(Student student) {
        if (!studentlist.containsKey(student)) {
            studentlist.put(student, new Diem(0, 0, 0, 0));
        }
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
            System.out.println("Updated grade for student: " + student.getUid() + " -> " + diem);
        } else {
            System.out.println("Student not found in this class: " + student.getUid());
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
        System.out.println("Details of courses:");

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
        System.out.printf("GPA (10-scale): %.2f, GPA (4-scale): %.2f\n", gpa10, gpa4);
    }

    
    @Override
    public String toString() {
        return "Class ID: " + id + ", Course ID: " + courseId + ", Teacher ID: " + teacherId;
    }
}



