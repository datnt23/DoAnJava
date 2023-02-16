/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Admin
 */
public class NhaCungCapDAO {
    public boolean insert(NhaCungCap ncc) throws Exception{
        String sql = "insert into NhaCungCap(MaNCC, TenNCC, SDT, DiaChi) values(?,?,?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, ncc.getMaNCC());
          ps.setString(2, ncc.getTenNCC());
          ps.setString(3, ncc.getSDT());
          ps.setString(4, ncc.getDiaChi());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(NhaCungCap ncc) throws Exception{
        String sql = "update NhaCungCap set TenNCC = ?, SDT = ?, DiaChi = ?"
                + " where MaNCC = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(4, ncc.getMaNCC());
          ps.setString(1, ncc.getTenNCC());
          ps.setString(2, ncc.getSDT());
          ps.setString(3, ncc.getDiaChi());
         
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maNCC) throws Exception{
        String sql = "delete from NhaCungCap where MaNCC = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maNCC);
          
          return ps.executeUpdate() > 0;
        }
    }
}
