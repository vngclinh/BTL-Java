package GUI;

import Model.Course;
import Model.Student;
import Model.Teacher;
import Model.Class;
import java.text.ParseException;

public class SampleDatabase {

    public SampleDatabase() throws ParseException {
        
        // Dữ liệu mẫu cho giáo viên
        Teacher teacher = new Teacher("Nguyen Van An", "01/03/1980", "0901234567");
        Teacher teacher1 = new Teacher("Tran Thi Binh", "15/07/1975", "0912345678");
        Teacher teacher2 = new Teacher("Le Minh Hoang", "22/11/1985", "0923456789");
        Teacher teacher3 = new Teacher("Pham Van Cuong", "09/05/1990", "0934567890");
        Teacher teacher4 = new Teacher("Do Thi Lan", "30/08/1983", "0945678901");

        // Dữ liệu mẫu cho sinh viên
        Student student1 = new Student("Hoang Minh Tuan", "12/09/2002", "0987123456");
        Student student2 = new Student("Le Thi Hoa", "08/03/2001", "0988234567");
        Student student3 = new Student("Nguyen Van Nam", "22/11/2000", "0989345678");
        Student student4 = new Student("Tran Van Kien", "15/05/2003", "0989456789");
        Student student5 = new Student("Pham Thi Lan", "30/06/2002", "0989567890");

        //Dữ liệu mẫu cho khóa học
        Course course = new Course("ENG101", "English for Beginners", 24);
        Course course1 = new Course("ENG102", "Intermediate English", 30);
        Course course2 = new Course("ENG103", "Advanced English", 36);
        Course course3 = new Course("ENG201", "Business English", 28);
        Course course4 = new Course("ENG202", "IELTS Preparation", 40);

        //Dữ liệu mẫu cho lớp học
        // Lớp cho khóa học ENG101 - English for Beginners
        Class aClass = new Class("ENG101", "TC001", "10/01/2024", "10/03/2024");
        Class aClass1 = new Class("ENG101", "TC002", "01/02/2024", "01/04/2024");

// Lớp cho khóa học ENG102 - Intermediate English
        Class aClass2 = new Class("ENG102", "TC003", "15/01/2024", "15/04/2024");
        Class aClass3 = new Class("ENG102", "TC004", "20/02/2024", "20/05/2024");

// Lớp cho khóa học ENG103 - Advanced English
        Class aClass4 = new Class("ENG103", "TC005", "01/03/2024", "01/06/2024");

// Lớp cho khóa học ENG201 - Business English
        Class aClass5 = new Class("ENG201", "TC001", "15/03/2024", "15/06/2024");
        Class aClass6 = new Class("ENG201", "TC003", "01/04/2024", "01/07/2024");

// Lớp cho khóa học ENG202 - IELTS Preparation
        Class aClass7 = new Class("ENG202", "TC002", "01/05/2024", "01/08/2024");
        Class aClass8 = new Class("ENG202", "TC004", "01/06/2024", "01/09/2024");

        student1.addAttendedClass(Class.getAllClasses().get("ENG101-1"));
        student2.addAttendedClass(Class.getAllClasses().get("ENG101-1"));
        student3.addAttendedClass(Class.getAllClasses().get("ENG102-1"));
        student4.addAttendedClass(Class.getAllClasses().get("ENG103-1"));
        student5.addAttendedClass(Class.getAllClasses().get("ENG201-1"));

        student1.setScore(aClass.getClassId(), 21, 8, 7.5, 9.2);
        student2.setScore("ENG101-1", 18, 9, 8.5, 8);
    }
}
