/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author Administrator
 */
public class GPA {
    private String subject;
    private float atend_point;
    private float theoretical_point;
    private float practice_point;
    private float final_grade;

    public GPA(String subject, float atend_point, float theoretical_point, float practice_point, float final_grade) {
        this.subject = subject;
        this.atend_point = atend_point;
        this.theoretical_point = theoretical_point;
        this.practice_point = practice_point;
        this.final_grade = final_grade;
    }
    
    public void updateScores(float atend_point, float theoretical_point, float practice_point, float final_grade) {
        this.atend_point = atend_point;
        this.theoretical_point = theoretical_point;
        this.practice_point = practice_point;
        this.final_grade = final_grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getAtend_point() {
        return atend_point;
    }

    public void setAtend_point(float atend_point) {
        this.atend_point = atend_point;
    }

    public float getTheoretical_point() {
        return theoretical_point;
    }

    public void setTheoretical_point(float theoretical_point) {
        this.theoretical_point = theoretical_point;
    }

    public float getPractice_point() {
        return practice_point;
    }

    public void setPractice_point(float practice_point) {
        this.practice_point = practice_point;
    }

    public float getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(float final_grade) {
        this.final_grade = final_grade;
    }
    
    public String getDetails() {
        return subject + " " + atend_point + " " + theoretical_point + " " + practice_point + " " + final_grade + " " +averageScore(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float averageScore() {
        return (float)((atend_point*0.1) + (theoretical_point*0.1) + (practice_point*0.1) + (final_grade*0.7));
    }
}
