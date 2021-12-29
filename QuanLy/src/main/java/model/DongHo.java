package model;

import java.util.Date;

public class DongHo{
	private int sonuoc;
	private Date ngaybatdau,ngaychotso;
	public DongHo(int sonuoc, Date ngaybatdau, Date ngaychotso) {
		super();
		this.sonuoc=sonuoc;
		this.ngaybatdau = ngaybatdau;
		this.ngaychotso = ngaychotso;
	}
	public DongHo() {
		super();
	}
	public int getSonuoc() {
		return sonuoc;
	}
	public void setChisocu(int sonuoc) {
		this.sonuoc = sonuoc;
	}
	
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public Date getNgaychotso() {
		return ngaychotso;
	}
	public void setNgaychotso(Date ngaychotso) {
		this.ngaychotso = ngaychotso;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
