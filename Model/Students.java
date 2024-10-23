package Model;

public class Students extends Person {

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
