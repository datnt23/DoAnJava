/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.LoaiDoUong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class LoaiDoUongDAO {
    public boolean insert(LoaiDoUong ldu) throws Exception{
        String sql = "insert into LoaiDoUong(MaLoai, TenLoai) values(?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, ldu.getMaLoai());
          ps.setString(2, ldu.getTenLoai());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(LoaiDoUong ldu) throws Exception{
        String sql = "update LoaiDoUong set TenLoai = ?"
                + " where MaLoai = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(2, ldu.getMaLoai());
          ps.setString(1, ldu.getTenLoai());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String maLoai) throws Exception{
        String sql = "delete from LoaiDoUong where MaLoai = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maLoai);
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public static ArrayList<LoaiDoUong> getAllChiTiet() {
        ArrayList<LoaiDoUong> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM LoaiDoUong";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LoaiDoUong ldu = new LoaiDoUong();
                ldu.setMaLoai(rs.getString("MaLoai"));
                ldu.setTenLoai(rs.getString("TenLoai"));
                arrayList.add(ldu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
