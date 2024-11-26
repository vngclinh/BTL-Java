/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlysinhvien;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class QuanLySinhVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tạo môn học
        MonHoc csCourse = new MonHoc("CS101", "Computer Science", 3);
        MonHoc mathCourse = new MonHoc("MA101", "Mathematics", 4);

        // Tạo Map chứa thông tin môn học
        Map<String, MonHoc> courses = new HashMap<>();
        courses.put("CS101", csCourse);
        courses.put("MA101", mathCourse);

        // Tạo lớp học phần
        LopHocPhan csClass1 = new LopHocPhan("CS101-01", csCourse, "T001");
        LopHocPhan mathClass = new LopHocPhan("MA101-01", mathCourse, "T003");

        // Tạo sinh viên
        Student student1 = new Student("S12345", "Nguyen Van An", "01/01/2000");
        Student student2 = new Student("S67890", "Le Thi Binh", "02/02/2000");

        // Đăng ký lớp học phần
        student1.registerClassSection(csCourse, "CS101-01"); // Đăng ký thành công
        student2.registerClassSection(csCourse, "CS101-01"); // Sửa lỗi từ CS101-02 thành CS101-01
        student1.registerClassSection(mathCourse, "MA101-01"); // Đăng ký thành công

        // Gán điểm cho sinh viên trong các lớp học phần
        csClass1.updateStudentGrade(student1, new Diem(8.0, 9.0, 7.5, 8.5));
        csClass1.updateStudentGrade(student2, new Diem(7.0, 7.5, 8.0, 7.8));
        mathClass.updateStudentGrade(student1, new Diem(9.0, 8.5, 9.5, 10.0));

        // In danh sách sinh viên trong từng lớp học phần
        System.out.println("\nDanh sach sinh vien trong lop CS101-01:");
        csClass1.printStudentList();

        System.out.println("\nDanh sach sinh vien trong lop MA101-01:");
        mathClass.printStudentList(); // Truyền courses vào
        
        // Hien thi ket qua hoc tap cua sinh vien
        System.out.println("GPA thang 4 cua sinh vien " + student1.getName());
        student1.calculateGPA4(courses);
        System.out.println("GPA thang 10 cua sinh vien "+ student2.getName());
        student2.calculateGPA10(courses);
    }
}
