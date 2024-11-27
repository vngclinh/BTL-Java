/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */
public class Score{
    private double diemCC; // Số buổi chuyên cần
    private double diemKT; // Điểm kiểm tra
    private double diemGK; // Điểm giữa khóa
    private double diemCK; // Điểm cuối khóa

    public Score(double diemCC, double diemKT, double diemGK, double diemCK) {
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double tinhDiemTongKet() {
        return diemKT * 0.3 + diemGK * 0.3 + diemCK * 0.4;
    }

    @Override
    public String toString() {
        return "CC=" + diemCC + ", KT=" + diemKT + ", GK=" + diemGK + ", CK=" + diemCK;
    }
}
