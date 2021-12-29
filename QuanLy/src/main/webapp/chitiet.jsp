<%@page import="model.QuanLy"%>
<%@page import="model.HoaDonCuaKhachHang"%>
<%@page import="model.HoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thong ke danh sach</title>
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
		<h2 style="font-size:28px; text-align: center;">Thong ke khach hang theo du no</h2>
		
		<%
		HoaDonCuaKhachHang h = new HoaDonCuaKhachHang();
		h = (HoaDonCuaKhachHang) session.getAttribute("hoadoncuakh");
		%>
		<div style="display: flex;font-size:16px;font-weight:bold; justify-content: center; margin:20px 20px; ">
		
			<ul>
				<li>Ma khach hang 	: <%=h.getKhachHang().getMaKH()%></li>
				<li>Ten khach hang	: <%=h.getKhachHang().getTenKH()%></li>
				<li>Dia chi 		: <%=h.getKhachHang().getDiachi()%></li>
				<li>So dien thoai 	: <%=h.getKhachHang().getDienthoai()%></li>
			</ul>
		</div>

	</div>




	<div class="container ">
		<table class="table table-striped ">

			<thead>
				<tr>
					<th>Ma hoa don</th>
					<th>Dia chi can ho</th>
					<th>Ngay chot so</th>
					<th>Tong so nuoc</th>
					<th>Thanh tien</th>
					<th>Thue VAT</th>
					<th>Tong tien cua hoa don</th>
				</tr>

				<%
				List<HoaDon> list = h.getListHD();
				for (HoaDon hd : list) {
				%>

				<tr>
					<th><%=hd.getMaHD()%></th>
					<th><%=hd.getHoDungNuoc().getDiachi()%></th>
					<th><%=hd.getDongHo().getNgaychotso()%></th>
					<th><%=hd.getDongHo().getSonuoc()%></th>
					<th><%=hd.getTongtien()%></th>
					<th><%=hd.getThueVAT()%></th>
					<th><%=(hd.getTongtien()+hd.getThueVAT()) %></th>
				</tr>
				<%
				}
				%>
			</thead>

		</table>
		<form action="backchitiet" method="get">
			<button type="submit" class="btn btn-success">Tro ve</button>
		</form>
	</div>
</body>
</html>