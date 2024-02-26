/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAL.StudentGradeDAL;
import DTO.StudentGradeDTO;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pc
 */
public class StudentGradeBUS {
    private StudentGradeDAL SGDAL;
    private ArrayList<StudentGradeDTO> sgdto;
    
    public StudentGradeBUS() {
        SGDAL = new StudentGradeDAL();
        sgdto = new ArrayList<StudentGradeDTO>();
        sgdto = loadData();
    }
    
    public ArrayList<StudentGradeDTO> loadData() {
        return SGDAL.GetDataSG();
    }
    
    public void HienDL(DefaultTableModel model) {
        model.setRowCount(0);
        for (int i = 0; i < 25; i++) {
            model.addRow(new Object[]{sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
    }
    
    public void NextPage(DefaultTableModel model,JLabel lb) {
        int vt = 0;
        int max = 0;
        vt = Integer.parseInt((lb.getText().split("/")[0]));
        max = Integer.parseInt((lb.getText().split("/")[1]));
        if(vt == max) {
            System.out.println("da la trang cuoi");
            return;
        }
        
        model.setRowCount(0);
        lb.setText(String.valueOf(vt + 1) + "/2");
        int len = 0;
        if(vt*25 + 25 > sgdto.size()) {
            len = sgdto.size();
        } else {
            len = vt*25 + 25;
        }
        for (int i = vt*25; i < len; i++) {
            model.addRow(new Object[]{sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
    }
    
    public void PevPage(DefaultTableModel model,JLabel lb) {
        int vt = 0;
        int max = 0;
        vt = Integer.parseInt((lb.getText().split("/")[0]));
        max = Integer.parseInt((lb.getText().split("/")[1]));
        if(vt == 1) {
            System.out.println("da la trang dau");
            return;
        }
        
        model.setRowCount(0);
        lb.setText(String.valueOf(vt - 1) + "/2");
        for (int i = (vt-2)*25; i < (vt-2)*25 + 25; i++) {
            model.addRow(new Object[]{sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
    }
    
    public void Reset(DefaultTableModel model,JLabel lb) {
        sgdto = loadData();
        lb.setText("1/2");
        model.setRowCount(0);
        for (int i = 0; i < 25; i++) {
            model.addRow(new Object[]{sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
    }
    
    public void GradeTang(DefaultTableModel model ,JLabel lb ) {
        model.setRowCount(0);
        lb.setText("1/2");
        for (int i = 0; i < sgdto.size(); i++) {
            for (int j = i+1; j < sgdto.size(); j++) {
                if(sgdto.get(i).getGrade() > sgdto.get(j).getGrade()) {
                    Collections.swap(sgdto, i, j);
                }
            }
        }
        HienDL(model);
    }
    
    public void GradeGiam(DefaultTableModel model ,JLabel lb ) {
        model.setRowCount(0);
        lb.setText("1/2");
        for (int i = 0; i < sgdto.size(); i++) {
            for (int j = i+1; j < sgdto.size(); j++) {
                if(sgdto.get(i).getGrade() < sgdto.get(j).getGrade()) {
                    Collections.swap(sgdto, i, j);
                }
            }
        }
        HienDL(model);
    }
    
    public void delete(DefaultTableModel model ,JLabel lb ,int idx) {
        model.setRowCount(0);
        int vt = 0;
        vt = Integer.parseInt((lb.getText().split("/")[0]));
        sgdto.get(idx + (vt-1)*25).setGrade(0);
        int len = 0;
        if((vt-1)*25 + 25 > sgdto.size()) {
            len = sgdto.size();
        } else {
            len = (vt-1)*25 + 25;
        }
        for (int i = (vt-1)*25; i < len; i++) {
            model.addRow(new Object[]{sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
    }
    
    public void edit(int en, int co, int st, float gr) {
        for (int i = 0; i < sgdto.size(); i++) {
            if(sgdto.get(i).getEnrollmentID() == en) {
                sgdto.get(i).setCourseID(co);
                sgdto.get(i).setStudentID(st);
                sgdto.get(i).setGrade(gr);
            }
        }
    }
}
