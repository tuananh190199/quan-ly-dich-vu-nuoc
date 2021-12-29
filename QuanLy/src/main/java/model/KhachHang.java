package model;

import java.util.Date;

public class KhachHang {
	private int maKH;
	private String tenKH,diachi,dienthoai;
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public KhachHang(int maKH, String tenKH, String diachi, String dienthoai) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
	}
	public KhachHang() {
		super();
	}
	
}
