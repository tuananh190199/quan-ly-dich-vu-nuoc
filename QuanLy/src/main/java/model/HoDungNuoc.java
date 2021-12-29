package model;

public class HoDungNuoc {
	private String diachi;
	KhachHang khachHang;
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public HoDungNuoc(String diachi, KhachHang khachHang) {
		super();
		this.diachi = diachi;
		this.khachHang = khachHang;
	}
	public HoDungNuoc() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
