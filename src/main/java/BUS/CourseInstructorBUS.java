package com.mycompany.course.BLL;

import com.mycompany.course.DAL.CourseInstructorDAL;
import com.mycompany.course.DTO.CourseInstructorDTO;
import java.util.List;

public class CourseInstructorBUS {
    
    public static List<CourseInstructorDTO> getAllCourseInstructors() {
        return CourseInstructorDAL.getAllCourseInstructors();
    }
    
    public static void addCourseInstructor(CourseInstructorDTO courseInstructor) {
        CourseInstructorDAL.addCourseInstructor(courseInstructor);
    }
    
    public static void updateCourseInstructor(CourseInstructorDTO courseInstructor) {
        CourseInstructorDAL.updateCourseInstructor(courseInstructor);
    }
    
    public static void deleteCourseInstructor(int instructorId) {
        CourseInstructorDAL.deleteCourseInstructor(instructorId);
    }
}
