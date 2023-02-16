/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.DoUong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class DoUongDAO {
    public boolean insert(DoUong du) throws Exception{
        String sql = "insert into DoUong(MaMon, MaLoai, TenMon, Gia) values(?,?,?,?)";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, du.getMaMon());
          ps.setString(2, du.getMaLoai());
          ps.setString(3, du.getTenMon());
          ps.setString(4, du.getGia());
          
          return ps.executeUpdate() > 0;
        }
    }
    
    public boolean update(DoUong du) throws Exception{
        String sql = "update DoUong set MaLoai = ?, TenMon = ?, Gia = ?"
                + " where MaMon = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(4, du.getMaMon());
          ps.setString(1, du.getMaLoai());
          ps.setString(2, du.getTenMon());
          ps.setString(3, du.getGia());
          
          return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(String maMon) throws Exception{
        String sql = "delete from DoUong where MaMon = ?";
        try(
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
          ps.setString(1, maMon);
          
          return ps.executeUpdate() > 0;
        }
    }
    public static ArrayList<DoUong> getAllDoUongByLoaiDU(String maLoai) {
        ArrayList<DoUong> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM DoUong WHERE MaLoai='" + maLoai + "'";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DoUong du = new DoUong();
                du.setMaMon(rs.getString("MaMon"));
                du.setTenMon(rs.getString("TenMon"));
                du.setGia(rs.getString("Gia"));
                
                arrayList.add(du);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
        
    }
    
    public static ArrayList<DoUong> sanLocDoUongByTenMon(String tenMon, String maLoai) {
        ArrayList<DoUong> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM DoUong WHERE TenMon like '%" + tenMon + "%' and MaLoai = '" + maLoai + "'";
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
    
    public static DoUong getDoUongByTenMon(String tenMon) {
        DoUong du = new DoUong();
        String sql = "SELECT* FROM DoUong WHERE TenMon = '" + tenMon + "'";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                du.setMaLoai(rs.getString(2));
                du.setTenMon(rs.getString(3));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return du;
    }
}
