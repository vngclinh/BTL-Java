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

public class MonHoc {
    private String id;
    private String name;
    private int credits;
    private List<LopHocPhan> lopHocPhans; // Danh sách lớp học phần

    public MonHoc(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.lopHocPhans = new ArrayList<>();
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

    public List<LopHocPhan> getLopHocPhans() {
        return lopHocPhans;
    }

    public void addLopHocPhan(LopHocPhan lopHocPhan) {
        if (!lopHocPhans.contains(lopHocPhan)) {
            lopHocPhans.add(lopHocPhan);
        }
    }

    @Override
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}


