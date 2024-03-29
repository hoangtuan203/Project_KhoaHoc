/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CourseBUS;
import DTO.CourseDTO;
import DTO.OnLineCourseDTO;
import DTO.OnSiteCourseDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PanelCourse extends javax.swing.JPanel implements ActionListener{
    int check = 0;
    CourseBUS courseBUS = new CourseBUS();
    DefaultTableModel model ;
    /**
     * Creates new form PanelCourse
     */
    
    public PanelCourse() {
        try {
            initComponents();
            
            listCourse();
            
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(rdOnline);
            buttonGroup.add(rdOnsite);
            btnView.addActionListener((e) -> {
                try {
                    viewDetail();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnDelete.addActionListener((e) -> {
                try {
                    check = delete();
                    if (check != 0){
                        JOptionPane.showMessageDialog(null, "Xóa khóa học thành công!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Đây là khóa học đã được phân công hoặc đã có kết quả khóa học", "Xóa khóa học thất bại!", JOptionPane.PLAIN_MESSAGE);
                    }
                   check = 0;
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnReset.addActionListener((e) -> {
                try {
                    tfSearch.setText("");
                    
                    listCourse();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnSearch.addActionListener((e) -> {
                btnFind_Click(e);
            });
            btnAddCourse.addActionListener(((e) -> {
                try {
                    btnAdd_Click(e);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }));
            btnUpdate.addActionListener((e) -> {
                try {
                    btnUpdate_Click(e);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pnKhoaHoc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAddCourse = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rdOnline = new javax.swing.JRadioButton();
        rdOnsite = new javax.swing.JRadioButton();

        pnKhoaHoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CourseID", "Title", "Credit", "Department", "Type"
            }
        ));
        tbCourse.setDoubleBuffered(true);
        tbCourse.setFocusCycleRoot(true);
        jScrollPane2.setViewportView(tbCourse);

        pnKhoaHoc.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1000, 290));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSearch.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnKhoaHoc.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Năng"));

        btnAddCourse.setText("Thêm Khóa Học");

        btnDelete.setText("Xóa Khóa Học");

        btnUpdate.setText("Cập Nhật Khóa Học");

        btnReset.setText("Làm mới");

        btnView.setText("Xem");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnUpdate)
                .addGap(30, 30, 30)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnKhoaHoc.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 850, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại Khóa Học"));

        rdOnline.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdOnline.setText("Online");
        rdOnline.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        rdOnsite.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdOnsite.setText("Onsite");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(rdOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(rdOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdOnsite))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnKhoaHoc.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 310, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


private void listCourse() throws SQLException {
        List list = courseBUS.getListCourse(1);
        model = convertCourse(list);
        tbCourse.setModel(model);
//        lbStatus.setText("Num of rows: " + list.size());
    }
private DefaultTableModel convertCourse(List list) {
        String[] columnNames = {"CourseID", "Title", "Credit", "Department", "Type"};
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            CourseDTO c = (CourseDTO) list.get(i);
            data[i][0] = c.getCourseID();
            data[i][1] = c.getTitle();
            data[i][2] = c.getCredits();
            data[i][3] = c.getDepartmentName();
            data[i][4] = c.getType();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }
 public void btnAdd_Click(ActionEvent evt) throws SQLException {
        if(rdOnline.isSelected()){
            DialogOnlineCourse diaglogOnlineAdd = new DialogOnlineCourse(0,null,null);
            diaglogOnlineAdd.setVisible(true);
            
        }
        else if (rdOnsite.isSelected()) {
            DiaglogOnsiteCourse diaglogOnsiteAdd = new DiaglogOnsiteCourse(0,null,null);
            diaglogOnsiteAdd.setVisible(true);

        }
        else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn loại khóa học!");
        }
        
    }
 public void btnUpdate_Click(ActionEvent evt) throws SQLException {
     int selectedRow = tbCourse.getSelectedRow();
     if(selectedRow != -1){
         Object value = tbCourse.getValueAt(selectedRow, 4);
         String type = String.valueOf(value);
         if(type == "Online"){
             CourseDTO c  = courseBUS.getCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             OnLineCourseDTO c2  = courseBUS.getOnlineCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             DialogOnlineCourse diaglogOnlineAdd = new DialogOnlineCourse(1,c,c2);
             
             diaglogOnlineAdd.setVisible(true);
             
             
         }
         else {
             CourseDTO c  = courseBUS.getCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             OnSiteCourseDTO c2  = courseBUS.getOnsiteCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             DiaglogOnsiteCourse diaglogOnsiteAdd = new DiaglogOnsiteCourse(1,c,c2);
             diaglogOnsiteAdd.setVisible(true);
         }
     }
     
     
 }
 public void viewDetail() throws SQLException{
     int selectedRow = tbCourse.getSelectedRow();
     if(selectedRow != -1){
         Object value = tbCourse.getValueAt(selectedRow, 4);
         String type = String.valueOf(value);
         if(type == "Online"){
             CourseDTO c  = courseBUS.getCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             OnLineCourseDTO c2  = courseBUS.getOnlineCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             DetailOnlineCourse detailCourse = new DetailOnlineCourse(c,c2);
             
             detailCourse.setVisible(true);
             detailCourse.setLocationRelativeTo(null);
             
             
         }
         else {
             CourseDTO c  = courseBUS.getCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             OnSiteCourseDTO c2  = courseBUS.getOnsiteCourse(Integer.parseInt(tbCourse.getValueAt(selectedRow, 0)+""));
             DetailOnsiteCourse detailCourse = new DetailOnsiteCourse(c,c2);
             
             detailCourse.setVisible(true);
             detailCourse.setLocationRelativeTo(null);
         }
 }
 }
 public void btnFind_Click(ActionEvent e) {
        try {
            
            String title = tfSearch.getText();
            if (title.isBlank() == false) {
                List list = courseBUS.findCourses(title);
                DefaultTableModel model = convertCourse(list);
                tbCourse.setModel(model);
                
            } else {
                JOptionPane.showMessageDialog(this, "fullname is empty", "Message", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PanelCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 public int delete() throws SQLException{
     int check = 0;
     int selectedRow = tbCourse.getSelectedRow();
     if(selectedRow != -1){
          int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khóa học này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            Object value = tbCourse.getValueAt(selectedRow, 0);
         Object value2 = tbCourse.getValueAt(selectedRow, 4);
         String type = String.valueOf(value2);
         
         if(type == "Online"){
             check = courseBUS.deleteCourseOnline(Integer.parseInt(value+""));
             if (check != 0)
                model.removeRow(selectedRow);
             return check;
             
             
     }
         else{
             
             check = courseBUS.deleteCourseOnsite(Integer.parseInt(value+""));
             if(check != 0)
                model.removeRow(selectedRow);
             return check;
         }
         
         
        
        }
         
     }
      return check;
 }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnKhoaHoc;
    private javax.swing.JRadioButton rdOnline;
    private javax.swing.JRadioButton rdOnsite;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
