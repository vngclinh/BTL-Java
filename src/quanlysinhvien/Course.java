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

public class Course {
    private String id;
    private String name;
    private int credits;
    private int totalSessions; // Tổng số buổi học
    private List<String> lopHocPhanIds; // Danh sách lớp học phần

    public Course(String id, String name, int credits, int totalSessions) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.totalSessions = totalSessions;
        this.lopHocPhanIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public List<String> getLopHocPhanIds() {
        return lopHocPhanIds;
    }

    public void addLopHocPhan(String lopHocPhanId) {
        if (!lopHocPhanIds.contains(lopHocPhanId)) {
            lopHocPhanIds.add(lopHocPhanId);
        }
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits, " + totalSessions + " sessions)";
    }
}



