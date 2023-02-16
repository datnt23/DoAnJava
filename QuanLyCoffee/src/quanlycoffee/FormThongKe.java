/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlycoffee;

import DAO.BanHangDAO;
import DBConnect.DBConnect;
import Model.ChiTietHoaDon;
import Model.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FormThongKe extends javax.swing.JFrame {

    private List<ChiTietHoaDon> chiTietHoaDon;
    private DefaultTableModel Model;
    DefaultTableModel tblModelTK;

    /**
     * Creates new form FormThongKe
     */
    public FormThongKe() {
        initComponents();
        this.setLocationRelativeTo(null);
        initTable();
        loadData();
        Tong();
        setTitle("Thống Kê");
    }

    private void lamTrong() {
        txtngaythangnam.setText("");
    }

    private void initTable() {
        tblModelTK = new DefaultTableModel();
        tblModelTK.setColumnIdentifiers(new String[]{"MaHD", "NgayLapHD", "TongTien"});
        tblThongKe.setModel(tblModelTK);
    }

    public void loadData() {
        try {
            DBConnect a = new DBConnect();
            Connection con = a.getConnection();
            String sql = "Select * from ChiTietHoaDon";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            tblModelTK.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString("MaHD"), rs.getString("NgayLapHD"), rs.getString("TongTien")
                };
                tblModelTK.addRow(row);
            }
            tblModelTK.fireTableDataChanged();
            rs.close();
            pstmt.close();
            con.close();
            txtngaythangnam.setEnabled(true);
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
        tblThongKe = new javax.swing.JTable();
        txtTongDoanhThu = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtngaythangnam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 23)); // NOI18N
        jLabel1.setText("THỐNG KÊ DOANH THU");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "NgayLap", "TongTien"
            }
        ));
        jScrollPane1.setViewportView(tblThongKe);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 125, 318, 249));

        txtTongDoanhThu.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtTongDoanhThu.setText("Tong Doanh Thu");
        getContentPane().add(txtTongDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 380, 218, -1));

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 100, -1));

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 204));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Tim Kiem Theo Ngay");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 65, -1, -1));
        getContentPane().add(txtngaythangnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 89, 130, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton2.setText("Xem Chi Tiết Hóa Đơn");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/backround.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, -40, 780, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        String NgayLapHD = txtngaythangnam.getText();
        if (NgayLapHD.length() > 0) {
            if (NgayLapHD.length() == 2 || NgayLapHD.length() == 4) {
                chiTietHoaDon = new BanHangDAO().findbyDate(NgayLapHD);
                tblModelTK.setRowCount(0);
                for (ChiTietHoaDon cthd : chiTietHoaDon) {
                    tblModelTK.addRow(new Object[]{
                        cthd.getMaHD(), cthd.getNgayLapHD(), cthd.getTongTien()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chỉ nhập ngày hoặc năm!");
                loadData();
            }
        } else {
            loadData();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtngaythangnam.setText("");
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormMenu mn = new FormMenu();
        mn.show();
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormChiTietHoaDon fthd = new FormChiTietHoaDon();
        fthd.show();
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JLabel txtTongDoanhThu;
    private javax.swing.JTextField txtngaythangnam;
    // End of variables declaration//GEN-END:variables

    private void Tong() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tblThongKe.getRowCount(); i++) {
            Tong += Integer.parseInt(tblThongKe.getValueAt(i, 2).toString());
        }
        txtTongDoanhThu.setText("Tong Doanh Thu: " + x.format(Tong) + " " + "VND");
    }

}