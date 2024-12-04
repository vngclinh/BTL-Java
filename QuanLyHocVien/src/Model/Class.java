package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class Class implements Comparable<Class> {

    private static final int MAX_STUDENTS = 20; // Giới hạn số lượng sinh viên 1 lớp học
    private static TreeMap<String, Class> allClasses = new TreeMap<>(); // Lưu trữ tất cả các lớp học
    private String classId;
    private String courseId;
    private String teacherId;
    private TreeSet<Student> studentList;
    private String startDate; // Ngày bắt đầu
    private String endDate;   // Ngày kết thúc

    // Constructor mặc định
    public Class() {
    }

    // Constructor khởi tạo lớp học
    public Class(String courseId, String teacherId, String startDate, String endDate) {
        this.classId = setClassId(courseId);
        this.courseId = courseId.toUpperCase();
        this.teacherId = teacherId.toUpperCase();
        this.studentList = new TreeSet<>();
        this.startDate = setDob(startDate); // Chuẩn hóa ngày bắt đầu
        this.endDate = setDob(endDate);     // Chuẩn hóa ngày kết thúc
        addClass();
        Course course = Course.getAllCourses().get(courseId);
        if (course != null) {
            course.addClass(this); // Thêm lớp vào danh sách lớp của khóa học
        }
        addClassToTeacher(this.teacherId);
    }

    public void addStudentList(Student stu) {
        if (!this.studentList.contains(stu)) {
            this.studentList.add(stu);
        }
    }

    //Lấy tên khóa học
    public String getCourseName(String courseID) {
        if (Course.getAllCourses() != null && Course.getAllCourses().containsKey(courseID)) {
            return Course.getAllCourses().get(courseID).getName();
        }
        return null;
    }

    //Lấy tên giáo viên
    public String getTeacherName(String teacherID) {
        if (Teacher.getAllTeachers() != null && Teacher.getAllTeachers().containsKey(teacherID)) {
            return Teacher.getAllTeachers().get(teacherID).getName();
        }
        return null;
    }

    // Thêm lớp vào danh sách lớp của giáo viên
    public void addClassToTeacher(String teacherID) {
        if (Teacher.getAllTeachers().containsKey(teacherID)) {
            Teacher tcr = Teacher.getAllTeachers().get(teacherID);
            tcr.addTeachingClass(this.classId);
        }
    }

    // Tạo classID dựa trên courseID và số thứ tự của class đấy
    public String setClassId(String courseID) {
        Course course = Course.getAllCourses().get(courseID);
        if (course != null) {
            return course.getId() + "-" + (course.getClasses().size()+1);
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

    // Getter cho ngày bắt đầu lớp học
    public String getStartDate() {
        return startDate;
    }

    // Getter cho ngày kết thúc lớp học
    public String getEndDate() {
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
    public boolean removeExpiredClasses(Class x) {
        Date today = new Date();
        String endDateStr = x.getEndDate();
        try {
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDateStr);
            return end.before(today);
        } catch (ParseException e) {
            return false;
        }
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

    // Chuẩn hóa ngày
    private String setDob(String dob) {
        dob = dob.trim();
        String[] formats = {
            "dd/MM/yyyy", "d/M/yyyy", "dd-MM-yyyy", "d-M-yyyy",
            "yyyy/MM/dd", "yyyy-MM-dd", "MM/dd/yyyy", "M/d/yyyy"
        };
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String format : formats) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(format);
                inputFormat.setLenient(false);
                Date date = inputFormat.parse(dob);
                return outputFormat.format(date);
            } catch (ParseException e) {
                // Ignored
            }
        }
        return dob;
    }
    //Dùng để lưu vào file input
    public String save(){
        return this.courseId +"\n" + this.teacherId + "\n" + this.startDate +"\n"+this.endDate;
    }
    
    //In ra thông tin lớp học
    @Override
    public String toString() {
        String courseName = getCourseName(this.courseId);
        String teacherName = getTeacherName(this.teacherId);

        return "Class ID: " + this.classId +
               "\nCourse Name: " + (courseName != null ? courseName : "0") +
               "\nTeacher Name: " + (teacherName != null ? teacherName : "0") +
               "\nNumber of Students: " + this.studentList.size() +
               "\nStart Date: " + this.startDate +
               "\nEnd Date: " + this.endDate;
    }
}
