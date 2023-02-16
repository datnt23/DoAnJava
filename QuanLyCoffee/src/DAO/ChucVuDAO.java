/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.ChucVu;

/**
 *
 * @author Admin
 */
public class ChucVuDAO {
    public boolean insert(ChucVu cv) throws Exception{
        String sql = "insert into ChucVu(MaCV, TenCV) values(?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, cv.getMaCV());
          ps.setString(2, cv.getTenCV());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(ChucVu cv) throws Exception{
        String sql = "update ChucVu set TenCV = ?"
                + " where MaCV = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(2, cv.getMaCV());
          ps.setString(1, cv.getTenCV());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maCV) throws Exception{
        String sql = "delete from ChucVu where MaCV = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maCV);
          
          return ps.executeUpdate() > 0;
        }
    }
}
