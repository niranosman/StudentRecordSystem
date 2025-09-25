/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentrecordsystem;

/**
 *
 * @author Niran
 */
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecordSystem {

private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: running = false; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Grade(Numbers): ");
        double grade = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, course, grade));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter ID to search: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());
                System.out.print("Enter new grade: ");
                s.setGrade(sc.nextDouble());
                sc.nextLine();
                System.out.println("Record updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();
        students.removeIf(s -> s.getId().equals(id));
        System.out.println("Record deleted (if existed).");
    }
}
