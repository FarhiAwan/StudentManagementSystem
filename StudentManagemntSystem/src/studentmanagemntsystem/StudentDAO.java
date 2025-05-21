/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagemntsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class StudentDAO {
    
    public static void insertStudentWithNames(String name, String email, String course, int age, String gender, double marks) {
        Connection con = DBConnection.connect();

        String sql = "INSERT INTO students (name, email, course, age, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, course);
            pst.setInt(4, age);
            pst.setString(5, gender);
            pst.setDouble(6, marks);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully.");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Insert failed.");
            e.printStackTrace();
        }
    }
    
    public static boolean insertStudent(Student student) {
        Connection con = DBConnection.connect();
        String sql = "INSERT INTO students (name, email, course, age,gender,marks) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getCourse());
            pst.setInt(4, student.getAge());
            pst.setString(5, student.getGender());
            pst.setDouble(6, student.getMarks());
            
            
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        Connection con = DBConnection.connect();
        String sql = "SELECT * FROM students";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                s.setAge(rs.getInt("age"));
                s.setGender(rs.getString("gender"));
                s.setMarks(rs.getDouble("marks"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean updateStudent(Student student) {
        Connection con = DBConnection.connect();
        String sql = "UPDATE students SET name=?, email=?, course=?, age=?,gender=?,marks=? WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getCourse());
            pst.setInt(4, student.getAge());
            pst.setString(5, student.getGender());
            pst.setDouble(6, student.getMarks());
            pst.setInt(7, student.getId());
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteStudent(int id) {
        Connection con = DBConnection.connect();
        String sql = "DELETE FROM students WHERE id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
