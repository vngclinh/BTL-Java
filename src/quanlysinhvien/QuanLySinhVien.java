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
        // 1. Tạo các môn học
        Course java = new Course("CS101", "Java Programming", 3, 30);
        Course math = new Course("MATH202", "Calculus II", 4, 45);
        Course physics = new Course("PHYS303", "Physics III", 3, 40);

        // Lưu trữ các môn học vào Map
        Map<String, Course> courses = new HashMap<>();
        courses.put(java.getId(), java);
        courses.put(math.getId(), math);
        courses.put(physics.getId(), physics);

        // 2. Tạo các lớp học phần
        Class javaClass = new Class("CS101-01", "CS101", "T01");
        Class mathClass = new Class("MATH202-01", "MATH202", "T02");

        // 3. Tạo sinh viên
        Student student1 = new Student("S123", "Nguyen Van An", "15/08/2002");
        Student student2 = new Student("S124", "Tran Thi Binh", "20/09/2001");

        // 4. Sinh viên đăng ký lớp học phần
        student1.registerClassSection("CS101", javaClass);
        student1.registerClassSection("MATH202", mathClass);
        student2.registerClassSection("CS101", javaClass);

        // In danh sách sinh viên trong các lớp học phần
        System.out.println("Danh sach sinh vien trong lop Java Programming:");
        javaClass.printStudentList();

        System.out.println("\nDanh sach sinh vien trong lop Calculus II:");
        mathClass.printStudentList();

        // 5. Cập nhật điểm và chuyên cần
        javaClass.updateStudentGrade(student1, new Score(20, 8, 7, 9)); // Điểm chuyên cần (20/30 buổi), TH, GK, CK
        javaClass.updateStudentGrade(student2, new Score(10, 6, 7, 8)); // Điểm chuyên cần (10/30 buổi), TH, GK, CK

        mathClass.updateStudentGrade(student1, new Score(40, 9, 8, 7)); // Điểm chuyên cần (40/45 buổi), TH, GK, CK

        // 6. Kiểm tra kết quả của sinh viên
        System.out.println("\nKet qua hoc tap cua sinh vien Nguyen Van An:");
        javaClass.printStudentResult(student1, courses);

        System.out.println("\nKet qua hoc tap cua sinh vien Tran Thi Binh:");
        javaClass.printStudentResult(student2, courses);

        // 7. Tính GPA và kiểm tra điều kiện chuyên cần
        System.out.println("\nGPA cua Nguyen Van An:");
        System.out.println("Thang 10: " + student1.calculateGPA10(courses));
        System.out.println("Thang 4: " + student1.calculateGPA4(courses));
        System.out.println("Thang chu: " + student1.calculateGPALetter(courses));

        System.out.println("\nGPA cua Tran Thi Binh:");
        System.out.println("Thang 10: " + student2.calculateGPA10(courses));
        System.out.println("Thang 4: " + student2.calculateGPA4(courses));
        System.out.println("Thang chu: " + student2.calculateGPALetter(courses));
    }
}
