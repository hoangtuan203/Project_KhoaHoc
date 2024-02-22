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
        } 

        return courseInstructors;
    }

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

    public static String getPersonNameById(int personId) {
        String personName = null;
        Connection connection = DatabaseConnect.getConnection();

        try {
            
            String sql = "SELECT Firstname, Lastname FROM Person WHERE PersonID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, personId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                String firstName = resultSet.getString("Firstname");
                String lastName = resultSet.getString("Lastname");

                personName = firstName + " " + lastName;
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return personName;
    }

    public static String getTitleById(int courseId) {
        String title = null;
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT Title FROM Course WHERE CourseID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                title = resultSet.getString("Title");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return title;
    }
}
