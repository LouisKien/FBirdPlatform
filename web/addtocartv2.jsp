<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fbird.cart.CartDTO"%>
<%@page import="fbird.user.UserDTO"%>
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
                                                 UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                                  List<CartDTO> listCart = (List<CartDTO>) request.getAttribute("LIST_All_Cart_Item");
                                  int count = 0;
                                  if (listCart != null && !listCart.isEmpty()) {         
                                      for (CartDTO cart : listCart) {
                                      count++;
            
                                            %>
                                            <hr class="my-4">

                                            <div class="row mb-4 d-flex justify-content-between align-items-center cart-items-container">
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <input type="checkbox" id="myCheckbox" onchange="handleCheckboxChange()">
                                                </div>
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img src="<%= cart.getImage_1() %>" id="img-product" class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6  class="text-muted"><%= cart.getCategory_name() %></h6>
                                                    <h6  id="name-product" class="text-black mb-0"><%= cart.getTitle() %></h6>
                                                    <h6 id="title-product" class="text-black mb-0"><%= cart.getName() %></h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <!--                    <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                                            <i class="fas fa-minus" id="down-<%= cart.getOptional_shop_product_item_id() %>"></i>
                                                                        </button>-->
                                                    <input id="quantity-<%= cart.getOptional_shop_product_item_id() %>" min="1" name="quantity-<%= cart.getOptional_shop_product_item_id() %>" value="<%= cart.getQuantity() %>" onchange="updateElementPrice(<%= cart.getOptional_shop_product_item_id() %>)" type="number" class="form-control form-control-sm" />
                                                    <!--                    <button class="btn btn-link px-2" onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                                            <i class="fas fa-plus"></i>
                                                                        </button> -->
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0" name="pricedefault" id="pricedefault-<%= cart.getOptional_shop_product_item_id() %>" style="display: none"><%= cart.getPrice() %>đ</h6>
                                                    <h6 class="mb-0 product-price" id="totalprice-<%= cart.getOptional_shop_product_item_id() %>"></h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="MainController?action=DeleteCartItem&cart_item_id=<%= cart.getCart_item_id() %>&customer_id=<%= loginUser.getCustomer_id() %>" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>
                                            <script>

                                                window.onload = () => {
                                                    var cartItemsContainer = document.getElementsByClassName("cart-items-container");
                                                    var totalPrice = 0;

                                                    // Tính tổng giá tiền ban đầu
                                                    for (var i = 0; i < cartItemsContainer.length; i++) {
                                                        var quantityInput = cartItemsContainer[i].childNodes[7].childNodes[3];
                                                        var priceElement = cartItemsContainer[i].childNodes[9].childNodes[1];
                                                        var priceText = priceElement.innerText;
                                                        var price = parseFloat(priceText.split("đ")[0]);

                                                        // Lưu giá tiền ban đầu vào thuộc tính "data-price"
                                                        quantityInput.setAttribute("data-price", price);

                                                        var quantity = parseInt(quantityInput.value);
                                                        var itemTotalPrice = quantity * price;


                                                        // Hiển thị tổng giá tiền cho mỗi mục trong giỏ hàng
                                                        var totalElement = cartItemsContainer[i].childNodes[9].childNodes[3];
                                                        totalElement.innerText = formatNumber(itemTotalPrice + "") + "đ";
                                                        var allPrices = document.getElementById("allprice");
                                                        allPrices.innerText = 0 + "đ";
                                                        sessionStorage.setItem("allPrices", JSON.stringify(totalPrice));
                                                    }
                                                    for (var i = 0; i < checkboxes.length; i++) {
                                                        checkboxes[i].addEventListener("change", handleCheckboxChange);
                                                    }
                                                };

                                                function formatNumber(n) {
                                                    // format number 1000000 to 1,234,567
                                                    return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                                                }
                                                function ConvertToNumber(priceStr) {
                                                    var priceParts = priceStr.split(".");
                                                    var price = "";
                                                    for (var i = 0; i < priceParts.length; i++) {
                                                        price += priceParts[i];
                                                    }
                                                    return Number.parseInt(price);
                                                }

                                                function handleCheckboxChange() {
                                                    sessionStorage.clear();
                                                    var cartItemsContainer = document.getElementsByClassName("cart-items-container");
                                                    var totalPrice = 0;
                                                    let Allelement = [];
                                                    for (var i = 0; i < cartItemsContainer.length; i++) {
                                                        var checkbox = cartItemsContainer[i].querySelector('input[type="checkbox"]');
                                                        var imgElement = cartItemsContainer[i].childNodes[3].childNodes[1];
                                                        var name = cartItemsContainer[i].childNodes[5].childNodes[3];
                                                        var title = cartItemsContainer[i].childNodes[5].childNodes[5];

                                                        var srcValue = imgElement.getAttribute("src");
                                                        var nameValue = name.innerText;
                                                        var titleValue = title.innerText;



                                                        var totalElement = cartItemsContainer[i].childNodes[9].childNodes[3];
                                                        var quantityInput = cartItemsContainer[i].childNodes[7].childNodes[3];
                                                        var quantity = parseInt(quantityInput.value);
                                                        var price = ConvertToNumber((totalElement.innerText));

                                                        if (checkbox.checked) {
                                                            let Element = [nameValue, titleValue, srcValue, price, quantity];
                                            //        sessionStorage.setItem("name-"+i, JSON.stringify(nameValue));
                                            //        sessionStorage.setItem("title-"+i, JSON.stringify(titleValue));
                                            //        sessionStorage.setItem("img-"+i, JSON.stringify(srcValue));
                                            //        sessionStorage.setItem("priceElement-"+i, JSON.stringify(price));
                                            //      sessionStorage.setItem("cartQuantities-"+i, JSON.stringify(quantity));
                                                            Allelement.push(Element);
                                                            sessionStorage.setItem("Element", JSON.stringify(Allelement));
                                                            totalPrice += price;
                                                        }
                                                    }

                                                    var allPrices = document.getElementById("allprice");
                                                    allPrices.innerText = formatNumber(totalPrice + "") + "đ";
                                                    sessionStorage.setItem("allPrices", JSON.stringify(totalPrice));
                                                }

                                                // Function to handle checkbox change and quantity input change
                                                function handleInputChange(event) {
                                                    updateElementPrice(event);
                                                    handleCheckboxChange();
                                                }

                                                // Gắn sự kiện onchange cho các input số lượng và checkbox
                                                var quantityInputs = document.querySelectorAll('.cart-items-container input[type="number"]');
                                                var checkboxes = document.querySelectorAll('.cart-items-container input[type="checkbox"]');
                                                for (var i = 0; i < quantityInputs.length; i++) {
                                                    quantityInputs[i].addEventListener("change", handleInputChange);
                                                    checkboxes[i].addEventListener("change", handleCheckboxChange);
                                                }
                                                // In ra tổng giá tiền của tất cả sản phẩm

                                                // Cập nhật giá tiền khi thay đổi số lượng
                                                function updateElementPrice(event) {

                                                    var quantityInput = event.target;
                                                    var price = ConvertToNumber(quantityInput.getAttribute("data-price"));
                                                    var quantity = parseInt(quantityInput.value);
                                                    var totalElement = quantityInput.parentNode.parentNode.childNodes[9].childNodes[3];
                                                    var itemTotalPrice = quantity * price;
                                                    totalElement.innerText = formatNumber(itemTotalPrice + "") + "đ";


                                                }


                                                // Gắn sự kiện onchange cho các input số lượng
                                                var quantityInputs = document.querySelectorAll('.cart-items-container input[type="number"]');
                                                for (var i = 0; i < quantityInputs.length; i++) {
                                                    quantityInputs[i].addEventListener("change", updateTotalPrice);
                                                }

                                            </script>
                                            <%
                                                    }
                                                }
                                            %>




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
                                                <div class="allprice" id="allprice"></div>
                                            </div>

                                            <a type="button" class="btn btn-dark btn-block btn-lg" data-mdb-ripple-color="dark" href="MainController?action=ViewOderAddress&customer_id=<%= loginUser.getCustomer_id() %>" >Mua ngay</a>

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

                    productRows.forEach(function (row) {
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