/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlycoffee;

import DAO.NhaCungCapDAO;
import DBConnect.DBConnect;
import Model.NhaCungCap;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class FormNhaCungCap extends javax.swing.JFrame {

    DefaultTableModel tblModelNCC;

    /**
     * Creates new form FormNhaCungCap
     */
    public FormNhaCungCap() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        loadData();
        setTitle("Nhà Cung Cấp");
    }

    private void lamTrong() {
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
    }

    public boolean blockButton(boolean x) {
        if (x == true) {
            btnSuaNCC.setEnabled(false);
            btnXoaNCC.setEnabled(false);
            btnThemNCC.setEnabled(true);
            btnThoatNCC.setEnabled(true);
            return true;
        } else {
            btnSuaNCC.setEnabled(true);
            btnXoaNCC.setEnabled(true);
            btnThemNCC.setEnabled(false);
            btnThoatNCC.setEnabled(false);
            return false;
        }
    }

    private void initTable() {
        tblModelNCC = new DefaultTableModel();
        tblModelNCC.setColumnIdentifiers(new String[]{"MaNCC", "TenNCC", "SDT", "DiaChi"});
        tblNCC.setModel(tblModelNCC);
    }

    public void loadData() {
        try {
            DBConnect a = new DBConnect();
            Connection con = a.getConnection();
            String sql = "Select * from NhaCungCap";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            tblModelNCC.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString("MaNCC"), rs.getString("TenNCC"), rs.getString("SDT"), rs.getString("DiaChi")
                };
                tblModelNCC.addRow(row);
            }
            tblModelNCC.fireTableDataChanged();
            rs.close();
            pstmt.close();
            con.close();
            blockButton(true);
            txtMaNCC.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnThemNCC = new javax.swing.JButton();
        btnSuaNCC = new javax.swing.JButton();
        btnXoaNCC = new javax.swing.JButton();
        btnThoatNCC = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 23)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 339, -1));

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ"
            }
        ));
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNCC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 300));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("Mã Nhà Cung Cấp");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 130, -1));
        getContentPane().add(txtMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 130, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Tên Nhà Cung Cấp");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));
        getContentPane().add(txtTenNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 200, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("Số Điện Thoại");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 99, -1));
        getContentPane().add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 200, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Địa Chỉ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 56, -1));
        getContentPane().add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 200, 30));

        btnThemNCC.setBackground(new java.awt.Color(255, 255, 204));
        btnThemNCC.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnThemNCC.setText("Thêm");
        btnThemNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNCCActionPerformed(evt);
            }
        });
        getContentPane().add(btnThemNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 80, 30));

        btnSuaNCC.setBackground(new java.awt.Color(255, 255, 204));
        btnSuaNCC.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnSuaNCC.setText("Sửa");
        btnSuaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNCCActionPerformed(evt);
            }
        });
        getContentPane().add(btnSuaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 80, 30));

        btnXoaNCC.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaNCC.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnXoaNCC.setText("Xoá");
        btnXoaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNCCActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 80, 30));

        btnThoatNCC.setBackground(new java.awt.Color(255, 255, 204));
        btnThoatNCC.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnThoatNCC.setText("Thoát");
        btnThoatNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatNCCActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoatNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 80, 30));

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 204));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 100, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/backround.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMouseClicked
        int row = tblNCC.getSelectedRow();
        txtMaNCC.setEnabled(false);
        blockButton(false);
        if (row >= 0) {
            txtMaNCC.setText(tblNCC.getValueAt(row, 0) + "");
            txtTenNCC.setText(tblNCC.getValueAt(row, 1) + "");
            txtSDT.setText(tblNCC.getValueAt(row, 2) + "");
            txtDiaChi.setText(tblNCC.getValueAt(row, 3) + "");
        }
    }//GEN-LAST:event_tblNCCMouseClicked

    private void btnThemNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNCCActionPerformed
        StringBuffer sb = new StringBuffer();
        if (txtMaNCC.getText().equals("") || txtTenNCC.getText().equals("") || txtSDT.getText().equals("") || txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            //Bẫy lỗi nhập thiếu dữ liệu.
        } else {
            if (txtMaNCC.getText().trim().length() > 6) {
                JOptionPane.showMessageDialog(this, "Mã nhà cung cấp không vượt quá 6 ký tự! ");
                txtMaNCC.grabFocus();
            }
            if (txtSDT.getText().trim().length() > 11 || txtSDT.getText().trim().length() < 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10-11 số! ");
                txtSDT.grabFocus();
                return;
            } else if (!txtSDT.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng số điện thoại !");
                txtSDT.grabFocus();
                return;
            }
            //Ngược lại thêm bẫy lỗi nếu trùng khoá chính.

            if (sb.length() > 0) {    //Nếu if trên đúng thì sẽ thêm vào sb 1 đoạn string
                //Kiểm tra độ dài chuỗi này nếu lớn hơn  0 tức là có thông báo
                JOptionPane.showMessageDialog(this, sb);
                return;
            } else {
                try {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(txtMaNCC.getText());
                    ncc.setTenNCC(txtTenNCC.getText());
                    ncc.setSDT(txtSDT.getText());
                    ncc.setDiaChi(txtDiaChi.getText());

                    NhaCungCapDAO nccDao = new NhaCungCapDAO();
                    nccDao.insert(ncc);
                    JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!");
                    lamTrong();
                    loadData();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Mã nhà cung cấp bị trùng lặp!");
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnThemNCCActionPerformed

    private void btnSuaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNCCActionPerformed
        StringBuffer sb = new StringBuffer();
        if (txtMaNCC.getText().equals("") || txtTenNCC.getText().equals("") || txtSDT.getText().equals("") || txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            //Bẫy lỗi nhập thiếu dữ liệu.
        }
        //Ngược lại thêm bẫy lỗi nếu trùng khoá chính.
        if (sb.length() > 0) {    //Nếu if trên đúng thì sẽ thêm vào sb 1 đoạn string
            //Kiểm tra độ dài chuỗi này nếu lớn hơn  0 tức là có thông báo
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setSDT(txtSDT.getText());
            ncc.setDiaChi(txtDiaChi.getText());

            NhaCungCapDAO nccDao = new NhaCungCapDAO();
            nccDao.update(ncc);
            JOptionPane.showMessageDialog(this, "Sửa thông tin nhà cung cấp thành công!");
            lamTrong();
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaNCCActionPerformed

    private void btnXoaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNCCActionPerformed
        try {
            //Ngược lại thêm bẫy lỗi nếu trùng khoá chính.
            StringBuffer sb = new StringBuffer();
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb);
            } else {
                int selected = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá nhà cung cấp này không!", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (selected == JOptionPane.YES_OPTION) {
                    NhaCungCapDAO nccDao = new NhaCungCapDAO();
                    nccDao.delete(txtMaNCC.getText());
                    JOptionPane.showMessageDialog(this, "Đã xoá nhà cung cấp thành công!");
                    lamTrong();
                    loadData();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaNCCActionPerformed

    private void btnThoatNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatNCCActionPerformed
        btnThoatNCC.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không!", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            FormNguyenLieu mn = new FormNguyenLieu();
            mn.show();
            this.hide();
        }
    }//GEN-LAST:event_btnThoatNCCActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamTrong();
        blockButton(true);
        txtMaNCC.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(FormNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNhaCungCap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaNCC;
    private javax.swing.JButton btnThemNCC;
    private javax.swing.JButton btnThoatNCC;
    private javax.swing.JButton btnXoaNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
