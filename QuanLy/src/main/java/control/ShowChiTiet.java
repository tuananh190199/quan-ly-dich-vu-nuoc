package control;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ThongKeTheoDuNoDAO;
import model.HoaDonCuaKhachHang;


@WebServlet(name = "chitiet", urlPatterns = { "/chitiet" })
public class ShowChiTiet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int maKH = Integer.parseInt(req.getParameter("idKH"));
		ThongKeTheoDuNoDAO t = new ThongKeTheoDuNoDAO();
		List<HoaDonCuaKhachHang> list = t.getHDKH();
		HoaDonCuaKhachHang hdckh = new HoaDonCuaKhachHang();
		for(HoaDonCuaKhachHang h :list) {
			if(h.getKhachHang().getMaKH()==maKH) {
				hdckh=h;
			}
		}
		HttpSession ses = req.getSession();
		ses.setAttribute("hoadoncuakh", hdckh);
		RequestDispatcher dis = req.getRequestDispatcher("chitiet.jsp");
		dis.forward(req, resp);
	}
}
