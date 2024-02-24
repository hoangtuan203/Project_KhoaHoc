/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import com.mycompany.course.DTO.CourseDTO;
import com.mycompany.course.DTO.CourseInstructorDTO;
import com.mycompany.course.DTO.OnSiteCourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class CourseDAL {

    public static List<CourseDTO> getAllCourse() {
        List<CourseDTO> course = new ArrayList<>();
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT * FROM Course";
            ResultSet rs = DatabaseConnect.doReadQuery(sql);

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String title = rs.getString("Title");
                int credits = rs.getInt("Credits");
                int departmentID = rs.getInt("DepartmentID");

                // Tạo đối tượng Course và thêm vào danh sách
                CourseDTO Course = new CourseDTO(courseID, title, credits, departmentID);
                course.add(Course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return course;
    }

    public static String getTypebyID(int courseId) {
        String type = null;
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT Course.CourseID FROM Course, Onlinecourse WHERE Course.CourseID = Onlinecourse.CourseID AND Course.CourseID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Nếu tìm thấy một dòng, điều này có nghĩa là khóa học tồn tại
                type = "Online";
            } else {
                // Nếu không tìm thấy dòng nào, khóa học không tồn tại hoặc không phải là khóa học trực tuyến
                type = "Onsite";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return type;
    }

    public static List<CourseDTO> getOnlineCourse() {
        List<CourseDTO> onlinecourse = new ArrayList<>();
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT * FROM Course, Onlinecourse WHERE Course.CourseID = Onlinecourse.CourseID ";
            ResultSet rs = DatabaseConnect.doReadQuery(sql);

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String title = rs.getString("Title");
                int credits = rs.getInt("Credits");
                int departmentID = rs.getInt("DepartmentID");

                // Tạo đối tượng Course và thêm vào danh sách
                CourseDTO Course = new CourseDTO(courseID, title, credits, departmentID);
                onlinecourse.add(Course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return onlinecourse;
    }

    public static List<CourseDTO> getOnsiteCourse() {
        List<CourseDTO> onsitecourse = new ArrayList<>();
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "SELECT * FROM Course, Onsitecourse WHERE Course.CourseID = Onsitecourse.CourseID ";
            ResultSet rs = DatabaseConnect.doReadQuery(sql);

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String title = rs.getString("Title");
                int credits = rs.getInt("Credits");
                int departmentID = rs.getInt("DepartmentID");

                // Tạo đối tượng Course và thêm vào danh sách
                CourseDTO Course = new CourseDTO(courseID, title, credits, departmentID);
                onsitecourse.add(Course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return onsitecourse;
    }

    public static void addOnsiteCourse(CourseDTO course) {
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "INSERT INTO Course (courseID, title, credits, departmentID) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setInt(3, course.getCredits());
            preparedStatement.setInt(4, course.getDepartmentID());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateCourse(CourseDTO course) {
    Connection connection = DatabaseConnect.getConnection();

    try {
        String sql = "UPDATE Course SET title = ?, credits = ?, departmentID = ? WHERE courseID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, course.getTitle());
        preparedStatement.setInt(2, course.getCredits());
        preparedStatement.setInt(3, course.getDepartmentID());
        preparedStatement.setInt(4, course.getCourseID());

        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

}
