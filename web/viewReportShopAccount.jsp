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
                    <li><a class="dropdown-item" style="width: 239px;" href="viewReportShopAccount.jsp">Xem báo cáo tài khoản</a></li>
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

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Danh sách báo cáo (Cửa hàng)</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>


                </nav>

                <div class="container-fluid px-4">

                    <div class="row my-5">
                        <!--                        <h3 class="fs-4 mb-3">Ngày đặt hàng</h3>-->
                        <div class="col">
                            <div class="container" style="display: grid; grid-template-rows: repeat(4,0fr); gap:10px;">
                               

                                <table class="table bg-white rounded shadow-sm  table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col" width="50">#</th>
                                            <th scope="col">Tên đăng nhập</th>
                                            <th scope="col">Cảnh cáo từ Admin</th>
                                            <th scope="col">Ngày cảnh cáo</th>
                                            <th scope="col">Phản hồi từ Shop</th>
                                            <th scope="col">Ngày phản hồi</th>
                                            <th scope="col"> </th>
                                        </tr>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>yasuoNguyen</td>
                                            <td>Bán hàng fake ( khóa 7 ngày)</td>
                                            <td>1/1/2024</td>
                                            <td>Gửi admin, xin lỗi về vấn đề này</td>        
                                            <td>2/1/2024</td>
                                            <th><input type="submit" value="Khóa tài khoản" class="fw-bold" style="text-decoration: none; color: black;"/></th>
                                        </tr>
                                    </tbody>
                                    </thead>
                                </table>


                            </div>



                        </div>


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

<style>
    .switch {
        position: relative;
        display: inline-block;
        width: 60px;
        height: 34px;
    }

    .switch input {
        opacity: 0;
        width: 0;
        height: 0;
    }

    .slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
    }

    .slider:before {
        position: absolute;
        content: "";
        height: 26px;
        width: 26px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
    }

    input:checked + .slider {
        background-color: #2196F3;
    }

    input:focus + .slider {
        box-shadow: 0 0 1px #2196F3;
    }

    input:checked + .slider:before {
        -webkit-transform: translateX(26px);
        -ms-transform: translateX(26px);
        transform: translateX(26px);
    }

    /* Rounded sliders */
    .slider.round {
        border-radius: 34px;
    }

    .slider.round:before {
        border-radius: 50%;
    }
</style>
