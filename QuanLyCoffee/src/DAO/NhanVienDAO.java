/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    public boolean insert(NhanVien nv) throws Exception{
        String sql = "insert into NhanVien(MaNV, MaCV, TenNV, GT, SDT) values(?,?,?,?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, nv.getMaNV());
          ps.setString(2, nv.getMaCV());
          ps.setString(3, nv.getTenNV());
          ps.setByte(4, nv.getGT());
          ps.setString(5, nv.getSDT());
          
          return ps.executeUpdate() > 0;
        }
    }

    public boolean update(NhanVien nv) throws Exception{
        String sql = "update NhanVien set MaCV = ?, TenNV = ?, GT = ?, SDT = ?"
                + " where MaNV = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(5, nv.getMaNV());
          ps.setString(1, nv.getMaCV());
          ps.setString(2, nv.getTenNV());
          ps.setByte(3, nv.getGT());
          ps.setString(4, nv.getSDT());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maNV) throws Exception{
        String sql = "delete from NhanVien where MaNV = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maNV);
          
          return ps.executeUpdate() > 0;
        }
    }
}
