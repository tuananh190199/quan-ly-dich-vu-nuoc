<%@page import="model.HoaDonCuaKhachHang"%>
<%@page import="model.QuanLy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.KhachHang"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thong ke khach hang theo du no</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<form action="trangchu" method="get">
				<div class="navbar-header">
					<a class="navbar-brand" href="trangchu.jsp">HE THONG QUAN LY
						DICH VU CUA CONG TY NUOC SACH</a>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="trangchu.jsp"><form action="trangchu" method="get"><span class="glyphicon glyphicon-home"></span>Trang chu</form></a>
					</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <span
						class="glyphicon glyphicon-th-list"></span> Chuc nang<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a><form action="thongke" method="get">
									<button type="submit">Thong ke cac khach hang theo du
										no</button>
								</form></a></li>
					</ul></li>
				<li>
					<%
					QuanLy quanly = new QuanLy();
					quanly = (QuanLy) session.getAttribute("quanly");
					%> <a href="#"><span class="glyphicon glyphicon-user"><%=quanly.getUsername()%></span>
				</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Thong ke cac khach hang theo du no</h2>

	</div>
	<div class="container ">
		<table class="table table-striped ">
			<thead>
				<tr>
					<th>Ma khach hang</th>
					<th>Ten khach hang</th>
					<th>Dia chi</th>
					<th>Dien thoai</th>
					<th>Tong so hoa don chua thanh toan</th>
					<th>Tong so tien chua thanh toan</th>
				</tr>


				<%
				List<HoaDonCuaKhachHang> list = new ArrayList<HoaDonCuaKhachHang>();
				list = (ArrayList<HoaDonCuaKhachHang>) session.getAttribute("listKH");
				for (HoaDonCuaKhachHang k : list) {
				%>

				<tr>

					<th><%=k.getKhachHang().getMaKH()%></th>
					<th><%=k.getKhachHang().getTenKH()%></th>
					<th><%=k.getKhachHang().getDiachi()%></th>
					<th><%=k.getKhachHang().getDienthoai()%></th>
					<th><%=k.getTongHDchuathanhtoan()%></th>
					<th><%=k.getTongtienchuathanhtoan()%></th>
					<td><form action="chitiet" method="get">
							<a href="chitiet?idKH=<%=k.getKhachHang().getMaKH()%>">Xem Chi Tiet</a>
						</form></td>
				</tr>
			</thead>
			<%
			}
			%>

		</table>
		<form action="backtrangchu" method="get">
			<button type="submit" class="btn btn-success">Tro ve</button>
		</form>
	</div>
</body>
</html>