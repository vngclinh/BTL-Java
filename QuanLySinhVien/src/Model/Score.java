package Model;

public class Score{
    private int attendance; // Số buổi có mặt
    private double homework; // Điểm trung bình các bvtn
    private double midTerm; // Điểm giữa khóa
    private double endTerm; // Điểm cuối khóa

    public Score(){
        
    }
    public Score(int attendance, double homework, double midTerm, double endTerm) {
        this.attendance = attendance;
        this.homework = homework;
        this.midTerm = midTerm;
        this.endTerm = endTerm;
    }

    public double calFinalScore() {
        //Nghỉ quá 5 buổi sẽ trượt khóa học
        if(this.attendance>5){
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
                "\nEnd-term Score: "+String.format("%.2f",this.endTerm);
    }
}
