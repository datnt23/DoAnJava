/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HoaDon;
import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author ADMIN
 */
public class HoaDonDAO {
    public boolean insert(HoaDon hd) throws Exception{
        String sql = "insert into HoaDon(MaHD, MaNV) values(?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, hd.getMaHD());
          ps.setString(2, hd.getMaNV());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(HoaDon hd) throws Exception{
        String sql = "update HoaDon set MaNV =?"
                + " where MaHD = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(3, hd.getMaHD());
          ps.setString(2, hd.getMaNV());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String MaHD) throws Exception{
        String sql = "delete from HoaDon where MaHD = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, MaHD);
          
          return ps.executeUpdate() > 0;
        }
    }
}
