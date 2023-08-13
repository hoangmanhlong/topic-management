package qldt.Model;

public class Student {

    private int studentID;
    private String studentName;
    private String status;
    
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStatus() {
        return status;
    }

    public Student(int studentID, String studentName, String status) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.status = status;
    }

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }
    

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName=" + studentName + '}';
    }
    
    
}
