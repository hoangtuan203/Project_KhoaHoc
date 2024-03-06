/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAL.StudentGradeDAL;
import DTO.StudentGradeDTO;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
    
    public ArrayList<StudentGradeDTO> loadDataSearch(String query) {
        return SGDAL.GetDataSearchSG(query);
    }
    
    public void renderTable(DefaultTableModel model ,int min ,int max) {
        model.setRowCount(0);
        for (int i = min; i < max; i++) {
            model.addRow(new Object[]{
                sgdto.get(i).getEnrollmentID(),
                sgdto.get(i).getCourseID(),
                sgdto.get(i).getStudentID(),
                sgdto.get(i).getGrade()});
        }
        renderUpdate(10,0);
    }
    
    public void FirstTable(DefaultTableModel model,JLabel lb) {
        if(sgdto.size() > 25) {
            renderTable(model,0,25);
            lb.setText("1/2");
        } else {
            renderTable(model,0,sgdto.size());
            lb.setText("1/1");
        }
    }
    
    public void renderPage(DefaultTableModel model,JLabel lb,int hd) {
        int vt = 0, max = 0, len=0;
        vt = Integer.parseInt((lb.getText().split("/")[0]));
        max = Integer.parseInt((lb.getText().split("/")[1]));
        if(hd == 0) {
            if(vt == max) {
                return;
            } else {
                lb.setText(String.valueOf(vt+1) + "/2");
                if(vt*25 + 25 > sgdto.size()) {
                    len = sgdto.size();
                } else {
                    len = vt*25 + 25;
                }
            }
        } else if(hd == 1) {
            if(vt == 1) {
                return;
            } else {
                lb.setText(String.valueOf(vt-1) + "/2");
                vt = vt - 2;
                len = vt*25 + 25;
            }
        } else if(hd == 2) {
            vt = vt-1;
            if(vt*25 + 25 > sgdto.size()) {
                len = sgdto.size();
            } else {
                len = vt*25 + 25;
            }
        }
        renderTable(model, vt*25, len);   
    }
    
    public void renderUpdate(float gr,int ...list) {
        for (int i = 0; i < sgdto.size(); i++) {
            if(sgdto.get(i).getEnrollmentID() == list[0] && list[1] != 0) {
                sgdto.get(i).setCourseID(list[1]);
                sgdto.get(i).setStudentID(list[2]);
                sgdto.get(i).setGrade(gr);
                break;
            } else if (sgdto.get(i).getEnrollmentID() == list[0] && list[1] == 0){
                sgdto.get(i).setGrade(gr);
                break;
            }
        }
    }
    
    public void NextPage(DefaultTableModel model,JLabel lb) {
        renderPage(model, lb, 0);
    }
    
    public void PevPage(DefaultTableModel model,JLabel lb) {
        renderPage(model, lb, 1);
    }
    
    public void Reset(DefaultTableModel model,JLabel lb) {
        sgdto = loadData();
        FirstTable(model,lb);
    }
    
    public void GradeTang(DefaultTableModel model ,JLabel lb) {
        for (int i = 0; i < sgdto.size(); i++) {
            for (int j = i+1; j < sgdto.size(); j++) {
                if(sgdto.get(i).getGrade() > sgdto.get(j).getGrade()) {
                    Collections.swap(sgdto, i, j);
                }
            }
        }
        FirstTable(model,lb);
    }
    
    public void GradeGiam(DefaultTableModel model ,JLabel lb ) {
        for (int i = 0; i < sgdto.size(); i++) {
            for (int j = i+1; j < sgdto.size(); j++) {
                if(sgdto.get(i).getGrade() < sgdto.get(j).getGrade()) {
                    Collections.swap(sgdto, i, j);
                }
            }
        }
        FirstTable(model,lb);
    }
    
    public void NotSwap(DefaultTableModel model,JLabel lb,String value) {
        if(value.equalsIgnoreCase("")) {
            sgdto = loadData();
            FirstTable(model, lb);
        } else {
            sgdto = loadDataSearch(value);
            FirstTable(model, lb);
        }
    }
    
    public void delete(DefaultTableModel model ,JLabel lb ,int id) {
        renderUpdate(0,id,0);
        renderPage(model, lb, 2);
        SGDAL.updateDeleteDB(id,0);
    }
    
    public void edit(float gr ,int ...list) {
        renderUpdate(gr,list[0],list[1],list[2]);
        SGDAL.updateEditDB(gr,list[0],list[1],list[2]);
    }
    
    public void Search(DefaultTableModel model, JLabel lb,String value) {
        sgdto = loadDataSearch(value);
        FirstTable(model, lb);
    }
}
