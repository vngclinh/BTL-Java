package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Class implements Comparable<Class> {

    private static final int MAX_STUDENTS = 20; // Giới hạn số lượng sinh viên 1 lớp học
    private static TreeMap<String, Class> allClasses = new TreeMap<>(); // Lưu trữ tất cả các lớp học
    private String classId;
    private String courseId;
    private String teacherId;
    private TreeSet<Student> studentList;
    private Date startDate; // Ngày bắt đầu
    private Date endDate;   // Ngày kết thúc
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor mặc định
    public Class() {
    }

    // Constructor khởi tạo lớp học
    public Class(String courseId, String teacherId, String startDate, String endDate) throws ParseException {
        this.classId = setClassId(courseId);
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.studentList = new TreeSet<>();
        this.startDate = dateFormat.parse(startDate); // Định dạng ngày bắt đầu
        this.endDate = dateFormat.parse(endDate);     // Định dạng ngày kết thúc
        addClass();
    }

    //Tạo classID dựa trên courseID và số thứ tự của class đấy
    public String setClassId(String courseID) {
        Course course = Course.getAllCourses().get(courseID);
        if (course != null) {
            return course.getId() + "-" + (course.getClasses().size() + 1);
        }
        throw new IllegalArgumentException("Course ID not found: " + courseID);
    }

    // Getter cho classId
    public String getClassId() {
        return classId;
    }

    // Getter cho courseId
    public String getCourseId() {
        return courseId;
    }

    // Getter cho teacherId
    public String getTeacherId() {
        return teacherId;
    }

    //Getter cho ngày bắt đầu lớp học
    public Date getStartDate() {
        return startDate;
    }

    //Getter cho ngày kết thúc lớp học
    public Date getEndDate() {
        return endDate;
    }

    // Getter cho danh sách sinh viên
    public TreeSet<Student> getStudentList() {
        return studentList;
    }

    // Lấy tất cả các lớp học
    public static TreeMap<String, Class> getAllClasses() {
        return allClasses;
    }

    // Thêm lớp học vào danh sách nếu chưa tồn tại
    public void addClass() {
        if (!allClasses.containsKey(this.classId)) {
            allClasses.put(this.classId, this);
        }
    }

    // Kiểm tra và xóa các lớp đã kết thúc
    public static void removeExpiredClasses() {
        Date today = new Date();
        allClasses.entrySet().removeIf(entry -> entry.getValue().endDate.before(today));
    }

    // Thêm sinh viên vào lớp học
    public void addStudent(Student stu) {
        if (studentList.size() >= MAX_STUDENTS) {
            System.out.println("Class is full. Cannot add student: " + stu.getName());
            return;
        }
        if (!studentList.contains(stu)) {
            studentList.add(stu);
        }
    }

    // Xóa sinh viên khỏi lớp
    public void removeStudent(Student stu) {
        if (studentList.contains(stu)) {
            studentList.remove(stu);
            System.out.println("Removed student: " + stu.getName());
        } else {
            System.out.println("Student not found in this class.");
        }
    }

    // Triển khai Comparable để sắp xếp các lớp theo classId
    @Override
    public int compareTo(Class o) {
        return this.classId.compareTo(o.classId);
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        return "Class ID: " + this.classId
                + "\nTeacher: " + this.teacherId
                + "\nNumber of students: " + this.studentList.size();
    }
}
