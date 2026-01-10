package com.itshaala.Controller;

import com.itshaala.Model.StudentModel;
import com.itshaala.Service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService service = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1.Add  2.View  3.Update  4.Delete  5.Search  6.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> add();
                case 2 -> view();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> search();
                case 6 -> { System.out.println("Exit"); return; }
                default -> System.out.println("Invalid");
            }
        }
    }

    void add() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        if (age <= 0) { System.out.println("Invalid age"); return; }

        System.out.print("Grade (1-12): ");
        int grade = sc.nextInt();
        if (grade < 1 || grade > 12) { System.out.println("Invalid grade"); return; }

        sc.nextLine();
        System.out.print("Contact: ");
        String contact = sc.nextLine();

        service.addStudent(new StudentModel(id, name, age, grade, contact));
        System.out.println("Student Added");
    }

    void view() {
        System.out.println("\nID  Name  Age  Grade  Contact");
        for (StudentModel s : service.getAllStudents()) {
            System.out.println(
                    s.getId()+" "+s.getName()+" "+s.getAge()+" "+s.getGrade()+" "+s.getContact()
            );
        }
    }

    void update() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
       StudentModel s = service.findById(id);

        if (s == null) {
            System.out.println("Not found");
            return;
        }

        sc.nextLine();
        System.out.print("New Name: ");
        s.setName(sc.nextLine());

        System.out.print("New Age: ");
        s.setAge(sc.nextInt());

        System.out.print("New Grade: ");
        s.setGrade(sc.nextInt());

        sc.nextLine();
        System.out.print("New Contact: ");
        s.setContact(sc.nextLine());

        System.out.println("Updated");
    }

    void delete() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        if (service.deleteStudent(id))
            System.out.println("Deleted");
        else
            System.out.println("Not found");
    }

    void search() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        StudentModel s = service.findById(id);
        if (s != null)
            System.out.println(s.getId()+" "+s.getName()+" "+s.getAge()+" "+s.getGrade()+" "+s.getContact());
        else
            System.out.println("Not found");
    }
}

