<%-- 
    Document   : order.jsp
    Created on : Jul 14, 2023, 4:33:31 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="fbird.user.UserDTO"%>
<%@page import="fbird.order.OrderDTO"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0 mb-5" style="margin-top: -50px;">
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
                <form action="MainController" method="POST">

                    <div class="searchBar">
                        <input id="searchQueryInput" type="text" name="searchQueryInput" placeholder="Search" value="" />
                        <button id="searchQuerySubmit" type="submit" name="action" value="searchQuerySubmit">
                            <svg style="width:24px;height:24px" viewBox="0 0 24 24"><path fill="#666666" d="M9.5,3A6.5,6.5 0 0,1 16,9.5C16,11.11 15.41,12.59 14.44,13.73L14.71,14H15.5L20.5,19L19,20.5L14,15.5V14.71L13.73,14.44C12.59,15.41 11.11,16 9.5,16A6.5,6.5 0 0,1 3,9.5A6.5,6.5 0 0,1 9.5,3M9.5,5C7,5 5,7 5,9.5C5,12 7,14 9.5,14C12,14 14,12 14,9.5C14,7 12,5 9.5,5Z" />
                            </svg>
                        </button>
                    </div>
                </form>
            </div>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto py-0">

                    <div class="nav-item nav-link" style="width: max-content">
                        <% 
                            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                            if(loginUser != null) {
                        %>
                        <a  href="MainController?action=ViewCart&customer_id=<%= loginUser.getCustomer_id() %>"class="shopping">
                            <%}%>
                            <i class="fa fa-shopping-cart" style="font-size:25px;"></i>

                        </a>
                    </div>


                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Danh mục</a>
                        <div class="dropdown-menu m-0">
                            <a href="MainController?action=productpage" class="dropdown-item">Sản phẩm</a>
                            <a href="MainController?action=foodpage" class="dropdown-item">Thức ăn</a>
                            <a href="MainController?action=medicinepage" class="dropdown-item">Thuốc</a>
                        </div>
                    </div>
                    <a href="MainController?action=ViewRecipe" class="nav-item nav-link">Khẩu phần</a>                      
                    <a href="userProfile.jsp" class="nav-item nav-link"><i class="fa-solid fa-user"></i></a>
                    <a href="adminDashboard.jsp" class="nav-item nav-link"><i class="fa-solid fa-user-gear"></i></a>
                        <%
                
                if(loginUser != null) {
            
                        %>
                    <div class="nav-item dropdown"> 
                        <a href="#" class="nav-item nav-link nav-contact bg-primary text-white px-3 ms-lg-3" data-bs-toggle="dropdown"><%= loginUser.getFullname() %></a>
                        <div class="dropdown-menu m-3">
                            <a href="MainController?action=ViewProfile&username=<%= loginUser.getUsername() %>" class="dropdown-item">View Profile</a>
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
        <div class="container">
            <div class="title">
                <h2>Product Order Form</h2>
            </div>
            <div class="d-flex">
                <%                                                      
                          List<OrderDTO> address = (List<OrderDTO>) request.getAttribute("ADDRESS");
                          for (OrderDTO adr : address){
                            
                           
                        %>
                <form>
                    <a href="../src/java/fbird/controller/ViewAddressController.java"></a>
                    <label>
                        <span>Street Address <span class="required">*</span></span>
                        <input type="text" name="houseadd"  required value="<%= adr.toString() %>">
                        <input type="text" name="houseadd"  required value="<%= adr.getPhone() %>">
                        <input type="text" name="houseadd"  required value="<%= adr.getPostal_code() %>">
                    </label>
                    
                    <div class="row mb-4 d-flex justify-content-between align-items-center" id="element">

                    </div>

                </form>
                    <%
                        }
                    %>
                <script>
    
  
                    



                    document.addEventListener("DOMContentLoaded", function () {
                        getDataFromSessionStorage();
                        var shippingOptionSelect = document.getElementById("shippingOption");
                        shippingOptionSelect.addEventListener("change", updateTotalPrice);
                    });
                    function getDataFromSessionStorage() {
//                        var quantityJson = sessionStorage.getItem("cartQuantities-0");
//                        var allPricesJson = sessionStorage.getItem("allPrices");
//                        var priceElement = sessionStorage.getItem("priceElement-0");
//                        var imgElement = sessionStorage.getItem("img-0");
//                        var nameElement = sessionStorage.getItem("name-0");
//                        var titleElement = sessionStorage.getItem("title-0");
                        var allElement = JSON.parse(sessionStorage.getItem("Element"));
                       
                        if (Array.isArray(allElement)) {
                            // Khai báo một mảng để chứa các đối tượng mới


                            // Duyệt qua các phần tử trong elementArray và tạo các đối tượng mới
                            for (let i = 0; i < allElement.length; i++) {
                                const [name, title, img, price, quantity] = allElement[i];
                                
                                 var a = `<div class="row mt-3">
    <div class="col-md-2 col-lg-2 col-xl-2">
        <img src="`+ img+ `" id="imgDisplay" class="img-fluid rounded-3" alt="Cotton T-shirt">
    </div>
    <div class="col-md-4 col-lg-4 col-xl-4">
        <h6 id="nameDisplay" class="text-muted">`+name+`</h6> 
        <h6 id="titleDisplay" class="text-black mb-0">`+title+`</h6>
    </div>
    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
        <p id="quantityDisplay" name="quantity" type="number"  readonly>`+quantity+`</p>
    </div>
    <div class="col-md-3 col-lg-2 pt-4 col-xl-2 offset-lg-1">
        <h6 id="priceElement" >`+formatNumber(price)+` đ</h6>
    </div>
    
</div>`;          
                                console.log(title);
                                document.getElementById('element').innerHTML += a;
                                // Tạo một đối tượng mới và đẩy vào mảng newObjectArray
                                
                               

                            }

                            // Giờ đây, mảng newObjectArray chứa các đối tượng mới với các thuộc tính được trích xuất từ các biến khác nhau
                           
                        }
                         updateTotalDisplay();
                    }
                    function formatNumber(n) {
                        // format number 1000000 to 1,234,567
                        var numberString = n.toString();
                        return numberString.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                    }
                    function updateTotalDisplay() {
                        
                        var totalPriceDisplay = document.getElementById("allPriceDisplay");
                        
                        var allPrice = JSON.parse(sessionStorage.getItem("allPrices"));
                        var shippingOptionSelect = document.getElementById("shippingOption");
                        var shippingCost = parseFloat(shippingOptionSelect.value);
//                        console.log(data.imgElementValue);
                       
                        
                        var total = allPrice + shippingCost;
                        
                            
                            totalPriceDisplay.innerText = formatNumber(total) + "đ";
                          
//                            sessionStorage.clear();
                        }
                    







                </script>
                <div class="Yorder">
                    <table style="margin-left: 15%; text-align: center;">
                        <tr>
                            <th colspan="2">Your order </th>
                        </tr>


                        <tr>
                            <td>Shipping</td>
                            <td>
                                <div onchange="updateTotalDisplay()">
                                    <select id="shippingOption" style="min-width: 100%; border-radius: 7px;">

                                        <option value="50000">Hỏa tốc - 50.000đ</option>
                                        <option value="40000">Nhanh - 40.000đ</option>
                                        <option value="30000">Tiết kiệm - 30.000đ</option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Subtotal</td>
                            <td id="allPriceDisplay" style="color: #7AB730;"></td>
                        </tr>
                    </table><br>
                    <div>
                        <input type="radio" name="dbt" value="dbt" checked> Direct Bank Transfer
                    </div>
                    <p>
                        Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order will not be shipped until the funds have cleared in our account.
                    </p>
                    <div>
                        <input type="radio" name="dbt" value="cd"> Cash on Delivery
                    </div>
                    <div>
                        <input type="radio" name="dbt" value="cd"> Paypal <span>
                            <img src="https://www.logolynx.com/images/logolynx/c3/c36093ca9fb6c250f74d319550acac4d.jpeg" alt="" width="50">
                        </span>
                    </div>
                    <button type="button" style="margin-bottom: 10%;">Place Order</button>
                </div><!-- Yorder -->
            </div>
        </div>
    </body>
</html>
<style>
    /*@import url('https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700');*/

    body{
        background: url('http://all4desktop.com/data_images/original/4236532-background-images.jpg');
        font-family: 'Roboto Condensed', sans-serif;
        color: #262626;
        margin: 5% 0;
    }
    .container{
        width: 100%;
        padding-right: 15px;
        padding-left: 15px;
        margin-right: auto;
        margin-left: auto;
    }
    @media (min-width: 1200px)
    {
        .container{
            max-width: 1140px;
        }
    }
    .d-flex{
        display: flex;
        flex-direction: row;
        background: #f6f6f6;
        border-radius: 0 0 5px 5px;
        padding: 25px;
    }
    form{
        flex: 4;
    }
    .Yorder{
        flex: 2;
    }
    .title{
        background-color: #7AB730;
        border-radius:5px 5px 0 0 ;
        padding: 20px;
        color: #f6f6f6;
    }
    h2{
        margin: 0;
        padding-left: 15px;
    }
    .required{
        color: red;
    }
    label, table{
        display: block;
        margin: 15px;
    }
    label>span{
        float: left;
        width: 25%;
        margin-top: 12px;
        padding-right: 10px;
    }
    input[type="text"], input[type="tel"], input[type="email"], select
    {
        width: 70%;
        height: 30px;
        padding: 5px 10px;
        margin-bottom: 10px;
        border: 1px solid #dadada;
        color: #888;
    }
    select{
        width: 72%;
        height: 45px;
        padding: 5px 10px;
        margin-bottom: 10px;
    }
    .Yorder{
        margin-top: 15px;
        height: 600px;
        padding: 20px;
        border: 1px solid #dadada;
    }
    table{
        margin: 0;
        padding: 0;
    }
    th{
        border-bottom: 1px solid #dadada;
        padding: 10px 0;
    }
    tr>td:nth-child(1){
        text-align: left;
        color: #2d2d2a;
    }
    tr>td:nth-child(2){
        text-align: right;
        color: #52ad9c;
    }
    td{
        border-bottom: 1px solid #dadada;
        padding: 25px 25px 25px 0;
    }

    p{
        display: block;
        color: #888;
        margin: 0;
        padding-left: 25px;
    }
    .Yorder>div{
        padding: 15px 0;
    }

    button{
        width: 100%;
        margin-top: 10px;
        padding: 10px;
        border: none;
        border-radius: 30px;
        background: #7AB730;
        color: #fff;
        font-size: 15px;
        font-weight: bold;
    }
    button:hover{
        cursor: pointer;
        background: #428a7d;
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
