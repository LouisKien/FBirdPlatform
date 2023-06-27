

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : userProfile
    Created on : Jun 13, 2023, 1:18:21 PM
    Author     : Khanh
--%>


<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>FBird</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto:wght@700&display=swap" rel="stylesheet">  

        <!-- Icon Font Stylesheet -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <!--        Icon Cart-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--Search bar-->
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

        <script src="https://kit.fontawesome.com/39834b73e4.js" crossorigin="anonymous"></script>

    </head>

    <body>



        <!-- Navbar Start -->
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0 mb-5">
            <a href="index.jsp" class="navbar-brand ms-lg-5">
                <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>FBird</h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="wrapper" 
                 style="margin-right: 50px;
                 margin-top: 50px;
                 margin-bottom: 50px;
                 ">
                <div class="searchBar">
                    <input id="searchQueryInput" type="text" name="searchQueryInput" placeholder="Search" value="" />
                    <button id="searchQuerySubmit" type="submit" name="searchQuerySubmit">
                        <svg style="width:24px;height:24px" viewBox="0 0 24 24"><path fill="#666666" d="M9.5,3A6.5,6.5 0 0,1 16,9.5C16,11.11 15.41,12.59 14.44,13.73L14.71,14H15.5L20.5,19L19,20.5L14,15.5V14.71L13.73,14.44C12.59,15.41 11.11,16 9.5,16A6.5,6.5 0 0,1 3,9.5A6.5,6.5 0 0,1 9.5,3M9.5,5C7,5 5,7 5,9.5C5,12 7,14 9.5,14C12,14 14,12 14,9.5C14,7 12,5 9.5,5Z" />
                        </svg>
                    </button>
                </div>
            </div>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0">

                    <a href="addtocart.html" class="nav-item nav-link" style="width: max-content">
                        <i class="fa fa-shopping-cart" style="font-size:25px; "></i>
                    </a>

                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Danh mục</a>
                        <div class="dropdown-menu m-0">
                            <a href="product.html" class="dropdown-item">Sản phẩm</a>
                            <a href="food.html" class="dropdown-item">Thức ăn</a>
                            <a href="drinks.html" class="dropdown-item">Thức uống</a>
                            <a href="supplement.html" class="dropdown-item">Thực phẩm bổ sung</a>
                            <a href="medicine.html" class="dropdown-item">Thuốc</a>
                        </div>
                    </div>
                    <a href="recipe.jsp" class="nav-item nav-link">Khẩu phần</a>                    
                    <a href="login.jsp" class="nav-item nav-link">Đăng nhập</a>
                    <a href="register.jsp" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5">Đăng ký<i class="bi bi-arrow-right"></i></a>
                </div>
            </div>
        </nav>



        <div class="rts-shop-section section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-xl-3">
                        <div class="side-sticky">
                            <div class="shop-side-action">
                                <div class="action-item" >
                                    <div class="action-top">
                                        <span class="action-title"><i class="fa-sharp fa-solid fa-user"></i> Tài khoản của tôi</span>   
                                    </div>
                                    <ul style="list-style-type: none;">
                                        <li>
                                            <a href="userProfile.jsp">
                                                <div class="color-item">
                                                    <span class="color-name">Hồ sơ</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="accountShop.jsp">
                                                <div class="color-item">
                                                    <span class="color-name">Kênh người bán</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="orderCustomer.jsp">
                                                <div class="color-item">
                                                    <span class="color-name">Đơn hàng của bạn</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="thanhToan.html">
                                                <div class="color-item">
                                                    <span class="color-name">Cài đặt thanh toán</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="index.jsp">
                                                <div class="color-item">
                                                    <span class="color-name">Đăng xuất</span>
                                                </div>
                                            </a>
                                        </li>

                                    </ul>






                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-9" style="border: 2px solid; border-radius: 10px; width: 800px; margin: 10px;">


                        <div class="row g-3 my-2">
                        <div class="col-md-3">
                            
                            <a href="#" class="btn btn-primary" style="text-decoration: none; color: black; border: 2px groove;">

                                Tất cả


                            </a>
                            
                        </div>

                        <div class="col-md-3">
                            <a href="#"  class="btn btn-primary" style="text-decoration: none; color: black; border: 2px groove;">
                                Đã giao
                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="#" class="btn btn-primary" style="text-decoration: none; color: black; border: 2px groove;" >
                                Đã hủy
                            </a>
                        </div>
                        
                            
                        <div class="col-md-3">
                            <a href="#" class="btn btn-primary" style="text-decoration: none; color: black; border: 2px groove;" >
                                Chờ xác nhận
                            </a>
                        </div>

                    </div>
                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" width="50">#</th>
                                        <th scope="col">Sản phẩm</th>
                                        
                                        <th scope="col">Giá</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Thời gian</th>
                                        <th scope="col">Vận chuyển</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Cám chim 1</td>
                                        
                                        <td>$1200</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Cám chim 2</td>
                                        
                                        <td>$750</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Cám chim 3</td>
                                        
                                        <td>$600</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">4</th>
                                        <td>Cám chim 4</td>
                                        
                                        <td>$300</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">5</th>
                                        <td>Cám chim 5</td>
                                        
                                        <td>$120</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">6</th>
                                        <td>Cám chim 6</td>
                                        
                                        <td>$1800</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">7</th>
                                        <td>Cám chim 7</td>
                                        
                                        <td>$75</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">8</th>
                                        <td>Cám chim 8</td>
                                        
                                        <td>$36</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">9</th>
                                        <td>Cám chim 9</td>
                                        
                                        <td>$255</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">10</th>
                                        <td>Cám chim 10</td>
                                        
                                        <td>$434</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">11</th>
                                        <td>Cám chim 11</td>
                                        
                                        <td>$1236</td>
                                        <td>Đã giao</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">12</th>
                                        <td>Cám chim 12</td>
                                        
                                        <td>$422</td>
                                        <td>Đã hủy</td>
                                        <td>1/1/2023</td>
                                        <td>Hỏa tốc</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>
            </div>
        </div>










        <div class="container-fluid border-bottom d-none d-lg-block">
            <!-- Topbar End -->
            <!-- Footer Start -->
            <div class="container-fluid bg-light mt-5 py-5">
                <div class="container pt-5">
                    <div class="row g-5">
                        <div class="col-lg-3 col-md-6">
                            <h5 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">PHƯƠNG THỨC LIÊN LẠC</h5>
                            <p class="mb-4"></p>
                            <p class="mb-2"><i class="bi bi-geo-alt text-primary me-2"></i>Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</p>
                            <p class="mb-2"><i class="bi bi-envelope-open text-primary me-2"></i>daihoc.hcm@fpt.edu.vn</p>
                            <p class="mb-0"><i class="bi bi-telephone text-primary me-2"></i> (028) 7300 5588</p>
                        </div>

                        <div class="col-lg-3 col-md-6">
                            <h5 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">FBird</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-body mb-2" href="index.jsp"><i class="bi bi-arrow-right text-primary me-2"></i>Trang chủ</a>

                                <a class="text-body mb-2" href="member.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thành viên</a>


                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <h5 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">Loại hàng cho chim</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-body mb-2" href="food.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thức ăn</a>
                                <a class="text-body mb-2" href="drinks.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thức uống</a>
                                <a class="text-body mb-2" href="supplement.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thực phẩm bổ sung</a>
                                <a class="text-body mb-2" href="medicine.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thuốc</a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <h5 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">Phản hồi đến công ty chúng tôi</h5>
                            <form action="">
                                <div class="input-group">
                                    <input type="text" class="form-control p-3" placeholder="Nhập email">
                                    <button class="btn btn-primary">Đăng ký</button>
                                </div>
                            </form>
                            <h6 class="text-uppercase mt-4 mb-3"> Theo dõi chúng tôi trên</h6>
                            <div class="d-flex">
                                <a class="btn btn-outline-primary btn-square me-2" href="#"><i class="bi bi-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square me-2" href="#"><i class="bi bi-facebook"></i></a>
                                <a class="btn btn-outline-primary btn-square me-2" href="#"><i class="bi bi-linkedin"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="bi bi-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-fluid bg-dark text-white-50 py-4">
                <div class="container">
                    <div class="row g-5">
                        <div class="col-md-6 text-center text-md-start">
                            <p class="mb-md-0">&copy; <a class="text-white" href="index.jsp">Trang web được thiết kế bởi nhóm 3 </a> </p>
                        </div>
                        <div class="col-md-6 text-center text-md-end">
                            <p class="mb-0">Nguồn <a class="text-white" href="https://htmlcodex.com">HTML Codex</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
    </body>

