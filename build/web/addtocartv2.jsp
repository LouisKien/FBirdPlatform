<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fbird.cart.CartDTO"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="add-to-cart/addtocart.css">
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.css"
            rel="stylesheet"
            />
        <!-- MDB -->
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.1/mdb.min.js"
        ></script>
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #7ab730;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8">
                                        <div class="p-5">
                                            
                                            <div class="d-flex justify-content-between align-items-center mb-5">
                                                <h1 class="fw-bold mb-0 text-black">Giỏ hàng</h1>
                                                
                                            </div>
                                            
              <% 
    List<CartDTO> listCart = (List<CartDTO>) request.getAttribute("LIST_All_Cart_Item");
    int count = 0;
    if (listCart != null && !listCart.isEmpty()) {         
        for (CartDTO cart : listCart) {
        count++;
            
%>
            <hr class="my-4">

            <div class="row mb-4 d-flex justify-content-between align-items-center cart-items-container">
                <div class="col-md-2 col-lg-2 col-xl-2">
                    <img src="img/product-2.png" class="img-fluid rounded-3" alt="Cotton T-shirt">
                </div>
                <div class="col-md-3 col-lg-3 col-xl-3">
                    <h6 class="text-muted"><%= cart.getCategory_name() %></h6>
                    <h6 class="text-black mb-0"><%= cart.getTitle() %></h6>
                    <h6 class="text-black mb-0"><%= cart.getName() %></h6>
                </div>
                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
<!--                    <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                        <i class="fas fa-minus" id="down-<%= cart.getOptional_shop_product_item_id() %>"></i>
                    </button>-->
                    <input id="quantity-<%= cart.getOptional_shop_product_item_id() %>" min="1" name="quantity-<%= cart.getOptional_shop_product_item_id() %>" value="<%= cart.getQuantity() %>" onchange="totalPriceDefault(<%= cart.getOptional_shop_product_item_id() %>)" type="number" class="form-control form-control-sm" />
<!--                    <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                        <i class="fas fa-plus"></i>
                    </button> -->
                </div>
                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                    <h6 class="mb-0 product-price" name="pricedefault" id="pricedefault-<%= cart.getOptional_shop_product_item_id() %>" style="display: none"><%= cart.getPrice() %>đ</h6>
                    <h6 class="mb-0 product-price" id="totalprice-<%= cart.getOptional_shop_product_item_id() %>"></h6>
                </div>
                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                </div>
            </div>
<script>
window.onload = () => {
    var cartItemsContainer = document.getElementsByClassName("cart-items-container");
    for (var i = 0; i < cartItemsContainer.length; i++) {
        var quantity = cartItemsContainer[i].childNodes[5].childNodes[3].value;
        var price = cartItemsContainer[i].childNodes[7].childNodes[1].textContent.split("đ")[0];
        cartItemsContainer[i].childNodes[7].childNodes[3].innerText= (quantity * Number.parseFloat(price)).toFixed(2) + "đ";
    }
    
}
function totalPriceDefault(itemId) {
    var prices = document.getElementById(`pricedefault-`+itemId);
    var quantities = document.getElementById(`quantity-`+itemId);
    var display = document.getElementById(`totalprice-`+itemId);

    var total = 0;
    
   
       total=quantities.value * Number.parseFloat(prices.textContent.split("đ")[0]);
    display.innerText = total.toFixed(2) + "đ";
}
                                                        </script>
<%
        }
    }
%>


                           
<!--                                            <hr class="my-4">

                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                        src="img/product-3.png"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted">Thức ăn</h6>
                                                    <h6 class="text-black mb-0">Cám chim 2</h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>

                                                    <input id="form1" min="0" name="quantity" value="1" type="number"
                                                           class="form-control form-control-sm" />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0">5000đ</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>

                                            <hr class="my-4">

                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                        src="img/product-1.png"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted">Thức ăn</h6>
                                                    <h6 class="text-black mb-0">Cám chim 3</h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>

                                                    <input id="form1" min="0" name="quantity" value="1" type="number"
                                                           class="form-control form-control-sm" />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0">4400đ</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>-->

                                            <hr class="my-4">

                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="MainController" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Về trang chủ</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Tóm tắt</h3>
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">Sản phẩm: <%=count %></h5>
                                                <h5>9800đ</h5>
                                            </div>

                                            <h5 class="text-uppercase mb-3">Vận chuyển</h5>

                                            <div class="mb-4 pb-2">
                                                <select class="select " style="min-width: 100%; border-radius: 7px;">
                                                    <option value="1">Hỏa tốc - 200đ</option>
                                                    <option value="2">Nhanh - 0đ</option>
                                                    <option value="3">Tiết kiệm - 0đ</option>

                                                </select>
                                            </div>

                                            <h5 class="text-uppercase mb-3">Mã giảm giá</h5>

                                            <div class="mb-5">
                                                <div class="form-outline">
                                                    <input type="text" value="45646568721" readonly="" id="form3Examplea2" class="form-control form-control-lg" />
                                                    <!--                        <label class="form-label" for="form3Examplea2">Nhập mã giảm giá</label>-->
                                                </div>
                                            </div>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Tổng đơn</h5>
                                                <h5>10000đ</h5>
                                            </div>

                                            <button type="button" class="btn btn-dark btn-block btn-lg"
                                                    data-mdb-ripple-color="dark">Mua ngay</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                // Hàm cập nhật tổng đơn và số lượng sản phẩm
function updateCartSummary() {
    var productRows = document.querySelectorAll(".row.mb-4");
    var totalQuantity = 0;
    var totalPrice = 0;

    productRows.forEach(function(row) {
        var quantityInput = row.querySelector("input[name='quantity']");
        var priceElement = row.querySelector(".product-price");

        var quantity = parseInt(quantityInput.value);
        var price = parseInt(priceElement.textContent.replace("đ", ""));

        totalQuantity += quantity;
        totalPrice += quantity * price;

        // Cập nhật giá tiền cho sản phẩm
        priceElement.textContent = (quantity * price) + "đ";
    });

    // Cập nhật số lượng sản phẩm và tổng đơn trong phần tóm tắt
    var productCountElement = document.querySelector(".mb-5 h5.text-uppercase");
    var totalAmountElement = document.querySelector(".d-flex.justify-content-between.mb-5 h5");

    productCountElement.textContent = "Sản phẩm: " + totalQuantity;
    totalAmountElement.textContent = totalPrice + "đ";
}
            </script>
        </section>
    </body>
</html>