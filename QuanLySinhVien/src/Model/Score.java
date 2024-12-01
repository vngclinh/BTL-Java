package Model;

public class Score {

    private double attendance; // Điểm chuyên cần
    private double homework; // Điểm trung bình các bvtn
    private double midTerm; // Điểm giữa khóa
    private double endTerm; // Điểm cuối khóa
    private String result;

    public Score() {
        this.attendance = 0;
        this.homework = 0.0;
        this.midTerm = 0.0;
        this.endTerm = 0.0;
        this.result = "Not Graded"; // Đặt trạng thái mặc định
    }

    public Score(double attendance, double homework, double midTerm, double endTerm) {
        this.attendance = attendance;
        this.homework = homework;
        this.midTerm = midTerm;
        this.endTerm = endTerm;
        if (calFinalScore() > 5.0) {
            this.result = "Passed";
        } else {
            this.result = "Failed";
        }
    }

    public double getAttendance() {
        return attendance;
    }

    public double getHomework() {
        return homework;
    }

    public double getMidTerm() {
        return midTerm;
    }

    public double getEndTerm() {
        return endTerm;
    }

    public String getResult() {
        return result;
    }

    public double calFinalScore() {
        //Lấy 2 số sau dấu phẩy
        return Math.round((this.attendance*0.1 + this.homework * 0.2 + this.midTerm * 0.2 + this.endTerm * 0.5) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Attendance: " +String.format("%.2f", this.attendance)
                + "\nHomework Score: " + String.format("%.2f", this.homework)
                + "\nMid-term Score: " + String.format("%.2f", this.midTerm)
                + "\nEnd-term Score: " + String.format("%.2f", this.endTerm)
                + "\nOverral score: " + calFinalScore()
                + "\nResult : " + this.result;
    }
}