</html> 


<style>
    .p-3 .bg-white .shadow-sm .d-flex .justify-content-around .align-items-center .rounded .fw-bold:hover{
        background-color: green;
        color: white;
    }
    .avatar{


        border-radius: 50%;
        -moz-border-radius:50%;
        -webkit-border-radius: 50%;
    }

    .button:hover{
        background-color: #67f528;
    }
    .button{
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 10px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }

    body {
        font-family: 'Roboto', Arial, sans-serif;
    }

    .wrapper {
        width: 100%;
        max-width: 31.25rem;
        /*  margin: 6rem auto;*/
        margin-right: 50px;
        margin-top: 50px;
        margin-bottom: 50px;
    }

    .label {
        font-size: .625rem;
        font-weight: 400;
        text-transform: uppercase;
        letter-spacing: +1.3px;
        margin-bottom: 1rem;
    }

    .searchBar {
        width: 111%;
        display: flex;
        flex-direction: row;
        /*align-items: center;*/
    }

    #searchQueryInput {
        width: 100%;
        height: 2.8rem;
        background: #f5f5f5;
        outline: none;
        border: none;
        border-radius: 1.625rem;
        padding: 0 3.5rem 0 1.5rem;
        font-size: 1rem;
    }

    #searchQuerySubmit {
        width: 3.5rem;
        height: 2.8rem;
        margin-left: -3.5rem;
        background: none;
        border: none;
        outline: none;
    }

    #searchQuerySubmit:hover {
        cursor: pointer;
    }
    .navbar-light .navbar-nav .nav-link {
        font-family: 'Roboto', sans-serif;
        position: relative;
        margin-left: 30px;
        padding: 30px 0;
        font-size: 18px;
        font-weight: 700;
        text-transform: uppercase;
        color: var(--dark);
        outline: none;
        transition: .5s;
        width: max-content;
    }
</style>

