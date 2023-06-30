<%-- 
    Document   : index
    Created on : Jun 27, 2023, 1:13:29 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fbird.product.ProductDTO"%>
<%@page import="fbird.recipe.RecipeDTO"%>
<%@page import="fbird.user.UserDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fbird</title>
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
            <a href="MainController" class="navbar-brand ms-lg-5">
                <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>FBird</h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="wrapper" 
                 style="
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

                    <div class="nav-item nav-link" style="width: max-content">
                        <a  href="addtocartv2.jsp"class="shopping">
                            <i class="fa fa-shopping-cart" style="font-size:25px;"></i>
                            <span class="quantity">0</span>
                        </a>
                    </div>


                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Danh mục</a>
                        <div class="dropdown-menu m-0">
                            <a href="product.jsp" class="dropdown-item">Sản phẩm</a>
                            <a href="food.jsp" class="dropdown-item">Thức ăn</a>
                            <a href="drinks.jsp" class="dropdown-item">Thức uống</a>
                            <a href="supplement.jsp" class="dropdown-item">Thực phẩm bổ sung</a>
                            <a href="medicine.jsp" class="dropdown-item">Thuốc</a>
                        </div>
                    </div>
                    <a href="recipe.jsp" class="nav-item nav-link">Khẩu phần</a>                      
                    <a href="userProfile.jsp" class="nav-item nav-link"><i class="fa-solid fa-user"></i></a>
                    <a href="adminDashboard.jsp" class="nav-item nav-link"><i class="fa-solid fa-user-gear"></i></a>
                        <%
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if(loginUser != null) {
            
                        %>
                    <div class="nav-item dropdown"> 
                        <a href="#" class="nav-item nav-link nav-contact bg-primary text-white px-3 ms-lg-3" data-bs-toggle="dropdown"><%= loginUser.getFullname() %></a>
                        <div class="dropdown-menu m-3">
                            <a href="product.jsp" class="dropdown-item">View Profile</a>
                            <a href="MainController?action=Logout" class="dropdown-item">LOG OUT</a>
                        </div>
                    </div>
                    <%}else{%>
                    <a href="login.jsp" class="nav-item nav-link">Đăng nhập</a>
                    <a href="register.jsp" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5">Đăng ký<i class="bi bi-arrow-right"></i></a>
                        <%}%>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->


        <!-- Hero Start -->
        <div class="container-fluid bg-primary py-5 mb-5 hero-header">
            <div class="container py-5">
                <div class="row gx-5 justify-content-start">
                    <div class="col-lg-7" >

                        <div class="border-start border-5 border-dark ps-5 mb-5" style="
                             background: rgba(0,0,0,0.4);
                             border-radius: 10px;
                             background-clip: padding-box; color:#000;
                             ">


                            <h1 class="display-5 text-uppercase text-white mb-0" >Giảm giá lên đến 50% cho đơn đầu tiên</h1>
                        </div>

                        <a href="product.jsp" class="btn btn-light py-md-3 px-md-5 me-3">Xem thêm</a>
                        <!--                        <a href="" class="btn btn-outline-light py-md-3 px-md-5">Read More</a>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- comment -->

        <div class="container-fluid py-5">
            <div class="container">
                <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                    <h6 class="text-primary text-uppercase">Sản phẩm bán chạy</h6>
                    <h1 class="display-5 text-uppercase mb-0">Gợi ý cho bạn</h1>
                </div>
                <div class="owl-carousel product-carousel">
                    <% 
            List<ProductDTO> listProductHomePage = (List<ProductDTO>) request.getAttribute("LIST_ProductHomePage");
           
            if (listProductHomePage != null && !listProductHomePage.isEmpty()) {
          
                for (ProductDTO listPHP : listProductHomePage) { 
               
                    %>
                    <div class="pb-5">
                        <div class="product-item position-relative bg-light d-flex flex-column text-center">
                            <img class="img-fluid mb-4" src="<%=listPHP.getImage_1() %>" alt="">
                            <h6 class="text-uppercase"><%=listPHP.getTitle() %></h6>
                            <h5 class="text-primary mb-0"><%=listPHP.getPrice() %></h5>
                            <div class="btn-action d-flex justify-content-center">
                                <a class="btn btn-primary py-2 px-3" href="addtocart.html"><i class="bi bi-cart"></i></a>
                                <a class="btn btn-primary py-2 px-3" href="MainController?action=ViewProductDetail&shop_product_item_id=<%=listPHP.getShopProductItemID() %>&shop_id=<%=listPHP.getShopID() %>"><i class="bi bi-eye"></i></a>
                            </div>
                        </div>
                    </div>

                    <% 
}
               
}
                    %>
                </div>
            </div>
        </div>

        <!-- comment -->
        <div class="container-fluid py-5">
            <div class="container">
                <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
                    <h6 class="text-primary text-uppercase">Khẩu phần</h6>
                    <h1 class="display-5 text-uppercase mb-0">Chim vui - chim khỏe hãy đến shop tôi</h1>
                </div>

                <!-- Blog End -->

                <div class="col-xl-12">
                    <div class="products-area products-area3">
                        <div class="row justify-content-center">
                            <!--                                <div>${requestScope.MESSAGE}</div>-->


                            <% 
            List<RecipeDTO> listRecipeHomePage = (List<RecipeDTO>) request.getAttribute("LIST_RecipeHomePage");
           
            if (listRecipeHomePage != null && !listRecipeHomePage.isEmpty()) {
          
                for (RecipeDTO listRHP : listRecipeHomePage) { 
               
                    %>
                            <div class=" col-lg-3 col-xl-2 col-md-4 col-sm-6" style="margin: 10px;">
                                <div class="product-item product-item2 element-item3 sidebar-left" style="border: 2px solid; border-radius: 10px; width: 220px;">
                                    <div style="text-align: center;">
                                        <a href="productDetail.jsp" class="product-image">
                                            <img style="width: 160px;height: 190px" src="<%=listRHP.getSource() %>" alt="" />
                                        </a>
                                    </div>
                                    <div class="bottom-content">
                                        <div style="text-align: center;">
                                            <a href="" style="color: black;"><%=listRHP.getTitle_recipe() %></a>
                                        </div>

                                        <div style="text-align: center;">
                                            <span style="text-decoration: line-through "><%=listRHP.getOriginal_price() %>đ</span>
                                            <span class="product-price" style="font-weight: bold; color: red;"><%=listRHP.getSell_price() %>đ</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% 
}
               
}
                    %>


                        </div>
                    </div>
                </div>
            </div>
        </div>

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
                            <a class="text-body mb-2" href="MainController"><i class="bi bi-arrow-right text-primary me-2"></i>Trang chủ</a>

                            <a class="text-body mb-2" href="team.html"><i class="bi bi-arrow-right text-primary me-2"></i>Thành viên</a>


                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h5 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">Loại hàng cho chim</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-body mb-2" href="food.jsp"><i class="bi bi-arrow-right text-primary me-2"></i>Thức ăn</a>
                            <a class="text-body mb-2" href="drinks.jsp"><i class="bi bi-arrow-right text-primary me-2"></i>Thức uống</a>
                            <a class="text-body mb-2" href="supplement.jsp"><i class="bi bi-arrow-right text-primary me-2"></i>Thực phẩm bổ sung</a>
                            <a class="text-body mb-2" href="medicine.jsp"><i class="bi bi-arrow-right text-primary me-2"></i>Thuốc</a>
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
                        <p class="mb-md-0">&copy; <a class="text-white" href="index.html">Trang web được thiết kế bởi nhóm 3 </a> </p>
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <p class="mb-0">Nguồn <a class="text-white" href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary py-3 fs-4 back-to-top"><i class="bi bi-arrow-up"></i></a>
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
