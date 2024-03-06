package BUS;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import DTO.CourseDTO;
import DTO.OnLineCourseDTO;
import DTO.OnSiteCourseDTO;
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
    public OnLineCourseDTO getOnlineCourse(int courseID) throws SQLException
    {
        OnLineCourseDTO c = courseDal.getOnLineCourse(courseID);
        return c;
    }
    public OnSiteCourseDTO getOnsiteCourse(int courseID) throws SQLException
    {
        OnSiteCourseDTO c = courseDal.getOnsiteCourse(courseID);
        return c;
    }
    public int updateCourse(CourseDTO c) throws SQLException{
         int result = courseDal.updateCourse(c);
         
         return result;
    }
    public int updateOnlineCourse(OnLineCourseDTO c) throws SQLException{
        int result = courseDal.updateOnlineCourse(c);
        return result;
    }
    public int updateOnsiteCourse(OnSiteCourseDTO c) throws SQLException{
        int result = courseDal.updateOnsiteCourse(c);
        return result;
    }
    public ArrayList getDepartment () throws SQLException {
        ArrayList list = new ArrayList();

        list = courseDal.getDepartment();

        return list;
    }
    public int insertCourseOnline(CourseDTO c,OnLineCourseDTO c2) throws SQLException {
        int result = courseDal.insertCourseOnline(c,c2);
        return result;
    }
    public int insertCourseOnsite(CourseDTO c,OnSiteCourseDTO c2) throws SQLException {
        int result = courseDal.insertCourseOnsite(c,c2);
        return result;
    }
public int deleteCourseOnline(int courseID) throws SQLException{
    int result =courseDal.deleteCourse(courseID);
    if (result != 0){
        int result2 =courseDal.deleteCourseOnline(courseID);
        return result;
    }
    return result;
}
public int deleteCourseOnsite(int courseID) throws SQLException{
    int result =courseDal.deleteCourse(courseID);
    if (result != 0) {
        int result2 =courseDal.deleteCourseOnsite(courseID);
        return result;
    }
    return result;
}
    public static void main(String[] args) {
        try {
            CourseBUS courseBUS = new CourseBUS();
//            List data = courseBUS.getListCourse(1);
//            CourseDTO c = (CourseDTO) data.get(0);
//            System.out.println(c.getTitle());
//            System.out.println(c.getType());
//            System.out.println("Nothing");
//            OnLineCourseDTO c2 = courseBUS.getOnlineCourse(4087);
//            CourseDTO c = courseBUS.getCourse(4041);
//            c.setCredits(0);
//            courseBUS.updateCourse(c);
//            c2.setUrl("http://www.fineartschool.net/Macroeconomicszz");
            courseBUS.deleteCourseOnline(4087);

        } catch (SQLException ex) {
            Logger.getLogger(CourseBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
