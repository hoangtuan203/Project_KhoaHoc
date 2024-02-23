/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;

import com.mycompany.course.DTO.CourseInstructorDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHY
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        String courseInst=CourseInstructorDAL.getPersonNameById(4);
        System.out.println("DAL.test.main()"+ courseInst);
        
        
    }

}
