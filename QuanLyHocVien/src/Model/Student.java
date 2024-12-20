package Model;

import java.util.*;

public class Student extends Person implements Comparable<Student> {

    private static int cnt = 0;
    // Đếm số lượng học viên
    private Map<String, Score> classAttended;     // Map<ClassID, Score>
    private static TreeMap<String, Student> allStudents = new TreeMap<>();

    public Student() {
        this.classAttended = new TreeMap<>();

    }

    public Student(String name, String dob, String phoneNum) {
        super("ST" + String.format("%03d", ++cnt), name, dob, phoneNum);
        this.classAttended = new TreeMap<>();
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
        if (attendedClass == null) {
            System.out.println("Error: attendedClass is null");
            return;
        }
        if (!classAttended.containsKey(attendedClass.getClassId()) && Class.getAllClasses().containsKey(attendedClass.getClassId())) {
            classAttended.put(attendedClass.getClassId(), new Score());
            attendedClass.addStudentList(this);
        }
    }

    public Map<String, Score> getClassAttended() {
        return this.classAttended;
    }

    // Ghi điểm cho học viên
    public void setScore(String classID, double attendance, double homework, double midTerm, double endTerm) {
        if (classAttended.containsKey(classID)) {
            Score grade = new Score(attendance, homework, midTerm, endTerm);
            classAttended.put(classID, grade);
        }
    }

    // Hàm in chi tiết thông tin học viên, khóa học, và điểm số
    public String printStudentResult() {
        StringBuilder res = new StringBuilder();
        res.append("Student ID: ").append(super.getId()).append("\n");
        res.append("Student Name: ").append(super.getName()).append("\n");

        boolean hasGradedClasses = false;

        for (Map.Entry<String, Score> entry : classAttended.entrySet()) {
            String classId = entry.getKey();
            Score grade = entry.getValue();
            if (!grade.getResult().equals("Not Graded")) {
                res.append("Enrolled Class: ").append(classId).append("\n")
                        .append(grade.toString()).append("\n");
                hasGradedClasses = true;
            }
        }
        res.append("\n");
        return hasGradedClasses ? res.toString() : "";
    }

    @Override
    public String save() {
        String classIds = this.getClassAttended().keySet().isEmpty() ? "Chua cap nhat"
                : this.getClassAttended().keySet().toString().replaceAll("[\\[\\]]", "");
        return "ID: " + super.getId() + 
                "\nName: " + super.getName() + 
                "\nDob: " + super.getDob() + 
                "\nPhone number: " + super.getPhoneNum() + 
                "\nClass: "+classIds;
    }

    @Override
    public int compareTo(Student stu) {
        return this.getId().compareTo(stu.getId());
    }
}
