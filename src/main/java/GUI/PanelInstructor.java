/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CourseInstructorBUS;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import DAL.DatabaseConnect;
import DTO.CourseInstructorDTO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PanelInstructor extends javax.swing.JPanel {

    /**
     * Creates new form PanelInstructor
     */
    public PanelInstructor() {
        initComponents();
        CourseInstructorBUS.ConnectDatabase();
        displayCourseInstructors();
        fillcbxcourseinstructor();
        fillcbxnameperson();
        addTableSelectionListener();

    }

    private void showSelectedRowData(int selectedRow) {
        String personName = Tablephancong.getValueAt(selectedRow, 2).toString();
        String title = Tablephancong.getValueAt(selectedRow, 4).toString();
        cbxnamegv.setSelectedItem(personName);
        cbxtitlecourser.setSelectedItem(title);
    }
<<<<<<< HEAD
private void showSelectedRowData(int selectedRow) {
    String personName = (String) Tablephancong.getValueAt(selectedRow, 2);
    if(personName != null) {
        cbxnamegv.setSelectedItem(personName);
    } else {
        cbxnamegv.setSelectedItem(null); // hoặc có thể sử dụng cbxnamegv.setSelectedIndex(-1);
    }
    
    String title = (String) Tablephancong.getValueAt(selectedRow, 4); 
    System.out.println("Person Name: " + personName);
    cbxtitlecourser.setSelectedItem(title);
}
=======

>>>>>>> 9f7b93a966442145f90aeffe0b2eb7a1d3b34706
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablephancong = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jblSearch = new javax.swing.JTextField();
        cbxSearch = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxnamegv = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxtitlecourser = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(990, 660));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(null);

        Tablephancong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID giảng viên", "Tên giảng viên", "ID khóa học", "Tên khóa Học"
            }
        ));
        jScrollPane1.setViewportView(Tablephancong);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(460, 130, 550, 430);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jblSearch.setToolTipText("");
        jblSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblSearchActionPerformed(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khóa học", "Giảng viên" }));

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel2);
        jPanel2.setBounds(470, 40, 520, 70);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbxnamegv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxnamegv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxnamegvActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giảng viên :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Khóa học :");

        cbxtitlecourser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thông Tin Chi Tiết");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReload.setText("Tải lại");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxnamegv, 0, 240, Short.MAX_VALUE)
                            .addComponent(cbxtitlecourser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxnamegv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxtitlecourser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel3);
        jPanel3.setBounds(10, 40, 430, 520);

        add(jPanel6);
    }// </editor-fold>//GEN-END:initComponents

    private void jblSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jblSearchActionPerformed

    private void cbxnamegvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxnamegvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxnamegvActionPerformed

