/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class NguyenLieu {
    private String MaNL, MaMon, MaNCC, TenNL, DVT;
    private int SoLuong,Tien;
    
    public NguyenLieu(){
        
    }

    public NguyenLieu(String MaNL, String MaMon, String MaNCC, String TenNL, String DVT, int SoLuong,int Tien) {
        this.MaNL = MaNL;
        this.MaMon = MaMon;
        this.MaNCC = MaNCC;
        this.TenNL = TenNL;
        this.DVT = DVT;
        this.SoLuong = SoLuong;
        this.Tien = Tien;
    }

    public String getMaNL() {
        return MaNL;
    }

    public int getTien() {
        return Tien;
    }

    public void setTien(int Tien) {
        this.Tien = Tien;
    }

    public void setMaNL(String MaNL) {
        this.MaNL = MaNL;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNL() {
        return TenNL;
    }

    public void setTenNL(String TenNL) {
        this.TenNL = TenNL;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
