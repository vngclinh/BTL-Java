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
public class Teacher extends UniPersonnel {
    private List<String> teachingCourses = new ArrayList<>(); // ID các lớp học phần đang dạy

    public Teacher(String uid, String name, String dob) {
        super(uid, name, dob,"TEACHER");
    }

    public void assignCourse(String courseId) {
        teachingCourses.add(courseId);
    }

    public List<String> getTeachingCourses() {
        return teachingCourses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Teaching Courses: " + teachingCourses;
    }
}

