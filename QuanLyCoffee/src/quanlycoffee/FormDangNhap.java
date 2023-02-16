/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlycoffee;

import DBConnect.DBConnect;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormDangNhap extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form FormDangNhap
     */
    public FormDangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ĐĂNG NHẬP");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDangNhap = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pswPassword = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 204));
        btnDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 204));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        pswPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(pswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 230, -1));

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 230, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mật Khẩu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 90, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Tên Đăng Nhập");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/img.jpg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        DBConnect cn = new DBConnect();
        try {
            con = cn.getConnection();
            String sql = "Select * From DangNhap where TenDangNhap=? and MatKhau=?";
            pst = con.prepareCall(sql);
            pst.setString(1, txtUser.getText());
            pst.setString(2, pswPassword.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                FormMenu m = new FormMenu();
                m.show();
                this.hide();
            }
            else
            {
                if(txtUser.getText().equals("") && pswPassword.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    if(txtUser.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(this, "Tên đăng nhập trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        if(pswPassword.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(this, "Mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        } catch (ClassNotFoundException ex){
            
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtUser.setText(null);
        pswPassword.setText(null);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void pswPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
                DBConnect cn = new DBConnect();
            try {
                con = cn.getConnection();
                String sql = "Select * From DangNhap where TenDangNhap=? and MatKhau=?";
                pst = con.prepareCall(sql);
                pst.setString(1, txtUser.getText());
                pst.setString(2, pswPassword.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    FormMenu m = new FormMenu();
                    m.show();
                    this.hide();
                }
                else
                {
                    if(txtUser.getText().equals("") && pswPassword.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        if(txtUser.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(this, "Tên đăng nhập trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            if(pswPassword.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(this, "Mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            } catch (ClassNotFoundException ex){
            
            }
        }
    }//GEN-LAST:event_pswPasswordKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
                DBConnect cn = new DBConnect();
            try {
                con = cn.getConnection();
                String sql = "Select * From DangNhap where TenDangNhap=? and MatKhau=?";
                pst = con.prepareCall(sql);
                pst.setString(1, txtUser.getText());
                pst.setString(2, pswPassword.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    FormMenu m = new FormMenu();
                    m.show();
                    this.hide();
                }
                else
                {
                    if(txtUser.getText().equals("") && pswPassword.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        if(txtUser.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(this, "Tên đăng nhập trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            if(pswPassword.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(this, "Mật khẩu trống!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            } catch (ClassNotFoundException ex){
            
            }
        }
    }//GEN-LAST:event_txtUserKeyPressed

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
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
