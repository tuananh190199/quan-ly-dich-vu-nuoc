package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.DongHo;
import model.HoDungNuoc;
import model.HoaDon;
import model.HoaDonCuaKhachHang;
import model.KhachHang;
import model.QuanLy;

public class ThongKeTheoDuNoDAO extends dao {

	public static List<KhachHang> getDSKHduno() {
		List<KhachHang> list = new ArrayList<KhachHang>();
		String query1 = "select DISTINCT khachhang.maKH,khachhang.tenKH,khachhang.diachi, khachhang.dienthoai from \r\n"
				+ "khachhang left JOIN hoadon on khachhang.maKH = hoadon.maKH\r\n" + "where trangthai = 'chua';";
		try {
			Connection connection = dao.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			while (rs.next()) {
				KhachHang k = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<HoaDonCuaKhachHang> getHDKH() {
		List<HoaDonCuaKhachHang> list = new ArrayList<HoaDonCuaKhachHang>();
		ThongKeTheoDuNoDAO t = new ThongKeTheoDuNoDAO();
		List<KhachHang> listKH = t.getDSKHduno();
		for (KhachHang k : listKH) {
			String query = "select * from hoadon inner join dongho on hoadon.maDH = dongho.maDH"
					+ " where hoadon.trangthai = 'chua' and hoadon.maKH=?;";
			List<HoaDon> listHD = new ArrayList<HoaDon>();
			int tonghoadon = 0;
			float tongtien = 0;
			try {
				Connection connection = dao.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, k.getMaKH());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					tonghoadon ++;
					int sonuoc = rs.getInt("sonuoc");
					float tien = tinhtien(sonuoc);
					tongtien += tien;
					float thueVAT = tongtien / 10;
					tongtien+=thueVAT;
					HoaDon h = new HoaDon();
					DongHo dongho = new DongHo(rs.getInt("sonuoc"),rs.getDate("ngaybatdau"),rs.getDate("ngaychotso"));
					HoDungNuoc hodungnuoc = getHoDungNuoc(rs.getInt("maHDN"));
					h.setMaHD(rs.getInt(1));
					h.setThueVAT(thueVAT);
					h.setTongtien(tien);
					h.setTrangthai("chua thanh toan");
					h.setDongHo(dongho);
					h.setHoDungNuoc(hodungnuoc);
					listHD.add(h);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Collections.sort(listHD);
			HoaDonCuaKhachHang hoaDonCuaKhachHang = new HoaDonCuaKhachHang(listHD, k, tonghoadon, tongtien);
			list.add(hoaDonCuaKhachHang);
		}
		Collections.sort(list);
		return list;
	}

	public static float tinhtien(int sonuoc) {
		float tongtien = sonuoc*2000;
		if (sonuoc <= 100) {
			tongtien = sonuoc * 2000;
		} else {
			sonuoc -= 100;
			if (sonuoc <= 100) {
				tongtien = 100 * 2000 + sonuoc * 3000;
			} else {
				sonuoc -= 100;
				tongtien = 100 * 2000 + 100 * 3000 + sonuoc * 4000;
			}
		}
		return tongtien;
	}

	public static HoDungNuoc getHoDungNuoc(int maHDN) {
		String query = "select * from hodungnuoc where maHDN = ?";
		HoDungNuoc hoDungNuoc = new HoDungNuoc();
		try {
			Connection connection = dao.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, maHDN);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hoDungNuoc.setDiachi(rs.getString("diachi"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoDungNuoc;
	}
	
	public static void main(String[] args) {
		ThongKeTheoDuNoDAO t = new ThongKeTheoDuNoDAO();
		List<HoaDonCuaKhachHang> list = t.getHDKH();
		for(HoaDonCuaKhachHang hd : list) {
			List<HoaDon> listhoadon = hd.getListHD();
			for(HoaDon h : listhoadon) {
				System.out.println(h.getHoDungNuoc());
			}
		}
	}
}
