<%-- 
    Document   : login
    Created on : Nov 19, 2021, 8:48:21 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dang nhap</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1 style="text-align: center; font-weight: bold;"> HE THONG QUAN LY DICH VU CUA CONG TY NUOC SACH</h1>
        <br>
        <h2 style="text-align: center; color: blue; font-weight: bold;">Dang nhap vao he thong</h2>
        <form class="form-horizontal" style="margin-top: 100px; margin-left: 400px;" action="login" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="username"
                           placeholder="Username" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputPassword"
                           placeholder="Password" name="password">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <p  style="color: red"></p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                	<p style = "color: red">${message}</p>
                    <button type="submit" class="btn btn-success">Sign in</button>
                </div>
            </div>
        </form>
    </body>
</html>
