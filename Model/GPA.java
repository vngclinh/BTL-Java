package Model;

public class GPA {

    private String subject;
    private float atend_point;
    private float theoretical_point;
    private float practice_point;
    private float final_grade;

    public GPA() {
    }

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
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getAtend_point() {
        return this.atend_point;
    }

    public void setAtend_point(float atend_point) {
        this.atend_point = atend_point;
    }

    public float getTheoretical_point() {
        return this.theoretical_point;
    }

    public void setTheoretical_point(float theoretical_point) {
        this.theoretical_point = theoretical_point;
    }

    public float getPractice_point() {
        return this.practice_point;
    }

    public void setPractice_point(float practice_point) {
        this.practice_point = practice_point;
    }

    public float getFinal_grade() {
        return this.final_grade;
    }

    public void setFinal_grade(float final_grade) {
        this.final_grade = final_grade;
    }

    public String getDetails() {
        return this.subject + " " + this.atend_point + " " + this.theoretical_point + " " + this.practice_point + " " + this.final_grade + " " + String.format("%.02f", averageScore());
    }

    public float averageScore() {
        return (this.atend_point * 0.1f) + (this.theoretical_point * 0.1f) + (this.practice_point * 0.1f) + (this.final_grade * 0.7f);
    }
}
