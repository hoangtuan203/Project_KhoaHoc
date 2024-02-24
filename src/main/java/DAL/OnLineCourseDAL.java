/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import com.mycompany.course.DTO.CourseInstructorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class OnLineCourseDAL {
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
        } 
    }
    public static void updateOnlineCourse(CourseInstructorDTO courseInstructor) {
        
        Connection connection = DatabaseConnect.getConnection();
        

        try {
            String sql = "UPDATE CourseInstructor SET courseId = ? WHERE instructorId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, courseInstructor.getCourseID());
            preparedStatement.setInt(2, courseInstructor.getPersonID());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
}