<<<<<<< HEAD
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        int i=Tablephancong.getSelectedRow();
       if(i>=0)
       {
           String testy=(String)cbxnamegv.getSelectedItem();
           String testx=(String)cbxtitlecourser.getSelectedItem();
           if(!testy.equals("null"))
           {
                int IDperson=Integer.parseInt(Tablephancong.getValueAt(i, 1).toString());
                int IDcourse=Integer.parseInt(Tablephancong.getValueAt(i, 3).toString());
                int IDpersonchange=CourseInstructorBUS.getIDbyname(testy);
                int IDcoursechange=CourseInstructorBUS.getIDbytitle(testx);
                
                if(IDcourse==IDcoursechange && IDperson!=IDpersonchange)
                {
                    CourseInstructorDTO change=new CourseInstructorDTO(IDperson,IDcourse);
                    CourseInstructorBUS.updateCourseInstructorbytitle(change,IDpersonchange);
=======
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int i = Tablephancong.getSelectedRow();
        if (i >= 0) {
            String testy = (String) cbxnamegv.getSelectedItem();
            String testx = (String) cbxtitlecourser.getSelectedItem();
            if (!testy.equals("NULL")) {
                int IDperson = Integer.parseInt(Tablephancong.getValueAt(i, 1).toString());
                int IDcourse = Integer.parseInt(Tablephancong.getValueAt(i, 3).toString());
                int IDpersonchange = CourseInstructorBUS.getIDbyname(testy);
                int IDcoursechange = CourseInstructorBUS.getIDbytitle(testx);

                if (IDcourse == IDcoursechange && IDperson != IDpersonchange) {
                    CourseInstructorDTO change = new CourseInstructorDTO(IDperson, IDcourse);
                    CourseInstructorBUS.updateCourseInstructorbytitle(change, IDpersonchange);
>>>>>>> 9f7b93a966442145f90aeffe0b2eb7a1d3b34706
                    displayCourseInstructors();
                } else if (IDcourse != IDcoursechange && IDperson == IDpersonchange) {
                    CourseInstructorDTO change = new CourseInstructorDTO(IDperson, IDcourse);
                    CourseInstructorBUS.updateCourseInstructorbyname(change, IDcoursechange);
                    displayCourseInstructors();
                } else if (IDcourse != IDcoursechange && IDperson != IDpersonchange) {
                    JOptionPane.showMessageDialog(this, "Chỉ thay đổi 1 trường : tên giáo viên hoặc tên môn học");
                } else {
                    System.out.println("không thay đổi");
                }
            } else {
                int IDperson = Integer.parseInt(Tablephancong.getValueAt(i, 1).toString());
                int IDcourse = Integer.parseInt(Tablephancong.getValueAt(i, 3).toString());
                CourseInstructorDTO change = new CourseInstructorDTO(IDperson, IDcourse);
                CourseInstructorBUS.updateCourseInstructorbytitle(change, 0);
                displayCourseInstructors();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn vào table");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = jblSearch.getText().trim();
        String searchType = cbxSearch.getSelectedItem().toString();

        if (keyword.isEmpty()) {
            displayCourseInstructors();
        } else {

            if ("Khóa học".equals(searchType)) {

                List<CourseInstructorDTO> courseInstructors = CourseInstructorBUS.getCourseInstructorsByCourseTitle(keyword);
                displaySearchResult(courseInstructors);

            } else if ("Giảng viên".equals(searchType)) {

                List<CourseInstructorDTO> courseInstructors = CourseInstructorBUS.getCourseInstructorsByPersonName(keyword);
                displaySearchResult(courseInstructors);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        jblSearch.setText("");
        displayCourseInstructors();
    }//GEN-LAST:event_btnReloadActionPerformed
    private void displaySearchResult(List<CourseInstructorDTO> courseInstructors) {
        DefaultTableModel model = (DefaultTableModel) Tablephancong.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (CourseInstructorDTO courseInstructor : courseInstructors) {
            Object[] row = {
                stt++,
                courseInstructor.getPersonID(),
                CourseInstructorBUS.getPersonNameById(courseInstructor.getPersonID()),
                courseInstructor.getCourseID(),
                CourseInstructorBUS.getTitleById(courseInstructor.getCourseID())
            };
            model.addRow(row);
        }
    }

    private void fillcbxnameperson() {
        List<String> NamePerson = CourseInstructorBUS.getAllPersonName();
        for (String name : NamePerson) {
            cbxnamegv.addItem(name);
        }
        cbxnamegv.addItem("NULL");

    }

    private void fillcbxcourseinstructor() {
        List<String> titlecouse = CourseInstructorBUS.getAllTitleCourse();
        for (String title : titlecouse) {
            cbxtitlecourser.addItem(title);
        }
    }

    private void addTableSelectionListener() {
        Tablephancong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = Tablephancong.getSelectedRow();
                    if (selectedRow != -1) {
                        showSelectedRowData(selectedRow);
                    }
                }
            }
        });
    }

    private void displayCourseInstructors() {
        List<CourseInstructorDTO> courseInstructors = CourseInstructorBUS.getAllCourseInstructors();
        DefaultTableModel model = (DefaultTableModel) Tablephancong.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (CourseInstructorDTO courseInstructor : courseInstructors) {
            Object[] row = {
                stt++,
                courseInstructor.getPersonID(),
                CourseInstructorBUS.getPersonNameById(courseInstructor.getPersonID()),
                courseInstructor.getCourseID(),
                CourseInstructorBUS.getTitleById(courseInstructor.getCourseID())

            };
            model.addRow(row);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablephancong;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JComboBox<String> cbxnamegv;
    private javax.swing.JComboBox<String> cbxtitlecourser;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jblSearch;
    // End of variables declaration//GEN-END:variables
}
