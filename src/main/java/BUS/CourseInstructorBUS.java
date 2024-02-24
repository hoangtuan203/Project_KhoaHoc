package BUS;

import DAL.CourseInstructorDAL;
import com.mycompany.course.DTO.CourseInstructorDTO;
import java.util.List;

public class CourseInstructorBUS {
    
    public static List<CourseInstructorDTO> getAllCourseInstructors() {
        return CourseInstructorDAL.getAllCourseInstructors();
    }
    
    public static void updateCourseInstructor(CourseInstructorDTO courseInstructor) {
        CourseInstructorDAL.updateCourseInstructor(courseInstructor);
    }
    public static void updateCourseInstructorbyname(CourseInstructorDTO courseInstructor) {
        CourseInstructorDAL.updateCourseInstructorbyname(courseInstructor);
    }
    

    public static String getPersonNameById(int personId) {
        return CourseInstructorDAL.getPersonNameById(personId);
    }
    
    public static String getTitleById(int courseId) {
        return CourseInstructorDAL.getTitleById(courseId);
    }
      public static List<String>getAllPersonName() {
        return CourseInstructorDAL.getAllPersonName();
    }
    public static List<String>getAllTitleCourse() {
        return CourseInstructorDAL.getAllTitleCourse();
    }
    public static int getIDbyname(String nameperson) {
        return CourseInstructorDAL.getIDbyname(nameperson);
    }
     public static int getIDbyTITLE(String title) {
        return CourseInstructorDAL.getIDbyTITLE(title);
    }
}
