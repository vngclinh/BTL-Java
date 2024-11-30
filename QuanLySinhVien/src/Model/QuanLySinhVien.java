package Model;

import java.text.ParseException;
import java.util.*;

public class QuanLySinhVien {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Course> courses = Course.getAllCourses();
        TreeMap<String, Class> classes = Class.getAllClasses();
        TreeMap<String, Student> students = Student.getAllStudents(); 
        TreeMap<String, Teacher> teachers = Teacher.getAllTeachers(); 

        OUTER:
        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add a course");
            System.out.println("2. Add a class");
            System.out.println("3. Add a teacher");
            System.out.println("4. Add a student");
            System.out.println("5. Enroll a student in a class");
            System.out.println("6. Add scores for a student");
            System.out.println("7. Display class list");
            System.out.println("8. Display student results");
            System.out.println("9. Display teacher list");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting the program.");
                    break OUTER;
                }

                case 1 -> {
                    System.out.println("=== Add a Course ===");
                    System.out.print("Enter course ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter total sessions: ");
                    int totalSessions = sc.nextInt();
                    sc.nextLine();
                    new Course(id, name, totalSessions); 
                    System.out.println("Course added successfully.");
                }

                case 2 -> {
                    System.out.println("=== Add a Class ===");
                    System.out.print("Enter course ID: ");
                    String courseId = sc.nextLine();
                    System.out.print("Enter teacher ID: ");
                    String teacherId = sc.nextLine();
                    System.out.print("Enter start date (dd/MM/yyyy): ");
                    String startDate = sc.nextLine();
                    System.out.print("Enter end date (dd/MM/yyyy): ");
                    String endDate = sc.nextLine();
                    if (courses.containsKey(courseId) && teachers.containsKey(teacherId)) {
                        Class c = new Class(courseId, teacherId, startDate, endDate);
                        courses.get(courseId).addClass(c);
                        teachers.get(teacherId).assignCourse(courseId);
                        System.out.println("Class added successfully.");
                    } else {
                        System.out.println("Course or teacher does not exist.");
                    }
                }

                case 3 -> {
                    System.out.println("=== Add a Teacher ===");
                    System.out.print("Enter teacher name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String dob = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    new Teacher(name, dob, phone); 
                    System.out.println("Teacher added successfully.");
                }

                case 4 -> {
                    System.out.println("=== Add a Student ===");
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String dob = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    new Student(name, dob, phone); 
                    System.out.println("Student added successfully.");
                }

                case 5 -> {
                    System.out.println("=== Enroll a Student in a Class ===");
                    System.out.print("Enter class ID: ");
                    String classId = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();
                    Class c = classes.get(classId);
                    Student s = students.get(studentId);
                    if (c != null && s != null) {
                        c.addStudent(s);
                        s.addAttendedClass(c);
                        System.out.println("Enrollment successful.");
                    } else {
                        System.out.println("Class or student does not exist.");
                    }
                }

                case 6 -> {
                    System.out.println("=== Add Scores for a Student ===");
                    System.out.print("Enter class ID: ");
                    String classId = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();
                    System.out.print("Enter attendance score: ");
                    int attendance = sc.nextInt();
                    System.out.print("Enter homework score: ");
                    double homework = sc.nextDouble();
                    System.out.print("Enter midterm score: ");
                    double midTerm = sc.nextDouble();
                    System.out.print("Enter final score: ");
                    double endTerm = sc.nextDouble();
                    sc.nextLine();

                    Student s = students.get(studentId);
                    if (s != null && s.getClassAttended().containsKey(classId)) {
                        s.setScore(classId, attendance, homework, midTerm, endTerm);
                        System.out.println("Scores added successfully.");
                    } else {
                        System.out.println("Student or class does not exist.");
                    }
                }

                case 7 -> {
                    System.out.println("=== Class List ===");
                    classes.values().forEach(System.out::println);
                }

                case 8 -> {
                    System.out.println("=== Student Results ===");
                    students.values().forEach(s -> s.printStudentResult());
                }

                case 9 -> {
                    System.out.println("=== Teacher List ===");
                    teachers.values().forEach(System.out::println);
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
