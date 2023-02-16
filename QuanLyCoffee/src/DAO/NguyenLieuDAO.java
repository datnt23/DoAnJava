/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.NguyenLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Admin
 */
public class NguyenLieuDAO {
    public boolean insert(NguyenLieu nl) throws Exception{
        String sql = "insert into NguyenLieu(MaNL, MaMon, MaNCC, TenNL, SoLuong, DVT,Tien) values(?,?,?,?,?,?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, nl.getMaNL());
          ps.setString(2, nl.getMaMon());
          ps.setString(3, nl.getMaNCC());
          ps.setString(4, nl.getTenNL());
          ps.setInt(5, nl.getSoLuong());
          ps.setString(6, nl.getDVT());
          ps.setInt(7, nl.getTien());
          
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(NguyenLieu nv) throws Exception{
        String sql = "update NguyenLieu set MaNCC = ?, MaMon = ?, TenNL = ?, SoLuong = ?, DVT = ?"
                + " where MaNL = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(6, nv.getMaNL());
          ps.setString(1, nv.getMaNCC());
          ps.setString(2, nv.getMaMon());
          ps.setString(3, nv.getTenNL());
          ps.setInt(4, nv.getSoLuong());
          ps.setString(5, nv.getDVT());
          
          return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String maNL) throws Exception{
        String sql = "delete from NguyenLieu where MaNL = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maNL);
          
          return ps.executeUpdate() > 0;
        }
    }
}
