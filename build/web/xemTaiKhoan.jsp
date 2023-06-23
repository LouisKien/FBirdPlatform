<!DOCTYPE html>
<html lang="vi">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <title>ban hang</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="dashboard-shop/styles.css" />

    </head>

    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar -->

            <div class="bg-white" id="sidebar-wrapper" style="width: 260px;">
                <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
                    <i class="fas fa-solid fa-dove " ></i>
                    <a href="index.html" class="home-link" style="color: #009d63; text-decoration: none; ">Fbird
                    </a>
                </div>


                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-solid fa-truck me-2"></i>Quản lý tài khoản
                </a>
                <ul class="dropdown-menu" aria-labelledby="adminDropdown">

                    <li><a class="dropdown-item" style="width: 239px;" href="xemTaiKhoan.jsp">Xem tài khoản</a></li>
                    <li><a class="dropdown-item" style="width: 239px;" href="xoaTaiKhoan.jsp">Xóa tài khoản</a></li>
                </ul>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="adminDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-regular fa-briefcase me-2"></i>Cài đặt sản phẩm
                </a>
                <ul class="dropdown-menu" aria-labelledby="adminDropdown">

                    
                    <li><a class="dropdown-item" style="width: 239px;" href="loaiChim.jsp">Loại chim</a></li>
                    <li><a class="dropdown-item" style="width: 239px;" href="sanPhamKhieuNai.jsp">Sản phẩm khiếu nại</a></li>
                </ul>


            </div>
            <!-- /#sidebar-wrapper -->
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Kiểm tra tài khoản</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>


                </nav>

                <div class="container-fluid px-4">
                    <div class="row g-3 my-2">
                        <div class="col-md-3">
                            <a href="xemTatCaTaiKhoan.jsp" class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded fw-bold" style="text-decoration: none; color: black;">

                                Tất cả


                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="xemNguoiDung.jsp"  class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded fw-bold" style="text-decoration: none; color: black;">
                                Người dùng 
                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="xemBanHang.jsp" class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded fw-bold" style="text-decoration: none; color: black;" >
                                Cửa hàng
                            </a>
                        </div>
                    </div>

                    <div class="row my-5">
                        <h3 class="fs-4 mb-3">Tìm kiếm tài khoản:</h3>
                        <form action="/search" method="GET">
                            <input type="text" name="query" placeholder="Nhập tên đăng nhập">
                            <button type="submit">Tìm kiếm</button>
                        </form>
                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" width="50">#</th>
                                        <th scope="col">Tên đăng nhập</th>
                                        <th scope="col">Phân quyền</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">SĐT</th>
                                        <th scope="col">Thời gian tạo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>tuanguyen</td>
                                        <td>Người dùng</td>
                                        <td>tuangnguyen@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0123456789</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>namnguyen</td>
                                        <td>Người dùng</td>
                                        <td>namnguyen@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0123465789</td>
                                        <td>11/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>lannguyen</td>
                                        <td>Người dùng</td>
                                        <td>lannguyen@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0123456789</td>
                                        <td>12/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">4</th>
                                        <td>lynguyen</td>
                                        <td>Người dùng</td>
                                        <td>lynguyen@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0321654987</td>
                                        <td>16/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">5</th>
                                        <td>khanhnguyen</td>
                                        <td>Người dùng</td>
                                        <td>khanhnnguyen@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0123456897</td>
                                        <td>15/5/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">6</th>
                                        <td>kientran</td>
                                        <td>Người dùng</td>
                                        <td>kientran@gmail.com</td>
                                        <td>Hoạt động</td>
                                        <td>0321654987</td>
                                        <td>12/3/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">7</th>
                                        <td>duypham</td>
                                        <td>Bán hàng</td>
                                        <td>duypham@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>6549873210</td>
                                        <td>21/6/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">8</th>
                                        <td>namtran</td>
                                        <td>Bán hàng</td>
                                        <td>namtran@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>3217896540</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">9</th>
                                        <td>kinhpham</td>
                                        <td>Bán hàng</td>
                                        <td>kinhpham@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>3217896540</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">10</th>
                                        <td>johnpham</td>
                                        <td>Bán hàng</td>
                                        <td>johnpham@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>3217896540</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">11</th>
                                        <td>jeconguyen</td>
                                        <td>Bán hàng</td>
                                        <td>jeconguyen@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>3217896540</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">12</th>
                                        <td>yasuonguyen</td>
                                        <td>Bán hàng</td>
                                        <td>yasuonguyen@gmail.com</td>
                                        <td>Đã khóa</td>
                                        <td>3217896540</td>
                                        <td>1/1/2023</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
    </script>
</body>

</html>
