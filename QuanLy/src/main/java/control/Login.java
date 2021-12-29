package control;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.QuanLy;

@WebServlet(name = "Login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	LoginDao loginDao = new LoginDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "");
		RequestDispatcher dis = req.getRequestDispatcher("indext.jsp");
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			QuanLy quanly = loginDao.checkLogin(username, password);

			if (quanly != null) {
				HttpSession ses = req.getSession();
				ses.setAttribute("quanly", quanly);
				RequestDispatcher dis = req.getRequestDispatcher("trangchu.jsp");
				dis.forward(req, resp);
			} else {
				req.setAttribute("message", "Sai tai khoan hoac mat khau");
				RequestDispatcher dis = req.getRequestDispatcher("indext.jsp");
				dis.forward(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
