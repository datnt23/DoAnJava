/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String MaNV, TenNV, MaCV, SDT;
    private byte GT;
    
    public NhanVien(){
        
    }

    public NhanVien(String MaNV, String TenNV, String MaCV, String SDT, byte GT) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.MaCV = MaCV;
        this.SDT = SDT;
        this.GT = GT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public byte getGT() {
        return GT;
    }

    public void setGT(byte GT) {
        this.GT = GT;
    }
}
