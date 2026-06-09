package in.studentmanagement;

public class Student {

    private int studentID;

    private String name;

    private String branch;

    private double marks;

    public Student(int studentID, String name, String branch, double marks) {
        this.studentID = studentID;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID
                + "\nStudent Name: " + name
                + "\nStudent Branch: " + branch
                + "\nStudent Marks: " + marks + "\n";
    }
}
