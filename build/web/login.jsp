<%-- 
    Document   : login1.jsp
    Created on : May 27, 2023, 2:49:21 PM
    Author     : COMPUTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <title>Đăng nhập</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="login-form/css/style.css">

    </head>
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">

                </div>
                <div class="row justify-content-center">
                    <div class="col-md-12 col-lg-10">
                        <div class="wrap d-md-flex">
                            <div class="img" style="background-image: url(login-form/images/bg-1.jpg);">
                            </div>
                            <div class="login-wrap p-4 p-md-5">
                                <div class="d-flex">
                                    <div class="w-100">
                                        <h3 class="mb-4">Đăng nhập</h3>
                                    </div>
                                    <div class="w-100">
                                        <p class="social-media d-flex justify-content-end">
                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                                            <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                                        </p>
                                    </div>
                                </div>
                                <form action="MainController" class="signin-form" method="POST">
                                    <div class="form-group mb-3">
                                        <label class="label" for="name">Tên đăng nhập:</label>
                                        <input type="text" class="form-control" placeholder="Username" name="username" required="">
                                    </div>
                                    <div class="form-group mb-3">
                                        <label class="label" for="password">Mật khẩu:</label>
                                        <input type="password" class="form-control" placeholder="Password" name="password" required="">
                                    </div>
                                    <div class="form-group mb-3" style="color: red;">
                                        ${requestScope.ERROR}
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="form-control btn btn-primary rounded submit px-3" name="action" value="Login">Đăng nhập</button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-50 text-left">
                                            <label class="checkbox-wrap checkbox-primary mb-0">Nhớ mật khẩu
                                                <input type="checkbox" checked>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <div class="w-50 text-md-right">
                                            <a href="#">Quên mật khẩu</a>
                                        </div>
                                    </div>
                                </form>
                                <div style="text-align: center">
                                    Chưa có tài khoản? <a href="register.jsp">Đăng ký nhanh</a>
                                </div>
                                <div style="text-align: center">
                                    Quay về trang chủ || <a href="MainController">Home</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="login-form/js/jquery.min.js"></script>
        <script src="login-form/js/popper.js"></script>
        <script src="login-form/js/bootstrap.min.js"></script>
        <script src="login-form/js/main.js"></script>

    </body>
</html>


