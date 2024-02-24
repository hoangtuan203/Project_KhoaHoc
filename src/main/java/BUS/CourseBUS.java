package com.mycompany.course.BLL;

import DAL.CourseDAL;
import DAL.CourseInstructorDAL;
import com.mycompany.course.DTO.CourseDTO;
import com.mycompany.course.DTO.CourseInstructorDTO;
import java.util.List;

/**
 *
 * @author pc
 */
public class CourseBUS {
    public static List<CourseDTO> getAllCourse() {
        return CourseDAL.getAllCourse();
    }
    
    public static String getTypebyID(int courseId) {
        return CourseDAL.getTypebyID(courseId);
    }
    
    public static List<CourseDTO> getOnlineCourse() {
        return CourseDAL.getOnlineCourse();
    }
    
    public static List<CourseDTO> getOnsiteCourse() {
        return CourseDAL.getOnsiteCourse();
    }
}
