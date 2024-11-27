package Model;

import java.util.*;

public class Student extends Person {

    private static int cnt = 0; // Đếm số lượng học viên
    private Map<String, Score> classAttended = new HashMap<>(); // Map<ClassID, Score>
    private static TreeMap<String, Student> allStudents = new TreeMap<>();

    public Student(String name, String dob, String phoneNum) {
        super("ST" + String.format("%03d", ++cnt), name, dob, phoneNum);
        addStudent();
    }

    public void addStudent() {
        if (!allStudents.containsKey(super.getId())) {
            allStudents.put(super.getId(), this);
        }
    }

    public static TreeMap<String, Student> getAllStudents() {
        return allStudents;
    }

    // Thêm các lớp học mà học viên đã tham gia
    public void addAttendedClass(Class attendedClass) {
        if (!classAttended.containsKey(attendedClass.getClassId())) {
            classAttended.put(attendedClass.getClassId(), new Score()); // Chưa có điểm
        }
    }

    public Map<String, Score> getClassAttended() {
        return this.classAttended;
    }

    // Ghi điểm cho học viên
    public void setScore(String classID, int attendance, double homework, double midTerm, double endTerm) {
        if (classAttended.containsKey(classID)) {
            Score grade = new Score(attendance, homework, midTerm, endTerm);
            classAttended.put(classID, grade);
        }
    }

    // Hàm in chi tiết thông tin học viên, khóa học, và điểm số
    public void printStudentResult(Map<String, Class> classMap, Map<String, Course> courseMap) {
        System.out.printf("Student ID: %s, Name: %s\n", this.getId(), this.getName());
        System.out.println("Enrolled Courses:");
        for (Map.Entry<String, Score> entry : classAttended.entrySet()) {
            String classId = entry.getKey();
            Score grade = entry.getValue();
            Class classInfo = classMap.get(classId);
            if (classInfo != null) {
                Course courseInfo = courseMap.get(classInfo.getCourseId());
                if (courseInfo != null) {
                    System.out.printf("- Course: %s (Course ID: %s), Class ID: %s\n", courseInfo.getName(), courseInfo.getId(), classId);
                    System.out.printf("  Score: %s\n", grade != null ? grade : "No grade assigned");
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
