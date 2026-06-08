package in.studentmanagement;

import java.util.Scanner;

public class StudentManagementSystem {

    private static final Student[] studentArr = new Student[50];
    private static int studentCount = 0;

    public void addStudent() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Student ID: ");
        int studentID = input.nextInt();

        System.out.println("Enter Student Name: ");
        String name = input.next();

        System.out.println("Enter Student Branch: ");
        String branch = input.next();

        System.out.println("Enter Student Marks: ");
        double marks = input.nextDouble();

        Student student = new Student(studentID, name, branch, marks);

        if (studentCount < studentArr.length)   {
            studentArr[studentCount] = student;
            studentCount++;
            System.out.println("Student added successfully!!\n");
        } else {
            System.out.println("Student array is full! Cannot add more students.\n");
        }
    }

    public static void viewAllStudents()    {
        if (studentCount == 0)  {
            System.out.println("No Students Available.\n");
        }

        System.out.println("===== STUDENT LIST =====\n");

        for (int i = 0; i < studentCount; i++) {
            System.out.println(studentArr[i].toString());
        }
    }

    public static void searchStudent()    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int searchID = input.nextInt();
        boolean found = false;

        for (int i = 0; i < studentCount; i++)  {
            if (searchID == studentArr[i].getStudentID())   {
                System.out.println("Student Found!!\n");
                System.out.println(studentArr[i].toString());
                found = true;
            }
        }
        if (!found)  {
            System.out.println("Student Not Found!!");
        }
    }

    public static void deleteStudent()  {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        int searchID = input.nextInt();
        boolean found = false;
        int deleteInd = 0;

        for (int i = 0; i < studentCount; i++)  {
            if (searchID == studentArr[i].getStudentID())   {
                System.out.println("Student Deleted Successfully!!");
                deleteInd = i;
                found = true;
            }
        }
        if (!found)  {
            System.out.println("Student Not Found!!");
        }

        studentArr[deleteInd] = studentArr[deleteInd + 1];
        studentCount--;
        studentArr[studentCount] = null;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManagementSystem service = new StudentManagementSystem();

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        int choice;

        do {

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit.");
            choice = input.nextInt();

            switch (choice) {

                case 1: service.addStudent();
                    break;

                case 2: service.viewAllStudents();
                    break;

                case 3: service.searchStudent();
                    break;

                case 4: service.deleteStudent();
                    break;

                case 5:
                    System.out.println("Program Exited!!");
                    break;

                default:
                    System.out.println("You entered WRONG!! option.");
            }

        } while (choice != 5);
    }
}
