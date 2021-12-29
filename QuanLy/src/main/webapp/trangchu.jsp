<%@page import="model.QuanLy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang chu</title>
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
						<!-- 					<li><a><form action="thongke" method="get"><button type="submit">
						Quan ly loai hop dong</button></form></a></li>
						<li><a><form action="thongke" method="get"><button type="submit">
						Them hop dong</button></form></a></li>
						<li><a><form action="thongke" method="get"><button type="submit">
						Nhap so dong ho hang thang</button></form></a></li>
						<li><a><form action="thongke" method="get"><button type="submit">
						Thanh toan</button></form></a></li>
						
						<li><a><form action="thongke" method="get"><button type="submit">
						Thong ke cac khach hang theo muc tieu thu</button></form></a></li>
						<li><a><form action="thongke" method="get"><button type="submit">
						Theo doi luong tieu thu theo thoi gian</button></form></a></li>
	-->


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
		<h3>He thong quan ly dich vu nuoc cua cong ty nuoc sach song Da </h3>
		<p>Ung dung ho tro quan ly cac ho dung nuoc, tinh tien nuoc cho ho
			ca nhan, theo doi danh sach cac ho dung nuoc</p>
	</div>
</body>
</html>