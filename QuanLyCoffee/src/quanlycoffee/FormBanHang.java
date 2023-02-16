/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlycoffee;

import DAO.BanHangDAO;
import DAO.DoUongDAO;
import DAO.LoaiDoUongDAO;
import DBConnect.DBConnect;
import Model.ChiTietHoaDon;
import Model.DoUong;
import Model.LoaiDoUong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormBanHang extends javax.swing.JFrame {

	DefaultTableModel tblModelCTHD;
	DefaultTableModel tblModelCTHD1;

        
        
	/**
	 * Creates new form FormChiTietHoaDon
	 */
	public FormBanHang() {
		initComponents();
                setLocationRelativeTo(null);
		initTable1();
		loadData1();
		loadCombobox1();
		loadCombobox3();
                setTitle("Bán Hàng");
                new Thread() {

            public void run() {

                while (true) {
                    Calendar ca = new GregorianCalendar();
                    int day = ca.get(Calendar.DATE);
                    int mon = ca.get(Calendar.MONTH)+1;
                    int year = ca.get(Calendar.YEAR);
                    String time = year + "-" + mon + "-" + day;
                    txtngaylaphoadon.setText(time);
                }
            }
        }.start();
                
                
                
                txtngaylaphoadon.setEnabled(false);
		txtgia.setEnabled(false);
		txttenmon.setEnabled(false);
		txttong.setEnabled(false);
                txtmamon.setEnabled(false);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) JSpinner1.getEditor()).getTextField();
		tf.setEnabled(false);
	}
         private void lamTrong() {
        txttenmon.setText("");
        JSpinner1.setValue(0);
        txtgia.setText("");
        txttong.setText("");
        txtmamon.setText("");
        cbxmanhanvien.setSelectedItem(null);
        cbxmahd.setSelectedItem(null);
        txtngaylaphoadon.setText("");
    }
	public void TenMonByMaLoai(String maLoai) {
		DefaultTableModel dtm = (DefaultTableModel) tblTenMon.getModel();
		dtm.setRowCount(0);
		ArrayList<DoUong> list = DoUongDAO.getAllDoUongByLoaiDU(maLoai);
		Iterator<DoUong> itr = list.iterator();
		while (itr.hasNext()) {

			DoUong duObj = itr.next();
			dtm.addRow(new Object[]{duObj.getMaMon(), duObj.getTenMon(), duObj.getGia()});

		}
	}

	public void sanLocDoUongByTenMon(String tenMon, String maLoai) {
		DefaultTableModel dtm = (DefaultTableModel) tblTenMon.getModel();
		dtm.setRowCount(0);
		ArrayList<DoUong> list = DoUongDAO.sanLocDoUongByTenMon(tenMon, maLoai);
		Iterator<DoUong> itr = list.iterator();
		while (itr.hasNext()) {
			DoUong duObj = itr.next();
			dtm.addRow(new Object[]{duObj.getTenMon()});
		}
	}

	public void lamMoiDoUong() {
		txtgia.setText("");
		txttenmon.setText("");
		txttong.setText("");
		JSpinner1.setValue(1);
	}

	public void loadCombobox1() {
		try {
			DBConnect a = new DBConnect();
			Connection con = a.getConnection();
			PreparedStatement psMaLoai = con.prepareStatement("Select MaNV from NhanVien group by MaNV");
			ResultSet rsMaLoai = psMaLoai.executeQuery();
			while (rsMaLoai.next()) {
				cbxmanhanvien.addItem(rsMaLoai.getString("MaNV"));
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	public void loadCombobox3() {
		try {
			DBConnect a = new DBConnect();
			Connection con = a.getConnection();
			PreparedStatement psHoaDon = con.prepareStatement("Select MaHD from HoaDon group by MaHD");
			ResultSet rsMaHD = psHoaDon.executeQuery();
			while (rsMaHD.next()) {
				cbxmahd.addItem(rsMaHD.getString("MaHD"));
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void initTable1() {
		tblModelCTHD1 = new DefaultTableModel();
		tblModelCTHD1.setColumnIdentifiers(new String[]{"MaCTHD", "MaHD", "MaNV", "MaMon", "TenMon", "Gia", "SoLuong", "TongTien","NgayLapHD"});
		tblchitiethoadon.setModel(tblModelCTHD1);
	}

	public void loadData1() {
		try {
			DBConnect a = new DBConnect();
			Connection con = a.getConnection();
			String sql = "Select * from ChiTietHoaDon ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			tblModelCTHD1.setRowCount(0);
			while (rs.next()) {
				String[] row = new String[]{
					rs.getString("MaCTHD"), rs.getString("MaHD"), rs.getString("MaNV"), rs.getString("MaMon"), rs.getString("TenMon"), rs.getString("Gia"), rs.getString("SoLuong"), rs.getString("TongTien"), rs.getString("NgayLapHD")
				};
				tblModelCTHD1.addRow(row);
			}
			tblModelCTHD1.fireTableDataChanged();
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.toString());
			ex.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cbxMaDoUong = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTenMon = new javax.swing.JTable();
        txttenmon = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        JSpinner1 = new javax.swing.JSpinner();
        txttong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblchitiethoadon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmamon = new javax.swing.JTextField();
        cbxmanhanvien = new javax.swing.JComboBox<>();
        txtngaylaphoadon = new javax.swing.JTextField();
        cbxmahd = new javax.swing.JComboBox<>();
        txtmacthd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxMaDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaDoUongActionPerformed(evt);
            }
        });
        getContentPane().add(cbxMaDoUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 70, -1));

        tblTenMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaMon", "TenMon", "Gia"
            }
        ));
        tblTenMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTenMonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTenMon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 180, 100));
        getContentPane().add(txttenmon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 120, -1));

        txtgia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(txtgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 120, -1));

        JSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(JSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, -1));
        getContentPane().add(txttong, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 120, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setText("Tên Thức Uống");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("Số Lượng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Giá");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("Tổng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        btnclear.setBackground(new java.awt.Color(255, 255, 204));
        btnclear.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        tblchitiethoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "MaNV", "SoBan", "TenMon", "SoLuong", "Gia", "TongTien", "NgayLapHD"
            }
        ));
        tblchitiethoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchitiethoadonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblchitiethoadon);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 770, 140));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton1.setText("Thanh Toán");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("Mã Thức Uống");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("Mã Nhân Viên");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setText("Ngày Lập Hóa Đơn");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));
        getContentPane().add(txtmamon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 100, -1));

        getContentPane().add(cbxmanhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 100, -1));
        getContentPane().add(txtngaylaphoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 140, -1));
        getContentPane().add(cbxmahd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 100, -1));
        getContentPane().add(txtmacthd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel9.setText("Mã Chi Tiết Hóa Đơn");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel10.setText("Mã Hóa Đơn");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 23)); // NOI18N
        jLabel11.setText("BÁN CÀFÉ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton4.setText("Thêm Mã Hóa Đơn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*Thêm mã hóa đơn trước khi bật thanh toán");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/backround.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
	    ArrayList<LoaiDoUong> list = LoaiDoUongDAO.getAllChiTiet();
	    Iterator<LoaiDoUong> itr = list.iterator();
	    while (itr.hasNext()) {
		    LoaiDoUong lduObj = itr.next();
		    cbxMaDoUong.addItem(lduObj.getMaLoai());
	    }
	    String maLoai = (String) cbxMaDoUong.getSelectedItem();
	    TenMonByMaLoai(maLoai);
    }//GEN-LAST:event_formComponentShown

    private void cbxMaDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaDoUongActionPerformed
	    String maLoai = (String) cbxMaDoUong.getSelectedItem();
	    TenMonByMaLoai(maLoai);
    }//GEN-LAST:event_cbxMaDoUongActionPerformed

    private void tblTenMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTenMonMouseClicked
	    int row = tblTenMon.getSelectedRow();
	    if (row >= 0) {
		    txtmamon.setText(tblTenMon.getValueAt(row, 0) + "");
		    txttenmon.setText(tblTenMon.getValueAt(row, 1) + "");
		    txtgia.setText(tblTenMon.getValueAt(row, 2) + "");
	    }
	    JSpinner1.setValue(1);

    }//GEN-LAST:event_tblTenMonMouseClicked

    private void JSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JSpinner1StateChanged
	    int thanhtien;
	    int a;
	    int b;
	    a = (int) JSpinner1.getValue();
	    b = (int) Integer.parseInt(txtgia.getText());

	    thanhtien = a * b;
	    txttong.setText(Integer.toString(thanhtien));
    }//GEN-LAST:event_JSpinner1StateChanged

    private void tblchitiethoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchitiethoadonMouseClicked
	    int row = tblchitiethoadon.getSelectedRow();
	    if (row >= 0) {
		    txtmacthd.setText(tblchitiethoadon.getValueAt(row, 0) + "");
		    cbxmahd.setSelectedItem(tblchitiethoadon.getModel().getValueAt(row, 1) + "");
		    cbxmanhanvien.setSelectedItem(tblchitiethoadon.getModel().getValueAt(row, 2) + "");
		    txtmamon.setText(tblchitiethoadon.getValueAt(row, 3) + "");
		    txttenmon.setText(tblchitiethoadon.getValueAt(row, 4) + "");
		    txtgia.setText(tblchitiethoadon.getValueAt(row, 5) + "");
		    Object SoLuong = Integer.parseInt(tblchitiethoadon.getValueAt(row, 6).toString());
		    JSpinner1.setValue(SoLuong);
		    txttong.setText(tblchitiethoadon.getValueAt(row, 7) + "");
                    txtngaylaphoadon.setText(tblchitiethoadon.getValueAt(row, 8) + "");

	    }
    }//GEN-LAST:event_tblchitiethoadonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	    try {
		    ChiTietHoaDon cthd = new ChiTietHoaDon();
		    cthd.setMaCTHD(txtmacthd.getText());
		    cthd.setMaHD(cbxmahd.getSelectedItem().toString());
		    cthd.setMaNV(cbxmanhanvien.getSelectedItem().toString());
		    cthd.setMaMon(txtmamon.getText());
		    cthd.setTenMon(txttenmon.getText());
		    cthd.setGia(Integer.parseInt(txtgia.getText()));
		    cthd.setSoLuong(Integer.parseInt(JSpinner1.getValue().toString()));
		    cthd.setTongTien(Integer.parseInt(txttong.getText()));
                    cthd.setNgayLapHD(txtngaylaphoadon.getText());  

		    BanHangDAO cthdDao = new BanHangDAO();
		    cthdDao.insert(cthd);
		    loadData1();
		    JOptionPane.showMessageDialog(this, "Thêm chi tiet hoa don thành công!");

	    } catch (Exception ex) {
		    JOptionPane.showMessageDialog(this, "Mã chi tiet hoa don bị trùng lặp!");
		    ex.printStackTrace();
	    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        lamTrong();
    }//GEN-LAST:event_btnclearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FormMenu mn = new FormMenu();
        mn.show();
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {
            //Ngược lại thêm bẫy lỗi nếu trùng khoá chính.
            StringBuffer sb = new StringBuffer();
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb);
            } else {
                int selected = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá hóa don này không!", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (selected == JOptionPane.YES_OPTION) {
                    BanHangDAO bhdao = new BanHangDAO();
                    bhdao.delete(txtmacthd.getText());
                    JOptionPane.showMessageDialog(this, "Đã xoá hóa don thành công!");
                    lamTrong();
                    loadData1();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       FormHoaDon hd = new FormHoaDon();
       hd.show();
       this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

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
			java.util.logging.Logger.getLogger(FormBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FormBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FormBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FormBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FormBanHang().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner JSpinner1;
    private javax.swing.JButton btnclear;
    private javax.swing.JComboBox<String> cbxMaDoUong;
    private javax.swing.JComboBox<String> cbxmahd;
    private javax.swing.JComboBox<String> cbxmanhanvien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblTenMon;
    private javax.swing.JTable tblchitiethoadon;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtmacthd;
    private javax.swing.JTextField txtmamon;
    private javax.swing.JTextField txtngaylaphoadon;
    private javax.swing.JTextField txttenmon;
    private javax.swing.JTextField txttong;
    // End of variables declaration//GEN-END:variables
}
