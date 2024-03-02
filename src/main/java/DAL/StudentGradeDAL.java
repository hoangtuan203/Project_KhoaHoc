/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.StudentGradeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public ArrayList<StudentGradeDTO> GetDataSearchSG(String query) {
        arrSG = new ArrayList<StudentGradeDTO>();
        try {
            String sql = "select * from studentgrade where EnrollmentID = " + query + " or CourseID = " + query + " "
                    + "or StudentID = " + query;
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
    
    public void updateDeleteDB(int id, int gr) {
        Connection con = DatabaseConnect.getConnection();
        try {
            String sql = "update studentgrade set Grade = ? where EnrollmentID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, gr);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEditDB(float gr, int ...list) {
        Connection con = DatabaseConnect.getConnection();
        try {
            String sql = "update studentgrade set CourseID = ? ,StudentID = ? ,Grade = ? where EnrollmentID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, list[1]);
            ps.setInt(2, list[2]);
            ps.setFloat(3, gr);
            ps.setInt(4, list[0]);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
