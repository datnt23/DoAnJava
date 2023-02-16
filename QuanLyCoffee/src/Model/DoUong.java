/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class DoUong {
    private String MaMon, TenMon, MaLoai;
    private String Gia;
    
    public DoUong(){
        
    }

    public DoUong(String MaMon, String TenMon, String MaLoai, String Gia) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.MaLoai = MaLoai;
        this.Gia = Gia;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }
    
}
