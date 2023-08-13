/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qldt.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qldt.Controller.GroupTopicController;
import qldt.Model.Student;
import qldt.Model.Topic;

/**
 *
 * @author ziplo
 */
public class GroupTopicView extends javax.swing.JFrame {
    public Topic topic = MenuView.menuView_GroupTopicView_Topic; // khởi tạo nhóm đề tài từ nhóm static từ class MenuView
    public static int checkOK = 0; 
    public int studentIDTemp = -1; // Tạo 1 biến tạm lưu studentID của bảng topic 
    /**
     * Creates new form GroupTopicView
     */
    public GroupTopicView() {
        System.out.println();
        System.out.println("GroupTopicView---------------------");
        initComponents();
        jLabelGroup.setText("Nhóm " + topic.getGroupName());
        this.setLocationRelativeTo(null); // set màn hình chính giữa màn hình
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(255, 255, 255)); // set màu Frame
        
        // set icon, vị trí icon và labeltext
        ImageIcon iconGroup = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconGroup.png");
        jLabelGroup.setIcon(iconGroup);
        jLabelGroup.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabelGroup.setHorizontalAlignment(SwingConstants.LEFT);
        
        ImageIcon iconDelete = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconDelete.png");
        jButtonDelete.setIcon(iconDelete);
        jButtonDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonDelete.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        ImageIcon iconDeleteStudent = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconDelete.png");
        jButtonDeleteStudent.setIcon(iconDeleteStudent);
        jButtonDeleteStudent.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonDeleteStudent.setHorizontalAlignment(SwingConstants.LEFT);
        
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\Add.png");
        jButtonAdd.setIcon(iconAdd);
        jButtonAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonAdd.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        ImageIcon iconUpdate = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\Update.png");
        jButtonUpdate.setIcon(iconUpdate);
        jButtonUpdate.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonUpdate.setHorizontalAlignment(SwingConstants.LEFT);
        
//        ImageIcon iconNofication = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconNofication.png");
//        jLabelNofication.setIcon(iconNofication);
        
        // show table grouptopic
        showGroupTopicView();
    }
        public void showGroupTopicView() {
        jTextFieldTopicName.setText(topic.getTopicName());
        jTextFieldInstructor.setText(topic.getInstructor());
        jLabelNumber.setText("Thành viên: " + topic.getNumber());
        jTextFieldStatus.setText(topic.getStatus());
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chức năng chỉnh sửa cho tất cả các ô
            }
        };
        jTableGroupTopic.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jTableGroupTopic.getTableHeader().setReorderingAllowed(false);
            }
        });
        model.setColumnIdentifiers(new Object[]{"STT", "Mã sinh viên", "Tên sinh viên"});

        ArrayList<Student> students = new GroupTopicController().showGroupTopic(topic.getGroupName());
        int i = 1;
        for (Student student : students) {
            model.addRow(new Object[]{i++, student.getStudentID(), student.getStudentName()});
        }
        jTableGroupTopic.setModel(model);
        
        
       // lấy sự kiện từ table
        jTableGroupTopic.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                     // String string = String.valueOf(jTableGroupTopic.getValueAt(jTableGroupTopic.getSelectedRow(), jTableGroupTopic.getSelectedColumn()));
                     studentIDTemp = Integer.parseInt(String.valueOf(jTableGroupTopic.getValueAt(jTableGroupTopic.getSelectedRow(), 1)));
                     System.out.println("StudentID Selected" + studentIDTemp);
                }
            }
        });

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelGroup = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jTextFieldTopicName = new javax.swing.JTextField();
        jTextFieldStatus = new javax.swing.JTextField();
        jTextFieldInstructor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGroupTopic = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jLabelNofication = new javax.swing.JLabel();
        jButtonDeleteStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelGroup.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelGroup.setForeground(new java.awt.Color(0, 153, 102));
        jLabelGroup.setText("Nhóm");

        jLabelNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNumber.setText("Số thành viên: ");

        jTextFieldTopicName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTopicName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên đề tài", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jTextFieldStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jTextFieldInstructor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người hướng dẫn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jTableGroupTopic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sinh viên", "Họ và tên"
            }
        ));
        jTableGroupTopic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableGroupTopic.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTableGroupTopic.setSelectionForeground(new java.awt.Color(255, 0, 51));
        jScrollPane1.setViewportView(jTableGroupTopic);

        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(0, 153, 102));
        jButtonAdd.setText("Thêm thành viên");
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(0, 102, 255));
        jButtonUpdate.setText("Cập nhật");
        jButtonUpdate.setContentAreaFilled(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 51, 0));
        jButtonDelete.setText("Xóa đề tài");
        jButtonDelete.setContentAreaFilled(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMessage.setForeground(new java.awt.Color(255, 0, 51));

        jButtonDeleteStudent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDeleteStudent.setForeground(new java.awt.Color(255, 0, 0));
        jButtonDeleteStudent.setText("Xóa sinh viên");
        jButtonDeleteStudent.setContentAreaFilled(false);
        jButtonDeleteStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNofication, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldTopicName)
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNofication, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTopicName, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String[] data;
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        jLabelMessage.setText("");
        String topicNameAfterUpdate = jTextFieldTopicName.getText();
        String instructorAfterUpdate = jTextFieldInstructor.getText();
        String statusAfterUpdate = jTextFieldStatus.getText();
        System.out.println(topicNameAfterUpdate + "\t" + instructorAfterUpdate + "\t" + statusAfterUpdate);
        data = new String[]{topicNameAfterUpdate, instructorAfterUpdate, statusAfterUpdate};
        String temp = topic.getTopicName();
        System.out.println(jTextFieldTopicName.getText());
        if (topicNameAfterUpdate.equals("") || instructorAfterUpdate.equals("") || statusAfterUpdate.equals("")) {
            jLabelMessage.setText("Vui lòng nhập đầy đủ thông tin");
        } else {
            int checkTopicName = new GroupTopicController().checkTopicName(jTextFieldTopicName.getText()); // check ten de tai
            
            if (jTextFieldTopicName.getText().equals(temp) || checkTopicName == 0 ) {
                new GroupTopicController().updateGroupTopic(topic.getGroupName());// update de tai
                this.setVisible(false);
                JOptionPane.showMessageDialog(this, "Thông tin đã được thay đổi");
                
            }
            else if (checkTopicName == 1){
                jLabelMessage.setText("Tên đề tài đã tồn tại");
            }
            else if (checkTopicName == 2){
                jLabelMessage.setText("Lỗi");
            }
            

        }
        
                  
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        new DeleteConfirmView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        new ListStudentNoGroupView().setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteStudentActionPerformed
        if (studentIDTemp == -1){
            jLabelMessage.setText("Vui lòng chọn sinh viên");
        }
        else{
            int checkDeleteStudentOfGroup = new GroupTopicController().setGroupIDOfStudentDeleted(MenuView.groupID, studentIDTemp);
            boolean checkDele = new GroupTopicController().deleteStudentInGroup(studentIDTemp);
            if (checkDeleteStudentOfGroup ==1 && checkDele == true){
                jLabelMessage.setText("Xóa sinh viên thành công");
                
            }
        }
    }//GEN-LAST:event_jButtonDeleteStudentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroupTopicView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupTopicView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupTopicView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupTopicView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GroupTopicView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDeleteStudent;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelGroup;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelNofication;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGroupTopic;
    private javax.swing.JTextField jTextFieldInstructor;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldTopicName;
    // End of variables declaration//GEN-END:variables
}
