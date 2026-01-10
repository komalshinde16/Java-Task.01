package com.itshaala.Model;

public class StudentModel {
    private int id;
    private String name;
    private int age;
    private int grade;
    private String contact;

    public StudentModel(int id, String name, int age, int grade, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.contact = contact;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getGrade() { return grade; }
    public String getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(int grade) { this.grade = grade; }
    public void setContact(String contact) { this.contact = contact; }

}
