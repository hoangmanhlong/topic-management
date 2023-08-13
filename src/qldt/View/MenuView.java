/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qldt.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import qldt.Controller.MenuController;
import qldt.Model.GroupTopic;
import qldt.Model.Topic;

/**
 *
 * @author ziplo
 */
public class MenuView extends javax.swing.JFrame {
    public MenuController menuController = new MenuController();
    public static int menuView_GroupTopicID = -1;
    public static int groupID = -1;
    /**
     * Creates new form Menu
     */
    public static Topic menuView_AddNewTopicView_topic;
    public static Topic menuView_GroupTopicView_Topic;

    public MenuView() {
        System.out.println();
        System.out.println("MenuView-----------------------");
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        this.setLocationRelativeTo(null);
//        ImageIcon iconDelete = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconDelete.png");
//        jButtonDelete.setIcon(iconDelete);
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\Add.png");
        jButtonAdd.setIcon(iconAdd);
        
        
        jButtonAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonAdd.setHorizontalAlignment(SwingConstants.LEFT);

//        jButtonDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
//        jButtonDelete.setHorizontalAlignment(SwingConstants.LEFT);
        ImageIcon iconUpdate = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\Update.png");
        jButtonUpdate.setIcon(iconUpdate);
        jButtonUpdate.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonUpdate.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        ImageIcon iconSearch = new ImageIcon("C:\\Users\\ziplo\\Projects\\NetBeansProjects\\QLDT\\src\\qldt\\Image\\iconSearch.png");
        jButtonSearch.setIcon(iconSearch);
        jButtonSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButtonSearch.setHorizontalAlignment(SwingConstants.LEFT);
        
//        jTextAreaSearch.setText("<html><body><div style='text-align: center;'>Chữ chìm</div></body></html>");
//        jTextAreaSearch.setEditable(false);
//        jTextAreaSearch.setOpaque(false);
//        jTextAreaSearch.setFont(new Font("Arial", Font.PLAIN, 14));
//        add(jTextAreaSearch);
        showTopic();
    }

    public void showTopic() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chức năng chỉnh sửa cho tất cả các ô
            }
        };
        jTableDeTai.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jTableDeTai.getTableHeader().setReorderingAllowed(false);
            }
        });
        jTableDeTai.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String topicName = String.valueOf(jTableDeTai.getValueAt(jTableDeTai.getSelectedRow(), 1));
                    String groupname = String.valueOf(jTableDeTai.getValueAt(jTableDeTai.getSelectedRow(), 2));
                    int number = Integer.parseInt(String.valueOf(jTableDeTai.getValueAt(jTableDeTai.getSelectedRow(), 3)));
                    String instructor = String.valueOf(jTableDeTai.getValueAt(jTableDeTai.getSelectedRow(), 4));
                    String status = String.valueOf(jTableDeTai.getValueAt(jTableDeTai.getSelectedRow(), 5));
                    menuView_GroupTopicView_Topic = new Topic(topicName, groupname, number, instructor, status);
                    groupID = menuController.getGroupID(groupname);
                    new GroupTopicView().setVisible(true);
                    

                }
            }
        });
        

        model.setColumnIdentifiers(new Object[]{"STT", "Tên đề tài", "Tên nhóm", "Số thành viên", "Người hướng dẫn", "Trạng thái"});
        ArrayList<Topic> topics = new MenuController().getTopic();

        int i = 1;
        for (Topic topic : topics) {
            model.addRow(new Object[]{i++, topic.getTopicName(), topic.getGroupName(), topic.getNumber(), topic.getInstructor(), topic.getStatus()});
        }
        jTableDeTai.setModel(model);
        System.out.println("---------------------end MenuView");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDeTai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonRefesh = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);

        jTableDeTai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên đề tài", "Nhóm", "Số thành viên", "Người hướng dẫn", "Trạng thái"
            }
        ));
        jTableDeTai.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDeTai.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jScrollPane1.setViewportView(jTableDeTai);
        if (jTableDeTai.getColumnModel().getColumnCount() > 0) {
            jTableDeTai.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Danh sách đề tài");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(0, 153, 51));
        jButtonAdd.setText("Đề tài mới");
        jButtonAdd.setContentAreaFilled(false);
        jButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRefesh.setContentAreaFilled(false);
        jButtonRefesh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefeshActionPerformed(evt);
            }
        });

        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(0, 102, 255));
        jButtonUpdate.setText("Làm mới");
        jButtonUpdate.setContentAreaFilled(false);
        jButtonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonSearch.setContentAreaFilled(false);
        jButtonSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTextFieldSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        boolean checkcreateNewTopic = new MenuController().addNewTopicContructor();
        if (checkcreateNewTopic == false){
            JOptionPane.showMessageDialog(this, "Lỗi vui lòng thử lại");
        }
        else{
            // khởi tạo thông tin đề tài mới (temp) hiển thị trong AddnewTopicView
            menuView_AddNewTopicView_topic = menuController.getNewTopic();
            // Lấy ra GroupID của GroupTopic vừa tạo
            new AddNewTopicView().setVisible(true);
            
            }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefeshActionPerformed

    }//GEN-LAST:event_jButtonRefeshActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        jTextFieldSearch.setText("");
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chức năng chỉnh sửa cho tất cả các ô
            }
        };
        jTableDeTai.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jTableDeTai.getTableHeader().setReorderingAllowed(false);
            }
        });
        model.setColumnIdentifiers(new Object[]{"STT", "Tên đề tài", "Tên nhóm", "Số thành viên", "Người hướng dẫn", "Trạng thái"});
        ArrayList<Topic> topics = new MenuController().getTopic();
        System.out.println("------------------");
        int i = 1;
        for (Topic topic : topics) {
            model.addRow(new Object[]{i++, topic.getTopicName(), topic.getGroupName(), topic.getNumber(), topic.getInstructor(), topic.getStatus()});
        }
        jTableDeTai.setModel(model);
        System.out.println("---------------------");
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        if (!jTextFieldSearch.getText().trim().equals("")){
            DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chức năng chỉnh sửa cho tất cả các ô
            }
        };
        jTableDeTai.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jTableDeTai.getTableHeader().setReorderingAllowed(false);
            }
        });
        model.setColumnIdentifiers(new Object[]{"STT", "Tên đề tài", "Tên nhóm", "Số thành viên", "Người hướng dẫn", "Trạng thái"});
        ArrayList<Topic> topics = new MenuController().search(jTextFieldSearch.getText());
        System.out.println("------------------");
        int i = 1;
        for (Topic topic : topics) {
            model.addRow(new Object[]{i++, topic.getTopicName(), topic.getGroupName(), topic.getNumber(), topic.getInstructor(), topic.getStatus()});
        }
        jTableDeTai.setModel(model);
        System.out.println("---------------------");
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed
    public void showResultSearch(){
        
    }
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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRefesh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDeTai;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
