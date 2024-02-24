package DAL;

import com.mycompany.course.DTO.OnSiteCourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class OnSiteCourseDAL {

    public static void addOnsiteCourse(OnSiteCourseDTO onsiteCourse) {
        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "INSERT INTO OnsiteCourse (courseId, location, days, time) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, onsiteCourse.getLocation());
            preparedStatement.setString(3, onsiteCourse.getDays());
            //preparedStatement.setTime(4, java.sql.Time.valueOf(onsiteCourse.getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateOnlineCourse(OnSiteCourseDTO  onsiteCourse) {

        Connection connection = DatabaseConnect.getConnection();

        try {
            String sql = "UPDATE OnsiteCourse SET location = ?, days = ?, time = ? WHERE courseId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, onsiteCourse.getLocation());
            preparedStatement.setString(3, onsiteCourse.getDays());
            //preparedStatement.setTime(4, java.sql.Time.valueOf(onsiteCourse.getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
