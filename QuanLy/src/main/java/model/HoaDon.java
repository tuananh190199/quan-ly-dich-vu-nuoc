package model;

import java.util.Date;

public class HoaDon implements Comparable<HoaDon>{
	private int maHD;

	private float thueVAT,tongtien;
	DongHo dongHo;
	HoDungNuoc hoDungNuoc;
	private String trangthai;
	KhachHang khachHang;
	public HoaDon(int maHD, float thueVAT, float tongtien, DongHo dongHo, HoDungNuoc hoDungNuoc,
			String trangthai) {
		super();
		this.maHD = maHD;

		this.thueVAT = thueVAT;
		this.tongtien = tongtien;
		this.dongHo = dongHo;
		this.hoDungNuoc = hoDungNuoc;
		this.trangthai = trangthai;
	}
	public HoaDon() {
		super();
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public float getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(float thueVAT) {
		this.thueVAT = thueVAT;
	}
	public float getTongtien() {
		return tongtien;
	}
	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}
	public DongHo getDongHo() {
		return dongHo;
	}
	public void setDongHo(DongHo dongHo) {
		this.dongHo = dongHo;
	}
	public HoDungNuoc getHoDungNuoc() {
		return hoDungNuoc;
	}
	public void setHoDungNuoc(HoDungNuoc hoDungNuoc) {
		this.hoDungNuoc = hoDungNuoc;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	@Override
	public int compareTo(HoaDon o) {
		return o.dongHo.getNgaychotso().compareTo(this.dongHo.getNgaychotso());
	}
	
	
}
