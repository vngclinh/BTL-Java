package Model;

public class Score{
    private int attendance; // Số buổi có mặt
    private double homework; // Điểm trung bình các bvtn
    private double midTerm; // Điểm giữa khóa
    private double endTerm; // Điểm cuối khóa
    private String result;

    public Score(){
        
    }
    public Score(int attendance, double homework, double midTerm, double endTerm) {
        this.attendance = attendance;
        this.homework = homework;
        this.midTerm = midTerm;
        this.endTerm = endTerm;
        if (calFinalScore()> 5.0){
            this.result = "Passed";
        }else this.result = "Failed";
    }

    public String getResult() {
        return result;
    }

    public double calFinalScore() {
        //Đi học ít hơn 10 buổi sẽ trượt khóa học
        if(this.attendance<10){
            return 0;
        }
        //Lấy 2 số sau dấu phẩy
        return Math.round((this.homework * 0.1 + this.midTerm * 0.3 + this.endTerm * 0.6)*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Attendance: "+this.attendance+
                "\nHomework Score: "+String.format("%.2f",this.homework)+
                "\nMid-term Score: "+String.format("%.2f", this.midTerm)+
                "\nEnd-term Score: "+String.format("%.2f",this.endTerm)+
                "\nResult : "+this.result;
    }
}
