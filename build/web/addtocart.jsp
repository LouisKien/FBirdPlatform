<%@page import="FBird.Product.Product"%>
<%@page import="FBird.Cart.Cart"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                                <h6 class="mb-0 text-muted">1 sản phẩm</h6>
                                            </div>
                                            <!--                    <hr class="my-4">
                                              
                                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                                  <div class="col-md-2 col-lg-2 col-xl-2">
                                                                    <img
                                                                        src="img/product-2.png"
                                                                      class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                                  </div>
                                                                  <div class="col-md-3 col-lg-3 col-xl-3">
                                                                    <h6 class="text-muted">Birdfood</h6>
                                                                    <h6 class="text-black mb-0">Quality Pet Foods</h6>
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
                                                                    <h6 class="mb-0">€ 44.00</h6>
                                                                  </div>
                                                                  <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                                  </div>
                                                                </div>
                                              
                                                                <hr class="my-4">
                                              
                                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                                  <div class="col-md-2 col-lg-2 col-xl-2">
                                                                    <img
                                                                        src="img/product-3.png"
                                                                      class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                                  </div>
                                                                  <div class="col-md-3 col-lg-3 col-xl-3">
                                                                    <h6 class="text-muted">Birdfood</h6>
                                                                    <h6 class="text-black mb-0">Quality Pet Foods</h6>
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
                                                                    <h6 class="mb-0">€ 44.00</h6>
                                                                  </div>
                                                                  <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                                  </div>
                                                                </div>-->

                                            <%
                                    Cart cart = (Cart) session.getAttribute("CART");
                                    if(cart != null){
                                            %>
                                            <%
                    double total = 0;
                    for(Product p : cart.getCart().values()){
                        total += p.getPrice() * p.getQuantity();
                                            %>
                                            <hr class="my-4">

                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                        src="img/product-1.png"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted">Thức ăn cho chim</h6>
                                                    <h6 class="text-black mb-0"><%= p.getName() %></h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>

                                                    <input id="form1" min="0" name="quantity" value="<%= p.getQuantity() %>" type="number"
                                                           class="form-control form-control-sm" />

                                                    <button class="btn btn-link px-2"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0"><%= p.getPrice() %> đ</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                </div>
                                            </div>

                                            <hr class="my-4">

                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="index.jsp" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Tiếp tục mua sắm</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Thanh toán</h3>
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase"> tổng sản phẩm: 1</h5>
                                                <h5><%= p.getPrice() * p.getQuantity() %> đ</h5>
                                            </div>

                                            <h5 class="text-uppercase mb-3">phương thức vận chuyển</h5>

                                            <div class="mb-4 pb-2">
                                                <select class="select " style="min-width: 100%; border-radius: 7px;">
                                                    <option value="1">Giao hàng tiêu chuẩn - 16500 đ</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                    <option value="4">Four</option>
                                                </select>
                                            </div>

                                            <h5 class="text-uppercase mb-3">Mã giảm giá</h5>

                                            <div class="mb-5">
                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplea2" class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Examplea2">Nhập mã giảm giá</label>
                                                </div>
                                            </div>

                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-5">
                                                <h5 class="text-uppercase">Tổng số tiền</h5>
                                                <h5><%= p.getPrice() * p.getQuantity() + 16500 %> đ</h5>
                                            </div>
                                            <%
                                                                }
                                            %>
                                            <button type="button" class="btn btn-dark btn-block btn-lg"
                                                    data-mdb-ripple-color="dark"><a href="login.jsp" style="color: white">Đăng nhập ngay</a></button>

                                        </div>
                                        <%
            }
                                        %>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>