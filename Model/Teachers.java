package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Teachers extends Person {

    static Scanner in = new Scanner(System.in);
    private String subjectGV;
    private ArrayList<Students> studentList = new ArrayList<>();

    public Teachers() {

    }

    public Teachers(String idGV, String nameGV, String subjectGV, String dobGV, String emailGV) {
        super(idGV, nameGV, dobGV, emailGV);
        this.subjectGV = subjectGV;

    }

    public String getSubject() {
        return this.subjectGV;
    }

    public void setSubject(String subject) {
        this.subjectGV = subject;
    }

    public ArrayList<Students> getStudents() {
        return this.studentList;
    }

    public void createScore(Students student, float atend_point, float theoretical_point, float practice_point, float final_grade) {
        // Use the student's GPA object to update scores
        GPA gpa = student.getGpa();
        gpa.updateScores(atend_point, theoretical_point, practice_point, final_grade);
    }

    @Override
    public String toString() {
        return super.toString() + " " + formatName(this.subjectGV);
    }
}
