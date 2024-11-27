/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */
public class Diem {
    private double diemCC; // Số buổi chuyên cần
    private double diemTH;
    private double diemGK;
    private double diemCK;

    public Diem(double diemCC, double diemTH, double diemGK, double diemCK) {
        this.diemCC = diemCC;
        this.diemTH = diemTH;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double tinhDiemTongKet() {
        return diemCC * 0.1 + diemTH * 0.2 + diemGK * 0.3 + diemCK * 0.4;
    }

    @Override
    public String toString() {
        return "CC=" + diemCC + ", TH=" + diemTH + ", GK=" + diemGK + ", CK=" + diemCK;
    }
}
