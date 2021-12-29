package model;

import java.util.ArrayList;
import java.util.List;

public class HoaDonCuaKhachHang implements Comparable<HoaDonCuaKhachHang>{
	private List<HoaDon> listHD = new ArrayList<HoaDon>();
	private KhachHang khachHang;
	private int tongHDchuathanhtoan;
	private float tongtienchuathanhtoan;
	public HoaDonCuaKhachHang(List<HoaDon> listHD, KhachHang khachHang, int tongHDchuathanhtoan,
			float tongtienchuathanhtoan) {
		super();
		this.listHD = listHD;
		this.khachHang = khachHang;
		this.tongHDchuathanhtoan = tongHDchuathanhtoan;
		this.tongtienchuathanhtoan = tongtienchuathanhtoan;
	}
	public HoaDonCuaKhachHang() {
		super();
	}
	public List<HoaDon> getListHD() {
		return listHD;
	}
	public void setListHD(List<HoaDon> listHD) {
		this.listHD = listHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public int getTongHDchuathanhtoan() {
		return tongHDchuathanhtoan;
	}
	public void setTongHDchuathanhtoan(int tongHDchuathanhtoan) {
		this.tongHDchuathanhtoan = tongHDchuathanhtoan;
	}
	public float getTongtienchuathanhtoan() {
		return tongtienchuathanhtoan;
	}
	public void setTongtienchuathanhtoan(float tongtienchuathanhtoan) {
		this.tongtienchuathanhtoan = tongtienchuathanhtoan;
	}
	@Override
	public int compareTo(HoaDonCuaKhachHang o) {
		if(this.tongtienchuathanhtoan>o.tongtienchuathanhtoan) return -1;
		else return 1;
	}
	

}
