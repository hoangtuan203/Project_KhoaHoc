/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.DatabaseConnect;
import DTO.CourseInstructorDTO;
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

    public static List<String> getAllPersonName() {
            List<String> PersonName = new ArrayList<>();
        
            Connection connection = DatabaseConnect.getConnection();

            try {
                String sql = "SELECT Lastname,Firstname FROM Person Where HireDate>0";
                ResultSet rs = DatabaseConnect.doReadQuery(sql);

                while (rs.next()) {
 
                       String firstName = rs.getString("Firstname");
                        String lastName = rs.getString("Lastname");
                        String fullname=firstName+ ' ' +lastName;

         
                    PersonName.add(fullname);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
           
            return PersonName;
        }
        public static List<String> getAllTitleCourse() {
            List<String> TitleCourse = new ArrayList<>();
           
            Connection connection = DatabaseConnect.getConnection();

            try {
                String sql = "SELECT Title FROM Course";
                ResultSet rs = DatabaseConnect.doReadQuery(sql);

                while (rs.next()) {
                       String Titlecourse = rs.getString("Title");


                    // Tạo đối tượng CourseInstructor và thêm vào danh sác

                    TitleCourse.add(Titlecourse);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } 
           
            return TitleCourse;
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
        DatabaseConnect.connectDB();
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
