/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import model.KhachHang;

/**
 *
 * @author User
 */
@WebServlet(name = "Home", urlPatterns = {"/thongke"})
public class ShowThongKe extends HttpServlet {
	
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession ses = request.getSession();
    	ThongKeTheoDuNoDAO t = new ThongKeTheoDuNoDAO();
		List<HoaDonCuaKhachHang> list = t.getHDKH();
		Collections.sort(list);
    	ses.setAttribute("listKH", list);
    	RequestDispatcher dis = request.getRequestDispatcher("thongke.jsp");
        dis.forward(request, response);
    }
}
