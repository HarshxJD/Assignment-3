import java.util.Scanner;

public class ResultManager {
    private Student[] students = new Student[50];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);
            s.validateMarks();

            students[count++] = s;
            System.out.println("Student added successfully.");

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            System.out.println("Returning to main menu...");
        }
    }

    public void showStudentDetails() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == roll) {
                students[i].displayResult();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: showStudentDetails(); break;
                case 3:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        ResultManager rm = new ResultManager();
        rm.mainMenu();
    }
}
