/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigInteger;
import java.util.Date;
import javax.swing.JTextField;
import microsoft.sql.DateTimeOffset;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon {

	private String MaCTHD, MaHD, MaNV, MaMon, TenMon,NgayLapHD;
	private int SoBan, Gia, SoLuong, TongTien;

	public ChiTietHoaDon(String MaCTHD, String MaHD, String MaNV, String MaMon, String TenMon,String NgayLapHD, int Gia, int SoLuong, int TongTien) {
		this.MaCTHD = MaCTHD;
		this.MaHD = MaHD;
		this.MaNV = MaNV;
		this.MaMon = MaMon;
		this.TenMon = TenMon;
		this.Gia = Gia;
		this.SoLuong = SoLuong;
		this.TongTien = TongTien;
                this.NgayLapHD = NgayLapHD;
	}

    public String getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(String NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

	public ChiTietHoaDon() {

	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String MaHD) {
		this.MaHD = MaHD;
	}

	public String getMaCTHD() {
		return MaCTHD;
	}

	public void setMaCTHD(String MaCTHD) {
		this.MaCTHD = MaCTHD;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String MaNV) {
		this.MaNV = MaNV;
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

	public int getGia() {
		return Gia;
	}

	public void setGia(int Gia) {
		this.Gia = Gia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int SoLuong) {
		this.SoLuong = SoLuong;
	}

	public int getTongTien() {
		return TongTien;
	}

	public void setTongTien(int TongTien) {
		this.TongTien = TongTien;
	}


	public void setMaCTHD(JTextField txtmacthd) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
