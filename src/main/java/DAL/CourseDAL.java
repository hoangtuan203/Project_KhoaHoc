/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import DTO.OnLineCourseDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CourseDAL extends DatabaseConnect{
    Scanner in2 = new Scanner(System.in);
    public CourseDAL() {

        CourseDAL.connectDB();
    }

    public ArrayList  getListCourse() throws SQLException{
        String query = "SELECT * " +
                                "FROM Course " +
                                "LEFT JOIN onlinecourse ON Course.CourseID = onlinecourse.CourseID "  +
                                "LEFT JOIN onsitecourse ON Course.CourseID = onsitecourse.CourseID;";
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
                if (rs.getString("url") == null || rs.getString("url").isEmpty()) {
                    c.setType("Onsite");
                } else {
                    c.setType("Online");
                }
                list.add(c);
            }
        }
        return list;
    }
    
    
    public CourseDTO getCourse(int courseID) throws SQLException {

        String query = "SELECT * " +
                                "FROM Course " +
                                "LEFT JOIN onlinecourse ON Course.CourseID = onlinecourse.CourseID "  +
                                "LEFT JOIN onsitecourse ON Course.CourseID = onsitecourse.CourseID;";

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
                 if (rs.getString("url") == null || rs.getString("url").isEmpty()) {
                    c.setType("Onsite");
                } else {
                    c.setType("Online");
                }
            }
        }
        return c;

    }
     public List findCourses(String title) throws SQLException {
         String query = "SELECT * " +
                                "FROM Course " +
                                "LEFT JOIN onlinecourse ON Course.CourseID = onlinecourse.CourseID "  +
                                "LEFT JOIN onsitecourse ON Course.CourseID = onsitecourse.CourseID  WHERE Title  LIKE ?;";
//        String query = "SELECT * FROM Course WHERE Title  LIKE ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + title + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                CourseDTO c = new CourseDTO();
                c.setCourseID(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setCredits(rs.getInt(3));
                c.setDepartmentID(rs.getInt(4));
                if (rs.getString("url") == null || rs.getString("url").isEmpty()) {
                    c.setType("Onsite");
                } else {
                    c.setType("Online");
                }
                list.add(c);
            }
        }
        return list;
    }
    public int insertCourse(CourseDTO c) throws SQLException {
        System.out.println("URL: ");
        String url = in2.nextLine();
        String query = "Insert Course (Title, Credits, DepartmentID) VALUES (?, ?, ?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        p.setString(1, c.getTitle());
        p.setInt(2, c.getCredits());
        p.setInt(3, c.getDepartmentID());
        int result = p.executeUpdate();
        ResultSet generatedKeys  = p.getGeneratedKeys();
        int courseId = 0;
        if (generatedKeys.next()) {
        courseId = generatedKeys.getInt(1);
         } else {
        // Xử lý trường hợp không có khóa tự tăng được tạo ra
        throw new SQLException("Failed to get generated key.");
    }
        insertOnlineCourse(courseId,url);
        
     
        
        return result;
    }
    public void insertOnlineCourse(int courseId,String url)throws SQLException{
        
           OnLineCourseDTO oc = new OnLineCourseDTO();
           oc.setCourseID(courseId);
           oc.setUrl(url);
           String query = "Insert OnlineCourse (CourseID,url) VALUES (?,?)";
            PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, oc.getCourseID());
            p.setString(2, oc.getUrl());
            p.executeUpdate();
        }
    
    public int updateCourse(CourseDTO c) throws SQLException {
        String query = "Update Course SET Title = ? , Credits = ? ,  DepartmentID = ?"
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getTitle());
        p.setInt(2, c.getCredits());
        p.setInt(3, c.getDepartmentID());
        p.setInt(4, c.getCourseID());
        int result = p.executeUpdate();
        return result;
    }
    
    public int deleteStudent(int courseID) throws SQLException {
        String query = "DELETE FROM Course WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        
        String query2 = "DELETE FROM onlinecourse WHERE CourseID = ?";
        p = CourseDAL.getConnection().prepareStatement(query2);
        p.setInt(1, courseID);
        p.executeUpdate();

        return result;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 1;
        System.out.println("Quan ly thong tin khoa hoc:");
        System.out.println("----------------------------");
        //System.out.print("Enter 0: Exits; \t    1: List ; \t 2: Insert ; \t 3: Update  \t 4: Delete \t5. Find: ");
        try {

            CourseDAL c = new CourseDAL();

             CourseDTO co = new CourseDTO();
            while (choice > 0) {
                System.out.println("Enter 0: Exits; \t1: List ; \t 2: Insert ; \t 3: Update\t 4: Delete \t5. Find: ");
                try {
                        choice = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        
                        continue; // Bỏ qua phần còn lại của vòng lặp và tiếp tục vòng lặp
                    }
                switch (choice) {
                    case 1 ->
                    {
                        List b =c.getListCourse();
                        for (Object course : b) {
                            System.out.println(course.toString());
                        }
                    
                    }
                        
                    case 2 -> {
                        
                        System.out.println("Title: ");
                        String title = in.nextLine();
                        System.out.println("Credits: ");
                        int credits = in.nextInt();
                        System.out.println("DepartmentID: ");
                        int departmentID = in.nextInt();
                        
                        co.setTitle(title);
                        co.setCredits(credits);
                        co.setDepartmentID(departmentID);
                        
                        if (c.insertCourse(co) != 0) {
                            System.out.println("Complete insert ");
                        } else {
                            System.out.println("Nothing insert ");
                        }
                    }
                    case 3 -> {
                        
                        System.out.println("Enter CourseID to Update: ");
                        int courseID = Integer.parseInt(in.nextLine());
                        co.setCourseID(courseID);
                        System.out.println("Title: ");
                        String title2 = in.nextLine();
                        System.out.println("Credits: ");
                        int credits2 = in.nextInt();
                        System.out.println("DepartmentID: ");
                        int departmentID2 = in.nextInt();
                        co.setTitle(title2);
                        co.setCredits(credits2);
                        co.setDepartmentID(departmentID2);
                        
                     
                        if (c.updateCourse(co) != 0) {
                            System.out.println("Complete update");
                        } else {
                            System.out.println("Complete update");
                        }
                    }
                    case 4 -> {
                        System.out.println("Enter CourseID to delete: ");
                        int courseID = Integer.parseInt(in.nextLine());
                        if (c.deleteStudent(courseID) != 0) {
                            System.out.println("Complete delete");
                        } else {
                            System.out.println("Nothing delete");

                        }
                    }
                    case 5 -> {
                        System.out.println("Enter title to search: ");

                        String title = in.nextLine();
                        List a =c.findCourses(title);
                        for (Object course : a) {
                            System.out.println(course.toString());
                        }
                        
                        
                    }
                    default ->
                        System.out.println("Enter number not match");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
