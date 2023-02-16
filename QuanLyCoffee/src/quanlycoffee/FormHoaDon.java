/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlycoffee;

import DAO.HoaDonDAO;
import DBConnect.DBConnect;
import Model.HoaDon;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FormHoaDon extends javax.swing.JFrame {

    DefaultTableModel tblModelHD;

    /**
     * Creates new form FormHoaDon
     */
    public FormHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        loadData();
        loadComboBox1();
        blockButton(true);
         setTitle("Hóa Đơn");
    }

    private void lamTrong() {
        txtmahoadon.setText("");
        cbxmanv.setSelectedItem(null);
    }

    public boolean blockButton(boolean x) {
        if (x == true) {
            btnSuaHD.setEnabled(false);
            btnXoaHD.setEnabled(false);
            btnThemHD.setEnabled(true);
            btnThoatHD.setEnabled(true);
            return true;
        } else {
            btnSuaHD.setEnabled(true);
            btnXoaHD.setEnabled(true);
            btnThemHD.setEnabled(false);
            btnThoatHD.setEnabled(false);
            return false;
        }
    }

    public void loadComboBox1() {
        try {
            DBConnect a = new DBConnect();
            Connection con = a.getConnection();
            PreparedStatement ps = con.prepareStatement("Select MaNV from NhanVien group by MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbxmanv.addItem(rs.getString("MaNV"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void initTable() {
        tblModelHD = new DefaultTableModel();
        tblModelHD.setColumnIdentifiers(new String[]{"MaHD", "MaNV"});
        tblHoaDon.setModel(tblModelHD);
    }

    public void loadData() {
        try {
            DBConnect a = new DBConnect();
            Connection con = a.getConnection();
            String sql = "Select * from HoaDon";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            tblModelHD.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString("MaHD"), rs.getString("MaNV")
                };
                tblModelHD.addRow(row);
            }
            tblModelHD.fireTableDataChanged();
            rs.close();
            pstmt.close();
            con.close();
            blockButton(true);
            txtmahoadon.setEnabled(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThemHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnThoatHD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtmahoadon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxmanv = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hoá Đơn", "Mã Nhân Viên"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 293, 190));

        btnThemHD.setBackground(new java.awt.Color(255, 255, 204));
        btnThemHD.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });
        getContentPane().add(btnThemHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        btnXoaHD.setBackground(new java.awt.Color(255, 255, 204));
        btnXoaHD.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnXoaHD.setText("Xoá");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        btnSuaHD.setBackground(new java.awt.Color(255, 255, 204));
        btnSuaHD.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });
        getContentPane().add(btnSuaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton4.setText("Làm Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, 30));

        btnThoatHD.setBackground(new java.awt.Color(255, 255, 204));
        btnThoatHD.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnThoatHD.setText("Thoát");
        btnThoatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatHDActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoatHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 23)); // NOI18N
        jLabel1.setText("THÊM HÓA ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(txtmahoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 100, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("Mã Hoá Đơn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        getContentPane().add(cbxmanv, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("Mã Nhân Viên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/QL.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -160, 750, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        StringBuffer sb = new StringBuffer();
        if (txtmahoadon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                HoaDon hd = new HoaDon();
                hd.setMaHD(txtmahoadon.getText());
                hd.setMaNV(cbxmanv.getSelectedItem().toString());

                HoaDonDAO hdDAO = new HoaDonDAO();
                hdDAO.insert(hd);
                JOptionPane.showMessageDialog(this, "Thêm hoa don thành công!");
                lamTrong();
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Mã hoa don bị trùng lặp!");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        try {
            //Ngược lại thêm bẫy lỗi nếu trùng khoá chính.
            StringBuffer sb = new StringBuffer();
            int selected = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá hóa đơn này không!", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (selected == JOptionPane.YES_OPTION) {
                HoaDonDAO HDDAO = new HoaDonDAO();
                HDDAO.delete(txtmahoadon.getText());
                JOptionPane.showMessageDialog(this, "Đã xoá thành công!");
                lamTrong();
                loadData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Mã hóa đơn đã tồn tại! ");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        txtmahoadon.setEnabled(false);
        blockButton(false);
        if (row >= 0) {
            txtmahoadon.setText(tblHoaDon.getValueAt(row, 0) + "");
            cbxmanv.setSelectedItem(tblHoaDon.getModel().getValueAt(row, 1) + "");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        StringBuffer sb = new StringBuffer();
        if (txtmahoadon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
            //Bẫy lỗi nhập thiếu dữ liệu.
            return;
        }
        try {
            HoaDon hd = new HoaDon();
            hd.setMaHD(txtmahoadon.getText());
            hd.setMaNV(cbxmanv.getSelectedItem().toString());


            HoaDonDAO hdDAO = new HoaDonDAO();
            hdDAO.update(hd);
            JOptionPane.showMessageDialog(this, "Sửa thông tin hóa đơn thành công!");
            lamTrong();
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        lamTrong();
        blockButton(true);
        txtmahoadon.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnThoatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatHDActionPerformed
        FormMenu mn = new FormMenu();
        mn.show();
        this.hide();
    }//GEN-LAST:event_btnThoatHDActionPerformed

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
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnThoatHD;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JComboBox<String> cbxmanv;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtmahoadon;
    // End of variables declaration//GEN-END:variables
}