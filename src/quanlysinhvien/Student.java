/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */
import java.text.DecimalFormat;
import java.util.*;

public class Student extends UniPersonnel {
    private Map<String, LopHocPhan> registeredClasses = new HashMap<>();

    public Student(String uid, String name, String dob) {
        super(uid, name, dob,"STUDENT");
    }

    public void registeredClasses(LopHocPhan lopHocPhan) {
        registeredClasses.put(lopHocPhan.getId(), lopHocPhan);
    }

    public Map<String, LopHocPhan> getRegisteredClasses() {
        return registeredClasses;
    }


    public String calculateGPA10(Map<String, MonHoc> courses) {
        double totalPoints = 0;
        int totalCredits = 0;

        System.out.println("Calculating GPA for student: " + this.getUid());
        for (LopHocPhan lopHocPhan : registeredClasses.values()) {
            MonHoc course = courses.get(lopHocPhan.getCourseId());

            if (course != null) {
                int credits = course.getCredits();
                Diem diem = lopHocPhan.getStudentGrades().get(this);

                System.out.println("Class: " + lopHocPhan.getId() + ", Course: " + course.getName() + ", Credits: " + credits + ", Grade: " + diem);

                if (diem != null) {
                    double finalScore = diem.tinhDiemTongKet();
                    totalPoints += finalScore * credits;
                    totalCredits += credits;
                }
            }
        }
        
        DecimalFormat df = new DecimalFormat("0.0");
        double gpa10 = totalCredits > 0 ? totalPoints / totalCredits : 0;
        System.out.println("GPA (10-scale): " + df.format(gpa10));
        return df.format(gpa10);
    }

 
    private double convertToScale4(double gpa10) {
        if (gpa10 >= 9.0) {
            return 4.0; // A+
        } else if (gpa10 >= 8.5) {
            return 3.7; // A
        } else if (gpa10 >= 8.0) {
            return 3.5; // B+
        } else if (gpa10 >= 7.0) {
            return 3.0; // B
        } else if (gpa10 >= 6.5) {
            return 2.5; // C+
        } else if (gpa10 >= 5.5) {
            return 2.0; // C
        } else if (gpa10 >= 5.0) {
            return 1.5; // D+
        } else if (gpa10 >= 4.0) {
            return 1.0; // D
        } else {
            return 0.0; // F
        }
    }
    
    public String calculateGPA4(Map<String, MonHoc> courses) {
        double totalPoints = 0;
        int totalCredits = 0;
        
        System.out.println("Calculating GPA for student: " + this.getUid());
        for (LopHocPhan lopHocPhan : registeredClasses.values()) {
            MonHoc course = courses.get(lopHocPhan.getCourseId());

            if (course != null) {
                int credits = course.getCredits();
                Diem diem = lopHocPhan.getStudentGrades().get(this);
                
                System.out.println("Class: " + lopHocPhan.getId() + ", Course: " + course.getName() + ", Credits: " + credits + ", Grade: " + diem);


                if (diem != null) {
                    double finalScore = diem.tinhDiemTongKet();
                    totalPoints += finalScore * credits;
                    totalCredits += credits;
                }
            }
        }
        
        DecimalFormat df = new DecimalFormat("0.0");
        double gpa10 = totalCredits > 0 ? totalPoints / totalCredits : 0;
        String gpa4 = df.format(convertToScale4(gpa10));
        System.out.println("GPA (4-scale): " + gpa4);
        return gpa4;
    }
    
    private String convertToLetterGPA(double gpa10) {
        if (gpa10 >= 9.0) {
            return  "A+";
        } else if (gpa10 >= 8.5) {
            return "A";
        } else if (gpa10 >= 8.0) {
            return "B+";
        } else if (gpa10 >= 7.0) {
            return "B";
        } else if (gpa10 >= 6.5) {
            return "C+";
        } else if (gpa10 >= 5.5) {
            return "C";
        } else if (gpa10 >= 5.0) {
            return "D+";
        } else if (gpa10 >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }
    
    public String calculateGPALetter(Map<String, MonHoc> courses) {
        double totalPoints = 0;
        int totalCredits = 0;
        
        System.out.println("Calculating GPA for student: " + this.getUid());
        for (LopHocPhan lopHocPhan : registeredClasses.values()) {
            MonHoc course = courses.get(lopHocPhan.getCourseId());

            if (course != null) {
                int credits = course.getCredits();
                Diem diem = lopHocPhan.getStudentGrades().get(this);
                
                System.out.println("Class: " + lopHocPhan.getId() + ", Course: " + course.getName() + ", Credits: " + credits + ", Grade: " + diem);


                if (diem != null) {
                    double finalScore = diem.tinhDiemTongKet();
                    totalPoints += finalScore * credits;
                    totalCredits += credits;
                }
            }
        }
        
        double gpa10 = totalCredits > 0 ? totalPoints / totalCredits : 0;
        String gpa = convertToLetterGPA(gpa10);
        System.out.println("Letter grades: " + gpa);
        return gpa;
    }
    
    public void registerClassSection(MonHoc monHoc, String classId) {
        LopHocPhan selectedClass = null;

        // Find the class by ID
        for (LopHocPhan lopHocPhan : monHoc.getLopHocPhans()) {
            if (lopHocPhan.getId().equals(classId)) {
                selectedClass = lopHocPhan;
                break;
            }
        }

        // If class found
        if (selectedClass != null) {
            if (!registeredClasses.containsKey(selectedClass.getId())) {
                registeredClasses.put(selectedClass.getId(), selectedClass);
                selectedClass.addStudent(this);
                System.out.println("Student " + this.getUid() + " registered for class: " + selectedClass.getId());
            } else {
                System.out.println("You are already registered for this class.");
            }
        } else {
            System.out.println("Class ID not found for the course: " + monHoc.getName());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Enrolled Classes: " + registeredClasses.keySet();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return this.getUid().equals(student.getUid());
    }

    @Override
    public int hashCode() {
        return this.getUid().hashCode();
    }
}

