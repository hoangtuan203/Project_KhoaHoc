/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.StudentGradeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class StudentGradeDAL {
    public ArrayList<StudentGradeDTO> arrSG;
    
    public StudentGradeDAL() {
        DatabaseConnect.connectDB();
    }
    
    public ArrayList<StudentGradeDTO> GetDataSG() {
        arrSG = new ArrayList<StudentGradeDTO>();
        try {
            String sql = "select * from studentgrade";
            PreparedStatement stmt = DatabaseConnect.c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                StudentGradeDTO sg = new StudentGradeDTO();
                sg.setEnrollmentID(rs.getInt(1));
                sg.setCourseID(rs.getInt(2));
                sg.setStudentID(rs.getInt(3));
                sg.setGrade(rs.getInt(4));
                arrSG.add(sg);
            }
            return arrSG;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
