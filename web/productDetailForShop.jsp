<%@page import="fbird.category.CategoryDTO"%>
<%@page import="fbird.typeofbird.TypeOfBirdDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="vi">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <title>Shop Dashboard</title>
        <link rel="icon" href="img/logo-shop.PNG" type="image/png">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="dashboard-shop/styles.css" />

    </head>

    <body>
        <div class="d-flex" id="wrapper">
            <script src="scss/tinymce/tinymce.min.js"></script>
            <!-- Sidebar -->
            <div class="bg-white" id="sidebar-wrapper" style="width: 260px;">
                <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
                    <i class="fas fa-solid fa-dove " ></i>
                    <a href="MainController" class="home-link" style="color: #009d63; text-decoration: none; ">Fbird
                    </a>
                </div>
                <!--------------------------------------------------------------------------------------------------------------------------------------------------------->

                <div class="list-group list-group-flush my-3">
                    <a href="accountShop.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-tachometer-alt me-2"></i>Thống kê</a>
                    <!--------------------------------------------------------------------------------------------------------------------------------------------------------->

                    <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="profileDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-solid fa-truck me-2"></i>Vận chuyển
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="profileDropdown">

                        <li><a class="dropdown-item" style="width: 239px;" href="deliveryManagement.jsp">Quản lý vận chuyển</a></li>
                        <li><a class="dropdown-item" style="width: 239px;" href="settingDeliveries.jsp">Cài đặt vận chuyển</a></li>
                    </ul>
                    <!--------------------------------------------------------------------------------------------------------------------------------------------------------->                            
                    <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="profileDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-regular fa-briefcase me-2"></i>Quản lý đơn hàng
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="profileDropdown">

                        <li><a class="dropdown-item" style="width: 239px;" href="tatCaDonHang.jsp">Tất cả đơn</a></li>
                        <li><a class="dropdown-item" style="width: 239px;" href="donHuy.jsp">Đơn hủy</a></li>
                    </ul>
                    <!--------------------------------------------------------------------------------------------------------------------------------------------------------->
                    <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="profileDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-regular fa-cube me-2"></i>Quản lý sản phẩm
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="profileDropdown">

                        <li><a class="dropdown-item" style="width: 239px;" href="MainController?action=ViewProduct&shop_id=${sessionScope.LOGIN_USER.getShop_id()}">Tất cả sản phẩm</a></li>
                        <li><a class="dropdown-item" style="width: 239px;" href="sanPhamViPham.jsp">Sản phẩm vi phạm</a></li>
                        <li><a class="dropdown-item" style="width: 239px;" href="MainController?action=ViewCreateProduct">Thêm sản phẩm</a></li>
                    </ul>
                    <!--------------------------------------------------------------------------------------------------------------------------------------------------------->
                    <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold dropdown-toggle" id="profileDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-solid fa-store me-2"></i>Quản lý cửa hàng
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="profileDropdown">

                        <li><a class="dropdown-item" style="width: 239px;" href="danhGiaShop.jsp">Đánh giá shop</a></li>
                        <li><a class="dropdown-item" style="width: 239px;" href="hoSoShop.jsp">Hồ sơ shop</a></li>

                    </ul>
                    <!--------------------------------------------------------------------------------------------------------------------------------------------------------->


                </div>
            </div>
            <!-- /#sidebar-wrapper -->
            
            <!-- Page Content -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Cập nhật sản phẩm</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown"
                                   role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-user me-2"></i>${sessionScope.LOGIN_USER.getFullname()}
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                                    <li><a class="dropdown-item" href="hoSoShop.jsp">Hồ sơ</a></li>
                                    <li><a class="dropdown-item" href="MainController?action=Logout">Đăng xuất</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>

                <div class="container-fluid px-4">

                    <div class="row my-5">
                        <!--                        <h3 class="fs-4 mb-3">Ngày đặt hàng</h3>-->
                        <form action="MainController">
                            <div class="col">
                                <div class="container" style="display: grid; grid-template-rows: repeat(4,0fr); gap:10px;">
                                    <label for="productName" style="font-size: 18px; font-weight: bold;" >Tên sản phẩm:  </label> <input type="text" id="productName" name="productName" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="typeOfBird" style="font-size: 18px; font-weight: bold;">Dành cho chim: </label> 
                                    <select id="typeOfBird" name="typeOfBird" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;">
                                        <option value="">Loại chim</option>
                                       
                                    </select>
                                    <label for="typeProduct" style="font-size: 18px; font-weight: bold;">Loại hàng:</label>
                                    <select id="typeProduct" name="typeProduct" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;">
                                        <option value="">Loại hàng</option>
                                        
                                    </select>
                                    <span style="font-size: 18px; font-weight: bold;">Ảnh sản phẩm:</span> <input type="file" name="productImage" id="productImage" accept="image/*">
                                        <script>
                                            tinymce.init({
                                                selector: '#productImage'
                                            });
                                                </script>
                                    <label for="inventory" style="font-size: 18px; font-weight: bold;" >Số lượng sản phẩm:  </label> <input type="text" id="productName" name="inventory" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="description" style="font-size: 18px; font-weight: bold;">Mô tả sản phẩm:</label> <input type="text" id="description" name="description" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <span style="font-size: 18px; font-weight: bold;">---------------------------------------------------Tùy chọn--------------------------------------------------------</span>
                                    <label for="option1" style="font-size: 18px; font-weight: bold;">Tùy chọn 1:</label> <input type="text" id="description" name="option1" placeholder="Nhập tùy chọn" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="priceOption1" style="font-size: 18px; font-weight: bold;">Giá tùy chọn 1:</label> <input type="number" id="description" name="priceOption1" placeholder="Nhập giá" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="option2" style="font-size: 18px; font-weight: bold;">Tùy chọn 2:</label> <input type="text" id="description" name="option2" placeholder="Nhập tùy chọn" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="priceOption2" style="font-size: 18px; font-weight: bold;">Giá tùy chọn 2:</label> <input type="number" id="description" name="priceOption2" placeholder="Nhập giá" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="option3" style="font-size: 18px; font-weight: bold;">Tùy chọn 3:</label> <input type="text" id="description" name="option3" placeholder="Nhập tùy chọn" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="priceOption3" style="font-size: 18px; font-weight: bold;">Giá tùy chọn 3:</label> <input type="number" id="description" name="priceOption3" placeholder="Nhập giá" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="option4" style="font-size: 18px; font-weight: bold;">Tùy chọn 4:</label> <input type="text" id="description" name="option4" placeholder="Nhập tùy chọn" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="priceOption4" style="font-size: 18px; font-weight: bold;">Giá tùy chọn 4:</label> <input type="number" id="description" name="priceOption4" placeholder="Nhập giá" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="option5" style="font-size: 18px; font-weight: bold;">Tùy chọn 5:</label> <input type="text" id="description" name="option5" placeholder="Nhập tùy chọn" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    <label for="priceOption5" style="font-size: 18px; font-weight: bold;">Giá tùy chọn 5:</label> <input type="number" id="description" name="priceOption5" placeholder="Nhập giá" style="border-radius: 10px; margin-bottom: 1%; width: 70%; height: 50px; font-size: 20px; margin-left: 5%;"></br>
                                    </div>



                                </div>


                                <button type="submit" name="action" value="Create Product" class="btn btn-primary" style="margin-top: 30px; border-radius: 20px;">Cập nhật</button>
                                <!--<input type="button" name="action" value="Create" style="margin-top: 30px; border-radius: 20px;/>-->
                        </form>
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
    // function add ảnh ở dưới 
    function onFileSelect(event) {
        var file = event.target.files[0];
        var reader = new FileReader();

        reader.onload = function () {
            var image = document.getElementById("productImage");
            image.src = reader.result;
        };

        reader.readAsDataURL(file);
    }

    document.getElementById("productImage").addEventListener("change", onFileSelect);

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

