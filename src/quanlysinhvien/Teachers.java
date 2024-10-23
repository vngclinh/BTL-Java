/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Teachers {
    private String idTea;
    private String name;
    private String subject;
    private String email;
    private ArrayList<Students> studentList = new ArrayList<>();

    public Teachers(String id, String name, String subject, String email) {
        this.idTea = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
    }

    public String getId() {
        return idTea;
    }

    public void setId(String id) {
        this.idTea = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Students> getStudents() {
        return studentList;
    }
    
    public void createScore(Students student, float atend_point, float theoretical_point, float practice_point, float final_grade) {
        // Use the student's GPA object to update scores
        GPA gpa = student.getGpa();
        gpa.updateScores(atend_point, theoretical_point, practice_point, final_grade);
    }
    
    @Override
    public String toString() {
        return name + " " + subject + " " + email;
    }
}
