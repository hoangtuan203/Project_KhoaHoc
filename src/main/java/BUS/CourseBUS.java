package BUS;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import DTO.CourseDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CourseBUS {
CourseDAL courseDal;

    public CourseBUS() {
        courseDal = new CourseDAL();
    }

    public List getListCourse(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = courseDal.getListCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public List findCourses(String title) throws SQLException {
        List list = new ArrayList();

        list = courseDal.findCourses(title);

        return list;

    }
    public CourseDTO getCourse(int courseID) throws SQLException
    {
        CourseDTO c = courseDal.getCourse(courseID);
        return c;
    }

    public int insertCourse(CourseDTO c) throws SQLException {
        int result = courseDal.insertCourse(c);
        return result;
    }

    public static void main(String[] args) {
        try {
            CourseBUS courseBUS = new CourseBUS();
            List data = courseBUS.getListCourse(1);
            CourseDTO c = (CourseDTO) data.get(0);
            System.out.println(c.getTitle());
            System.out.println(c.getType());
            System.out.println("Nothing");

        } catch (SQLException ex) {
            Logger.getLogger(CourseBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
