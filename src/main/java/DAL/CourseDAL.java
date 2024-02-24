/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CourseDAL extends DatabaseConnect{
    
    public CourseDAL() {

        CourseDAL.connectDB();
    }

    public ArrayList  getListCourse() throws SQLException{
        String query = "SELECT * FROM Course ";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                CourseDTO c = new CourseDTO();
               c.setCourseID(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setCredits(rs.getInt(3));
                c.setDepartmentID(rs.getInt(4));
                list.add(c);
            }
        }
        return list;
    }
    
    
    public CourseDTO getCourse(int courseID) throws SQLException {

        String query = "SELECT * FROM Course WHERE CourseID = ? ";

        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        
        CourseDTO c = new CourseDTO();
        if (rs != null) {


            while (rs.next()) {
                
                c.setCourseID(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setCredits(rs.getInt(3));
                c.setDepartmentID(rs.getInt(4));
            }
        }
        return c;

    }
    
    
}
