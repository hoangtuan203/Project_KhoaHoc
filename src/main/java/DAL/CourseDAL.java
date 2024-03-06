/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CourseDTO;
import DTO.DepartmentDTO;
import DTO.OnLineCourseDTO;
import DTO.OnSiteCourseDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
                                "LEFT JOIN onsitecourse ON Course.CourseID = onsitecourse.CourseID " +
                                "JOIN department ON Course.DepartmentID = department.DepartmentID;";
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
                c.setDepartmentName(rs.getString("Name"));
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
     public ArrayList getDepartment ()throws SQLException{
        String query = "SELECT * FROM department " ;
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if(rs != null){
            while(rs.next()){
                DepartmentDTO d = new DepartmentDTO();
                d.setDepartmentID(rs.getInt(1));
                d.setName(rs.getString(2));
                list.add(d);
            }
            
        }
        return list;
    }
    
    
    public CourseDTO getCourse(int courseID) throws SQLException {

        String query = "SELECT * " +
                                "FROM Course " +
                                "LEFT JOIN onlinecourse ON Course.CourseID = onlinecourse.CourseID "  +
                                "LEFT JOIN onsitecourse ON Course.CourseID = onsitecourse.CourseID " + 
                                "JOIN department ON Course.DepartmentID = department.DepartmentID "+
                                " WHERE Course.CourseID = ?";

        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        
        CourseDTO c = new CourseDTO();
        if (rs.next()) {
                c.setCourseID(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setCredits(rs.getInt(3));
                c.setDepartmentID(rs.getInt(4));
                c.setDepartmentName(rs.getString("Name"));
                 if (rs.getString("url") == null || rs.getString("url").isEmpty()) {
                    c.setType("Onsite");
                } else {
                    c.setType("Online");
                }
       
        }
        return c;

    }
    public OnLineCourseDTO getOnLineCourse (int courseID)throws SQLException{
        String query = "SELECT * FROM OnlineCourse WHERE CourseID = ?" ;
        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
         OnLineCourseDTO c= new OnLineCourseDTO();
        if (rs.next()){
           
            c.setCourseID(rs.getInt(1));
            c.setUrl(rs.getString(2));
        }
        return c;
       
    }
    public OnSiteCourseDTO getOnsiteCourse (int courseID)throws SQLException{
        String query = "SELECT * FROM OnsiteCourse WHERE CourseID = ?" ;
        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
         OnSiteCourseDTO c= new OnSiteCourseDTO();
        if (rs.next()){
           
            c.setCourseID(rs.getInt(1));
            c.setLocation(rs.getString(2));
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
    public int insertCourseOnline(CourseDTO c,OnLineCourseDTO c2) throws SQLException {
//        String url = in2.nextLine();
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
        c2.setCourseID(courseId);
        insertOnlineCourse(c2);
        
     
        
        return result;
    }
    public void insertOnlineCourse(OnLineCourseDTO c2)throws SQLException{
           String query = "Insert OnlineCourse (CourseID,url) VALUES (?,?)";
            PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, c2.getCourseID());
            p.setString(2, c2.getUrl());
            p.executeUpdate();
        }
    public int insertCourseOnsite(CourseDTO c,OnSiteCourseDTO c2) throws SQLException {
//        String url = in2.nextLine();
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
        c2.setCourseID(courseId);
        insertOnsiteCourse(c2);
        
     
        
        return result;
    }
    public void insertOnsiteCourse(OnSiteCourseDTO c2)throws SQLException{
           LocalDate currentDate = LocalDate.now();
            c2.setDays(currentDate+"");
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            c2.setTime(formattedTime);
            System.out.println("Current time: " + formattedTime);
           String query = "Insert OnsiteCourse (CourseID,Location,Days,Time) VALUES (?,?,?,?)";
            PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, c2.getCourseID());
            p.setString(2, c2.getLocation());
            p.setString(3,c2.getDays());
            p.setString(4, c2.getTime());
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
    public int updateOnlineCourse(OnLineCourseDTO c) throws SQLException {
        String query = "Update OnlineCourse SET url = ?"
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getUrl());
        p.setInt(2, c.getCourseID());
        int result = p.executeUpdate();
        return result;
    }
    public int updateOnsiteCourse(OnSiteCourseDTO c) throws SQLException {
        String query = "Update OnsiteCourse SET Location = ?"
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getLocation());
        p.setInt(2, c.getCourseID());
        int result = p.executeUpdate();
        return result;
    }
    public boolean getCourseInstructor(int courseID )throws SQLException {
        String query = "SELECT * FROM courseinstructor WHERE CourseID = ?" ;
        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        
        return rs.next();
    }
    public boolean getStudentGrade(int courseID )throws SQLException {
        String query = "SELECT * FROM StudentGrade WHERE CourseID = ?" ;
        PreparedStatement p =CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        
        return rs.next();
    }
    
    public int deleteCourse(int courseID) throws SQLException {
        if (getCourseInstructor(courseID) || getStudentGrade(courseID ))
            return 0;
        else{
            String query = "DELETE FROM Course WHERE CourseID = ?";
            PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, courseID);
            int result = p.executeUpdate();
            return result;
        }
        
    }
    public int deleteCourseOnline(int courseID) throws SQLException{
        String query = "DELETE FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        
        int result = p.executeUpdate();
        return result;
    }
    public int deleteCourseOnsite(int courseID) throws SQLException{
        String query = "DELETE FROM onsitecourse WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        
        int result = p.executeUpdate();
        return result;
    }
   
    
    public static void main(String[] args) {
        CourseDAL c = new CourseDAL();
        try {
            CourseDTO cz = c.getCourse(4080);
            cz.setTitle("123");
            if (c.updateCourse(cz) != 0) {
                System.out.println(c.updateCourse(cz));
            }
//
//        Scanner in = new Scanner(System.in);
//        int choice = 1;
//        System.out.println("Quan ly thong tin khoa hoc:");
//        System.out.println("----------------------------");
//        //System.out.print("Enter 0: Exits; \t    1: List ; \t 2: Insert ; \t 3: Update  \t 4: Delete \t5. Find: ");
//        try {
//
//            CourseDAL c = new CourseDAL();
//
//             CourseDTO co = new CourseDTO();
//            while (choice > 0) {
//                System.out.println("Enter 0: Exits; \t1: List ; \t 2: Insert ; \t 3: Update\t 4: Delete \t5. Find: ");
//                try {
//                        choice = Integer.parseInt(in.nextLine());
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid input! Please enter a valid integer.");
//                        
//                        continue; // Bỏ qua phần còn lại của vòng lặp và tiếp tục vòng lặp
//                    }
//                switch (choice) {
//                    case 1 ->
//                    {
//                        List b =c.getListCourse();
//                        for (Object course : b) {
//                            System.out.println(course.toString());
//                        }
//                    
//                    }
//                        
//                    case 2 -> {
//                        
//                        System.out.println("Title: ");
//                        String title = in.nextLine();
//                        System.out.println("Credits: ");
//                        int credits = in.nextInt();
//                        System.out.println("DepartmentID: ");
//                        int departmentID = in.nextInt();
//                        
//                        co.setTitle(title);
//                        co.setCredits(credits);
//                        co.setDepartmentID(departmentID);
//                        
//                        if (c.insertCourse(co) != 0) {
//                            System.out.println("Complete insert ");
//                        } else {
//                            System.out.println("Nothing insert ");
//                        }
//                    }
//                    case 3 -> {
//                        
//                        System.out.println("Enter CourseID to Update: ");
//                        int courseID = Integer.parseInt(in.nextLine());
//                        co.setCourseID(courseID);
//                        System.out.println("Title: ");
//                        String title2 = in.nextLine();
//                        System.out.println("Credits: ");
//                        int credits2 = in.nextInt();
//                        System.out.println("DepartmentID: ");
//                        int departmentID2 = in.nextInt();
//                        co.setTitle(title2);
//                        co.setCredits(credits2);
//                        co.setDepartmentID(departmentID2);
//
//                     
//                        if (c.updateCourse(co) != 0) {
//                            System.out.println("Complete update");
//                        } else {
//                            System.out.println("Complete update");
//                        }
//                    }
//                    case 4 -> {
//                        System.out.println("Enter CourseID to delete: ");
//                        int courseID = Integer.parseInt(in.nextLine());
//                        if (c.deleteStudent(courseID) != 0) {
//                            System.out.println("Complete delete");
//                        } else {
//                            System.out.println("Nothing delete");
//
//                        }
//                    }
//                    case 5 -> {
//                        System.out.println("Enter title to search: ");
//
//                        String title = in.nextLine();
//                        List a =c.findCourses(title);
//                        for (Object course : a) {
//                            System.out.println(course.toString());
//                        }
//
//                        
//                    }
//                    default ->
//                        System.out.println("Enter number not match");
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
