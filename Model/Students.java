package Model;

import java.util.Scanner;

public class Students extends Person {

    static Scanner in = new Scanner(System.in);
    private GPA gpa;

    public Students(String id, String name, String dob, GPA gpa) {
        super(id, name, dob);
        this.gpa = gpa;
    }

    public GPA getGpa() {
        return this.gpa;
    }

    public void setGpa(GPA gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " " + gpa.getDetails();
    }
}
