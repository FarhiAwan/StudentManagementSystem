/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagemntsystem;

/**
 *
 * @author farhan
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private int age;
    private String gender;
    private double marks;

    // Constructors
    public Student() {}
    public Student(String name, String email, String course,int age,String gender,double marks) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
        this.gender = gender;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public int getAge() {return age;}
    public void setAge(int age) { this.age = age;}
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public double getMarks() {return marks; }
    public void setMarks(double marks) { this.marks = marks; }
}
