/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.course.DAL;


import DAL.DatabaseConnect;
import com.mycompany.course.DTO.CourseInstructorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorDAL {
    
    // Lấy danh sách CourseInstructor từ database
    public static List<CourseInstructorDTO> getAllCourseInstructors() {
        List<CourseInstructorDTO> courseInstructors = new ArrayList<>();
        Connection connection = DatabaseConnect.getConnection();
        
        try {
            String sql = "SELECT * FROM CourseInstructor";
            ResultSet rs = DatabaseConnect.doReadQuery(sql);
            
            while (rs.next()) {
                int instructorId = rs.getInt("PersonID");
                int courseId = rs.getInt("CourseID");
                
                // Tạo đối tượng CourseInstructor và thêm vào danh sách
                CourseInstructorDTO courseInstructor = new CourseInstructorDTO(instructorId, courseId);
                courseInstructors.add(courseInstructor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnect.closeConnection();
        }
        
        return courseInstructors;
    }
    
    // Thêm một CourseInstructor vào database
    public static void addCourseInstructor(CourseInstructorDTO courseInstructor) {
        Connection connection = DatabaseConnect.getConnection();
        
        try {
            String sql = "INSERT INTO CourseInstructor (instructorId, courseId) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, courseInstructor.getCourseID());
            preparedStatement.setInt(2, courseInstructor.getPersonID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnect.closeConnection();
        }
    }
    
    // Sửa thông tin một CourseInstructor trong database
    public static void updateCourseInstructor(CourseInstructorDTO courseInstructor) {
        Connection connection = DatabaseConnect.getConnection();
        
        try {
            String sql = "UPDATE CourseInstructor SET courseId = ? WHERE instructorId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, courseInstructor.getCourseID());
            preparedStatement.setInt(2, courseInstructor.getPersonID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnect.closeConnection();
        }
    }
    
    // Xóa một CourseInstructor từ database
    public static void deleteCourseInstructor(int instructorId) {
        Connection connection = DatabaseConnect.getConnection();
        
        try {
            String sql = "DELETE FROM CourseInstructor WHERE instructorId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, instructorId);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnect.closeConnection();
        }
    }
    
    public static String getPersonNameById(int personId) {
        String personName = null;
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT FirstName, LastName FROM Person WHERE PersonID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Assuming "FirstName" and "LastName" are the columns in your database table
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                
                // Concatenate first and last names
                personName = firstName + " " + lastName;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DatabaseConnect.closeConnection();
        }

        return personName;
    }
}

