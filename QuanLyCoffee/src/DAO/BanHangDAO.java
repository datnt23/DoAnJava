/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.ChiTietHoaDon;
import Model.DoUong;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class BanHangDAO {

    public boolean insert(ChiTietHoaDon cthd) throws Exception {
        String sql = "insert into ChiTietHoaDon(MaCTHD,MaHD, MaNV, MaMon, TenMon, Gia, SoLuong, TongTien,NgayLapHD) values(?,?,?,?,?,?,?,?,?)";
        try (
                Connection con = DBConnect.getConnection();  
                PreparedStatement ps = con.prepareStatement(sql);) 
        {
            ps.setString(1, cthd.getMaCTHD());
            ps.setString(2, cthd.getMaHD());
            ps.setString(3, cthd.getMaNV());
            ps.setString(4, cthd.getMaMon());
            ps.setString(5, cthd.getTenMon());
            ps.setInt(6, cthd.getGia());
            ps.setInt(7, cthd.getSoLuong());
            ps.setInt(8, cthd.getTongTien());
            ps.setString(9, cthd.getNgayLapHD());

            return ps.executeUpdate() > 0;
        }
    }

    public ArrayList<ChiTietHoaDon> findbyDate(String NgayLapHD) {
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon WHERE NgayLapHD like ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + NgayLapHD + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Ngay lap hoa don khong ton tai");
            }
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHD(rs.getString("MaHD"));
                cthd.setTongTien(rs.getInt("TongTien"));
                cthd.setNgayLapHD(rs.getString("NgayLapHD"));
                list.add(cthd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<DoUong> getAllChiTietHoaDonByHoaDon(String maLoai) {
        ArrayList<DoUong> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM DoUong WHERE MaLoai='" + maLoai + "'";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DoUong du = new DoUong();
                du.setTenMon(rs.getString("TenMon"));
                arrayList.add(du);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public boolean delete(String maCTHD) throws Exception {
        String sql = "delete from ChiTietHoaDon where MaCTHD = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maCTHD);         
          return ps.executeUpdate() > 0;
        }
    }
    
}
