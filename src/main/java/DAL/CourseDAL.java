/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CourseDAL {

    public static ArrayList<CourseDTO> getListCourse() {
        Connection conn = null;
        try {
            String sql = "select * from course";
            conn = DatabaseConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<CourseDTO> dsl = new ArrayList<CourseDTO>();
            while (rs.next()) {
                CourseDTO pm = new CourseDTO();
                pm.setCourseID(rs.getInt(1));
                pm.setTitle(rs.getString(2));
                pm.setCredits(rs.getInt(3));
                pm.setDepartmentID(rs.getInt(4));
                dsl.add(pm);
            }
            return dsl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
