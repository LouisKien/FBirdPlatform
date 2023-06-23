<%-- 
    Document   : productDetail
    Created on : Jun 23, 2023, 1:28:03 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="fbird.feedback.FeedbackDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Product Details Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
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
        <!--Search bar-->
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="productPage/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">

        <script src="https://kit.fontawesome.com/39834b73e4.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div style="background-color: #BCDAE0;">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0 mb-5">
                <a href="index.html" class="navbar-brand ms-lg-5">
                    <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>FBIRD</h1>
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


                        <a href="userProfile.jsp" class="nav-item nav-link"><i class="fa-solid fa-user"></i></a>  
                        <a href="login.jsp" class="nav-item nav-link">Đăng nhập</a>
                        <a href="register.jsp" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5">Đăng ký<i class="bi bi-arrow-right"></i></a>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->

            <form action="MainController" method="POST">
                <div class="flex-box">
                    <div class="left">
                        <div class="big-img">
                            <img src="img/product-1.png">
                        </div>
                        <div class="images">
                            <div class="small-img">
                                <img src="img/product-1.png" onclick="showImg(this.src)">
                            </div>
                            <div class="small-img">
                                <img src="img/product-2.png" onclick="showImg(this.src)">
                            </div>
                            <div class="small-img">
                                <img src="img/product-3.png" onclick="showImg(this.src)">
                            </div>
                            <div class="small-img">
                                <img src="img/product-4.png" onclick="showImg(this.src)">
                            </div>
                        </div>
                    </div>

                    <div class="right">
                        <div class="url">
                            <a class="url1" href="index.jsp">Trang chủ</a> > <a class="url1" href="product.html">Sản phẩm</a> > <a class="url1" href="recipe.jsp">Khẩu phần cho chim</a>
                        </div>
                        <div class="pname">Cám chim 1</div>
                        <input type="hidden" name="id" value="1"/>
                        <input type="hidden" name="name" value="Cám chim 1"/>
                        <input type="hidden" name="price" value="4000"/>
                        <input type="hidden" name="quantity" value="1"/>
                        <div class="ratings">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        </div>
                        <div class="price">4000 đ</div>

                        <div class="size">
                            <p style="margin-right: 10px;">Loại:</p>
                            <div class="btn-group-toggle" data-toggle="buttons">
                                <label class="btn btn-primary active">
                                    <input type="radio" name="size" id="size1" autocomplete="off" checked> 0.2kg Hạt nhỏ
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="size" id="size2" autocomplete="off"> 0.5kg Hạt to
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="size" id="size3" autocomplete="off"> 1kg Hạt nhỏ
                                </label>
                                <label class="btn btn-primary" style="margin-top: 2px;">
                                    <input type="radio" name="size" id="size4" autocomplete="off"> 2kg Hạt to
                                </label>
                            </div>
                        </div>
                        <div class="quantity">
                            <p>Số lượng :</p>
                            <input type="number" min="1" max="5" value="1">
                        </div>
                        <div class="btn-box">
                            <button class="btn btn-primary cart-btn" name="action" value="Add">Thêm vào giỏ hàng</button>
                            <button class="btn btn-primary buy-btn">Mua ngay</button>
                        </div>
                    </div>

                </div>
            </form>

            <div style="margin-left: 20%; transform: translateX(-10%);">
                <div style="margin-top: 20px; margin-bottom: 20px; background-color: #D5CAD0; display: flex; justify-content: space-around; width: 50%; text-align: center; padding: 10px;">
                    <a href="shopProduct.jsp">
                        <div class="avatar"
                             style="background-image: url('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBMVFBcVFRQXFxcXGxcaGxsbGxodGx0aGhsaGhohHRsbISwkGx0qIBcaJTYmKS4wNDM0GyI5PjkyPS4yMzABCwsLEA4QHRISHjIqJCkwMjI8MjIyMjsyMjIyNTIyMjIyMjIzMjI0MjQyMjIyMzIyMjIyMjIyMjIyMjIyMjIyMv/AABEIANoA5wMBIgACEQEDEQH/xAAcAAEAAQUBAQAAAAAAAAAAAAAABgEDBAUHAgj/xABCEAACAQICBgYHBwIGAQUAAAABAgADEQQhBRIxQVFhBiJxgZGhBxMyQlKx8BQjYnKCwdGS4TNTorLC8UMXNUSzw//EABoBAQADAQEBAAAAAAAAAAAAAAADBAUCAQb/xAAtEQACAgEEAQIFAwUBAAAAAAAAAQIDEQQSITFBBVETYXGBkSIysUKhweHxBv/aAAwDAQACEQMRAD8A7NERAKREjuntN6n3dM9c5XHHgOHNt3bs9SbeEcWWRgssxtO6cdWamnV1TYkjrE8sshwtmdoI3xyppKvfOo9/zsfO+UtYjFEk2Pad549g+e+8x5chWkuTA1GqlOWYt/kuviGbMm54nMntLXMy8LpiumSuwHKxH9JGr5A85r4nTin4K8bpxeVJ5JNhulbj2rHjdfkVt/tm7wPSKi+THVPbceO0d4E59AM4dMWWq/ULYvnlHWVYEXBuJWc60XpyrRO3WTep2f2PPxvJxozSVOumsh2ZMDtU8CJWnBxNbT6qFy479jPiUlZwWhERAEREAREQBERAEREAREQBERAEREAREQDW6Zx3qaTPv2L2n+Mz3TnYq6zlmNsmsdpucrDibFpL+k1nqIjeyqliNxLGwv2BT4yMY3Dpq69MgjYbG4lmpJL6mNr5ylLjpGI7DVHVAuWPOwOqLnfsJ754h36o4i47y1x/uE8qtv3PGTozJdl6hRZzZf7CZh0U3xjwMouIWjh2qtYWBYk7MshflvlrRvRvSGKQVnqrhw/WRXVnqFTsLKrqKdxY6ouRvsZHOzaW6dK7Fwslmvh2Q2Yd+4y3MqvhcZRq06OLKmk3sVU1iKji9kYtnTOWtbMtbJiARLGIp6rst72/fMX52nUJqRDfRKp8niX8FjHouHpmzDaDsYb1bl8tssROms8MhjJxalHs6XonSKYimKidhU7VYbQfrPIzPnMtA6TOGxAJP3dSyuNw4N3E+BPKdNvKU47Xg+k0t/xoZ8+T1EROCyIiIAiIgCIiAIiIAiW6tVVF2YKOJIA857BgFYiIAiIgCImJjqSuhDKzD8JIYc1ZSGVhxBB4QCE6fTFYjFnBhAhddf1wsyCip2lbhte7qursJzva4GPU0I+EqNSNQ1adVGdGIAYOhAdW1QF99SDYbx7tzmhvs40jiaYrl0oJqGu7O11WowKhySqXYZG1ypy3yF9GNKM2NqYdcW2LpBTUFRtfN2VdawckrmxBGw6oncZvckVr9PFwlJ9myK7Dw+v3nqDEvHzRnVsMKq4WkfZqV6QccUUtUYHkQhHfJxp3Sn2aiagpvVYkKlNAS7ubkAAAnYCSbGwUnOQ3R9UBab/5VVGJ4LrDXP8AQz+E3XpExWKo4ZcRhSNek9yCNYFWR0zH5mWU7uGfQ+nYcPuarQvS+hpL1mCxNE0ajhgoDXuVzOqSAVqKRrDL3b7rTWuiqnqhTZGosyOdRlQtchirNk2sw1rgnbnOcdDqmIraQXE6wLevp1KhuoJapUudVNpubg6oyB3TrWn64L1be/Uy7FVFb/UpnlGd2D31GMXVk0sSgMrLp86WMWuXfOl9GMYauGpuTdgNVu1SVv32v3zmmKOQ7ZOPR898O44VG81QyC9cGl6ZJqbXuiVxESqbgiIgCIiAIiUJgFLTUdIdNphKJqNmxyRL2LN+wG0ncOdhNlTroy6yuGXPrAgjLbmMpxrpVpo4vEM4P3aXWmPw39rtY59lhuncI7mV9Rb8OOV2zA0ppCpiXL1m1ydg91RwVfdH0byc+inGuyV6JJK02RkvuD64IHAdS9uZnO3awvMvR2lHp4epRS6+tca7DaaarYIOAJL38N5kso5WEUKbdst0n/s6Fp7p6lNjTw6CqwyLk9QHlbN+3IcCZk9DulxxbNSqIqVFXWGqTqstwDYHMEXGVztnKpLvRdhi2Lq1PdSnq/qdhbyptOJQSRNVqJzsS8ex1eJSVkRoiUlYgEcr6tn9YL066FX5FixUX4kVCBzAG8SFaG6M08JUdlqXLF7fdrrKG1dpBBHs+zrEC5yGclukK5VQo2r1f1C4J7gMvzcpp5ga/wBTlTLZX2u2aWm0cbYtz6fgwK2CIzVtfu1T4XIPjMS/jw3+E3BYDaRMLSGJpBbuVAHvNYeF98aX1+9PbZHd9Oyrqf8AzlNnNTcf4PODxAQkMLqwsRN/hNIFkNPVNZCNUgXJKkWsykWbLeSP3mr0Fgw2IS6iyhmsc75aoJB5uMpNQJtV66OojuUcfcox9NnpJbXPP0RENF9EadOoatOkKLG/Wch3F9uqoFr/AImZrcJIsNoqkmeprN8T9ZvPZ3TOicuTLLim03y/mY2IwNKoLPTU91j3EZiQ7TOjvU1LAko2ak7ctoPMZeIk6kb6aOBTp/Fr5dhVr/ISWixxkl4ZS19EJ1OWOV5IdiXubcJNeh+Nw9DDE1K1NC7M1mdQQMlFwT+G/fIMiFjbxPAfzM9RbIbpfnDesGJRf8GWUsnQV6V4A/8Ay6Pe4A8TNhhdJUKv+FVp1PyOrfIzkmJwFN91jxH78ZosXQNNhdTfarL+x2gyGVOPJow9R3eD6Dic56G9NKa0vV4uswYNZGdWPVsPaYA7DfNp0DD10qKHRldWzDKQQRyIyMhaaNCFkZrKL8RE8JDzOd+kfTpv9kRrCwNUjffNU7LdY9q85ONKY5KFF6z+zTUm3E7gOZNgO2cLxeJao71Khu7kux5k3NuA4cpJXHLyU9XbtjtXbMzRWmGo0MVQQkeu9WMtijrioRzYaq/9TAluiuVztOcrVew57pMlgzpScsL2PD9Y6vDbLoE800sOe+ema2c9OX7Hmq9hNpgdNVaOH9TRJp65L1HHtsxyADe6oUAZZkgm4vaadBrG52DZL88xk6UnDoy8DpzEYaoKtN3Ym+spZmDXFswTmRe/dE23QLRX2jF6zC9OirFuBZgVUebH9ESOTWS5VGxxydkiIkJokN6QkLVfdsbtuqi/+m3dNdhcDWrZqNVT7xyB7N7fKTHGaLp1HV3F9XduPDWG+1z4yzWwLpnSOXwH9ifkfHdMaXpandKybym+EaMNdsrUIrn3Ob9Lkq4dQlN/vGqJTBCge2utvvvsLzLo6Hp01XW+8qGwZ36zHe1ifZWwOQ5TA6e4/UqUWYZiuHK7/ugqzdsxqMAuRbIXByXexG0dnIbzIf0VVSUVy20vfvH9jRjKTim34yzcdGqN9eofeOqvYM287D9M30w8M9OmiorZKLDI+Jy2nbPZxicSe7+ZoUVqqtRXgyLpuc2/cyYmC+PG5fGY5rVKns3Ycsl8Tl5yXJFgzMRiwMhmfISIadWrWbqI7Il9ZwCV1t4y22GWXPhJTRwG9zf8IvbvO0+XfM9VAFgLAbAJ3XLbLJFdWrIOOcZOZU1C9Udt+J338pdki6S6MAZaqC1yQ4HEg6p7zYHukdmpVYpxyj5jU0Spntf59xLdakrqVYXH1s5y5PDpfeQeI+s5IV0RrF0alNypAI3HZcSQdAdMpQxBFSr6qm6nWDX1GbKxvsU/iNssuzB0sx1OsBrA5Hjxt/HKab1w2EW8xIJxXRoUWtYaR9D03BAIIIOYI4T3OcejDF17vTszYcKWVjfVVwQNVW4EEm27V5zoOIrrTRnY2VQWY8ABcys1h4NquxSjuIH6TtKZJhlO37x+wXCg99z+kTnD5m24ZmZ2mdJNWqvWbbUa4HAbEXuAAmGi2Ge3aZYisLBlXT3zb/B6ZrZy1TFzrHunn2zyEvsQBPSLoqTaY+bn8IlQC/JfnL4FoPOigE9UaL1HWlTUtUc6qgcf2G8ncBLD1dy5mT70dYrBU6gp2f7TUBGu6qFNhrFKeqzFRYXuba1uwDyUsIlqgpySbwTLovoNcJQWmLFj1nb4nO3uGQHIRN1ErGykksFYiIPRKSsQCD47os9bEesZVGozlGY3ADNrXCja2zba032F0BRQe8WO1tY3Pdstym4EStDS1wllLnnv588E89ROUVFvhEexmERKiJrPZw+d1yZStvd363kOMuDR6byx7wPkBMLpJigWNj/hqRf8TWJ8LL33mborGCrTV9+xhwYbf575LZVhKSKtd6lNwzyi6uEpj3Ae3rf7ry/ESIsiIiAa/TTWpEcSv+k6/wAlMgokt6TVrIF5E956g8i8ic0dKsRyfPeqTzal7ITy4O42PlPUtuxGdrjlt/vLJlljE2dGVsmtfPjuIO8SPgg8DJJUUVF6pz3Hnz5SMPhx2EfORzLVOOTa6C03XwdTWpsWQnr0yeqw32+FuY8xlJj036SU6mFpJRa4xADtxCKdh4EsLH8rCc4UspFzdcrnaQN/b3+M8s4OQOWdzwHC247fEyJxWcl2NslFx8M9rmb7hs/meWJY2GzjKWv+FR5yocnJBlxnREe2cKLeU8qhObeEAKuZNz9eEa7NsFhxg8Lj1AJZ6zch9eMuJRA25n63T07gZbScgBtJOyB9CiqFH7yc+jnQLO4xlQWRQRSB95iCrN+UAkDiTyz89Fegr1CtXFqVTatLe3DX+Ffw7TvtsPTEQAAAAACwAyAA2ADdIpz8Iv6bTtPdIuxESIviIiAIiIBSavS2khSWwI1yMuAHxHlw4nvtkaSxgpUyx27AOJ/jIk8gZzrH45qjEkk3NyeJ4nlwG6SVw3MpazVKqOF2yuOxeubC+qDe52sd5MyNBaR9VUsx+7ewbkdzd2/l2TWRLUoKUdrMOF8oTU12dIlZGOj+mAoFKobDYjHdwUn5HuknmZZW4PDPqaLo3RUl/wAEREjJiKdJ365H5B4At/ymhm+6Tp1yfyHxUr/xmhmrT+xHy+uz8Z5EtetANmy4cD3y7KMoIsRcSUpFqrSPtLkfn/eRms76zEjaSbbxnJGb0+a+Y/tzms0qF1gy+9t7Rb67pxJFip4eDXpUB7eB+s5aqpY6wHdu7ZcZFaWtUjqm5By2jfzMjLS+RS99t2PAbJc1WPBRwEkNDodpFtmHCDcWdAPJjNrhvRxi2/xK1JB+EM58wvznO6PuSKmx9IhiUgP5MGoLgbScgBmSeU6fgvRvhVzq1KlU8LhF8Fz/ANUk+jtC4ah/g0UQ8Qo1j2sese8zl2LwTx0cn+5nKNEdD8biLE0/UIfeqXDW5J7R77DnOidHuiGGwlmA9ZV/zHsSPyjYndnzMkcrI5SbLdenjDoSsROScREQBERAERKQCG9MsXdhTB2Cx7TZj5aviZFpnaZxGvVdtxJI7CcvKw7prK5yt8RA8dvlLta2xR8zqrPiWt/YuygMMbC/CWlfVp3PC578/wB5IV8GPjqg9Ub77jztMvo70yqUfuq16lMW1W/8ijhn7YHPPnukYr4hyVBOV9nb/wBy3VyIPA+RlexKfZoaeUqXlPs7RgdL0Kq61OorDzHaNxmQ2JQe8O7OQX0ZgNWrU2UMjIr57mVtUEcDZj4SfVdDL7rFeR6w/Y+co2VuLwjdpuU4psjmnn187ZapA7VOsPLXkck2xmh6uqbBWtmLGxNt1iLC4uNu+QuqliR4dm7ylzSt7dr8GN6pXixSXlfweCJabWXMZrw3js4ie6jEC4F7bRv7oRwwuDLRmFUcEXE0+m8KwAZfZBzG8E7O6bGqhU6y7N4/eXAyupB3ixE5azwdQlteURNanxeMvduYO+e8TQsxU7ja/wApjZpzH14SIu8Po6L6OukTawwdVrixNFjtsou1M9guRyBHCdHnF+iui8RUxOHqIj6gdHNTVOpqKeuNfZcgFbXvczs8gmknwaullJw5PURE4LIiIgCIiAIiIAiIgFJgaWxHq6LtextYdpyHzvM+RPppjLBaQP4j33A8tbxE6hHdJIhvs+HW5ERdrknjLF9Z+SjzOX8yuIqhVJJmtwmk01Tkb3PeNg+UutpHzSjJ5aMnSmI1E5mw8frymBpDSIcBADZtvZYzCxWKao5vsANh4ect1PaXv+RnDkTwqSxnspVF1+uwz0RrKN97ZdpEPsYfXGdQ6OdE8K9LCYllOt6qi5UHqM4RSGIte9wDkbE7QZHKWC5TU7Hx4N9oLo7Qwpc0g13tcsdYgC9lHIXPPiTN1ESu3k14xUVhCQDpRgNSqWA6r5jv2juN+4rJ/NXp3R/rqRUe0Mx28O/52ndctryV9XT8Wtpd+DnEwqgNNtYeydo5zOZbEg7RlLdRNYES8fNrh8lUYEXE1+NcUiDnqk5EbjwnvD1CpKmXsdTD02G3K47RmJy+UdR4lz0aLFXLa3xZg7QwGVwd/dLQN8j4T3hsQaeRUVKRN2ptcA8wRmj8GHfcZHY4vRINL7RQY1KHvXt6yk3w1FGz8wyO3K4vFn3L/wAPKzEv9E+kLYKr1iTQqEa67dU7NdR8Q38QOIE7NSqKyhlIKkAgjMEHMEHeJ8/cj4/W+dG9GOmSyNhKhu1MayX3oTmP0kjublIpx8lzSXc7H9joMREiNAREQBERAEREAREQCk5V0j0qjYiqSwOq7KBf4er/AMZP+kekxhsNUq+8BZRxdsl7czfsBnECbnM3O0k7STx85LVxyZ2vaklD7lzSeML8h87SxTW2XIfvPdPDNUZgNlNGqN+VbfMsq/qgbT2D95LnLKO3bFIxz7TflP7TOwWCatWSmvtMtQrzK03cDvKAd8whtbsP15SVej6hr6QQ/wCXTqP5er//AEnknhMlrjukkRmoeqTynetDYf1WHo0ztp06aHtVQP2nP8J0JqHHEMlsMj64bKzLfWRFG3gp5KeInThIpyT6L2lqlDLZWIiRlwREQCG9K9Cm5xFMZbaij/cB8/HjIoDOtmc56Y6JbDP6+mv3LmzKBlTc77fA3ke0AWKrP6WZGt0ec2Q+6/yRrSdM21hkRmLctvlNUdItbVIGeVx/E274gOL3FpoqlO4+Ull8ijUk1iRUZZHu/gzN0JpV8JVFSnmh6rodjLvB58Du7CZrqL36p+hLg4H/ALnDWUWIycHlEy0/0bSpSGMwI1qTjWamBmOJUciCCm62XAaLotizTxmHqA5F1pnmtTqfNge6bf0eabNCv9ndvu6x6t9i1Ng/qyXt1ecm2I6H4V8QuIAZGVw5VSAjMDrAkWyNwCdUi+/bInLHDLsa1NqcOHnlEklYiRGgIiIAiIgCIiAUiJrNPaTXDUHqtnqiyj4mOSjx8Bc7oPG0llkC9JOlvWVVw6nq0us/52GQ7lP+s8JCQbAnv/ie8RVao7M51mclmPEk3PiZf0Xo58VXp0E943Y/CgzY9w8yBLKW1GNNuyz6m60do/1ei8RiGFnxD00T8i1FLf1EP3KJGxv+t06F6SKi0qOGwqAKq9aw3Ki6if7j/TOdkEgAAlmNgBtJY5DtztPIPjJ3fHElFeEkXEwpFNah2VWqKOYp6lz41CP0yfeirBH7/EEZErTX9PWb5p4GXdLdCqrYbB0qRQNRDB9YkC9TVZ2yBvZ12cDJhoXRiYaglFMwgzO9mObMeZJJnEp5WCzTQ42bn4RsoiJEXhERAEREASxiaCVEZHUMrAhgdhB2y/EA4j0o0A2EqlDc02uabcV4E/EuV+OR32mnU+M7lp3RKYqi1J8r5q29WGwj+N4JE4ppHBPRqNTcWdDY8CNxB3qRYiTwllGTqadjyumYVZLdYTJrUGCoxGVRdZGGYNjY2PEG6kbiJ42ibzol6uqXwNY2WqS1Jt6VgNo5MosRvsBvnTeOSKEd72+TQsTa4NmU3BG0EZgidz6OaS+04alWyuyjWtuYZOP6gZxfSWAehVanUFnU2PAj3WHEH9zwnQPRXib0a1I/+OprD8rr/Kt4zixZWSzpJOM3Fk9iIkJpCIiAIiIAiIgFJyHpzp/7TV1EN6VIkLbY77GbmNw5XO+SHp90l1AcLSbrsPvGHuqR7IPxEbeAPPLnFNWZlRVLuxsqqLsTyAksI+WZ+quz+iP3PFyN12JsAMyScgAN8610E6N/ZaReoPv6oBf8I2hL8d5tv42BmL0M6G+oIr4gBq3uptWn37GbnsG7jJfjtf1dT1dtfVbUubDWsdW57bTyc88Ik09Gz9T7OPdNNIevxdRgeqh9Wv5UuG8WLeM2no80AatUYqoPu6ZOoD7zj3uxfnbgZkaG9HdRmDYtwqD/AMaMSzfmf3R2XPMTpGHooiBEUKqgBVAsABsAESmsYR5VRKU98/wXZWIkZdEREAREQBERAEREApIp036PfaqfrKY++pg6v4l2lf3HPLK5krlLT1PDyczipppnz0wtn4j63yjOylaiGzIQykbiDcHuIk59IWgPVv8AaqY6jm1QD3WOxuxt/PtkGtu3HZLCe5GNODqnhnT9MYBdJ4KniKYHrglwBvtk9Mn8wNr7xuBM13orBFTFZEdWje+4g1BY8DL3oox5NOtQJ9hg69j3DAdhS/6pO6GEpozsiKrVDdiAAWIFrniZE3hNGjXWptWLvyZMREjLQiIgCIiAIiIBAP8A05VnZ6mKqMGYsbKqsSxuSWJNyb7bCSjQ+gcNhQRRphScixzZu1jnblsm2ieuTZHGqMXlIrERPCQREQBERAEREAREQBERAEREAREQDGxuFSrTam4urgqRyM4dpnRz4es9FtqNkfiU5q3eCPMbp3mQL0m6L1kTEqM0IR/yseqT2MbfrklcsPBU1de6O5dojno4xGpjwu6pTde8Wfx6h851+cW6E/8AuOG7av8A9NSdqizs90jzArERIy0IiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAUmHpXBCtRqUm2OrL2EjI9xse6ZkQeNZRyT0f4Fmx4LLY0FqFuTn7u3b1n/pM63NLoKioq4shQCawuQACfuqZz45sx7zxm6nUnlkVEFGGEViInJMIiIAiIgCIiAf/Z');">
                        </div>
                    </a>
                    <div class="shop-name" style="display: flex; flex-direction: column;">
                        <div>FPT Shop</div>
                        <div><a href="shopProduct.jsp">Xem ngay</a></div>
                    </div>
                    <div style="display: flex; flex-direction: column;">
                        <div>Đánh giá</div>
                        <div style="color: red;">80k</div>
                    </div>
                    <div style="display: flex; flex-direction: column;">
                        <div>Sản phẩm</div>
                        <div style="color: red;">100</div>
                    </div>
                    <div style="display: flex; flex-direction: column;">
                        <div>Số lượng đã bán</div>
                        <div style="color: red;">100k</div>
                    </div>
                </div>
            </div>
        </div>

        <h1 style="text-transform: uppercase;
            color: #7ab730;">Chi tiết sản phẩm</h1>
        <h1 style="text-align: left;
            font-size: 20px;
            display: block;
            line-height: 1.2;
            margin-top: 30px;">
            Cám chim là một loại thức ăn được sản xuất từ nhiều nguồn dinh dưỡng khác nhau như hạt, lúa mì, đậu nành và nhiều loại thực vật khác. 
            Nó được thiết kế để đáp ứng nhu cầu dinh dưỡng của các loài chim khác nhau, bao gồm các loại vẹt, bồ câu, sáo và cú.
        </h1>

        <!--        <div style="margin-top: 50px;">
                    <div class="mb-5">
                        <h3 class="border-start border-5 border-primary ps-3 mb-4" style="margin-left: 10px;">3 Bình luận</h3>
                        <div class="d-flex mb-4" style="margin-left: 10px;">
                            <img src="img/user.jpg" class="img-fluid" style="width: 45px; height: 45px;">
                            <div class="ps-3">
                                <h6><a href="">John Doe</a> <small><i>20/6/2023</i></small></h6>
                                <p>Giá cả hợp lí, đóng gói kĩ, shop giao hàng nhanh, mọi người yên tâm mua hàng của shop nha.</p>
                                <button class="btn btn-sm btn-light">Phản hồi</button>
                            </div>
                        </div>
                        <div class="d-flex mb-4" style="margin-left: 10px;">
                            <img src="img/user.jpg" class="img-fluid" style="width: 45px; height: 45px;">
                            <div class="ps-3">
                                <h6><a href="">William</a> <small><i>20/6/2023</i></small></h6>
                                <p>Cho hỏi có có ship ra nước ngoài không ạ</p>
                                <button class="btn btn-sm btn-light">Phản hồi</button>
                            </div>
                        </div>
                        <div class="d-flex ms-5 mb-4">
                            <img src="img/user.jpg" class="img-fluid" style="width: 45px; height: 45px;">
                            <div class="ps-3">
                                <h6><a href="">Staff</a> <small><i>01 Jan 2045</i></small></h6>
                                <p>Dạ shop em có hỗ trợ giao hàng ra nước ngoài ạ</p>
                                <button class="btn btn-sm btn-light">Phản hồi</button>
                            </div>
                        </div>
                    </div>-->
        
        <form action="ViewFeedbackController" >
             <input type="submit" name="shop_product_item_id" readonly="" value=2>
    <% 
    List<FeedbackDTO> listFeedback = (List<FeedbackDTO>) request.getAttribute("LIST_Feedback");
    if (listFeedback != null && !listFeedback.isEmpty()) {
        int count = 0;
        for (FeedbackDTO feedback : listFeedback) {
    %>
    <div><%= ++count %></div>
    <div><%= feedback.getCustomer_id() %></div>
    <div><%= feedback.getFeedback() %></div>
    <div><%= feedback.getCustomer_id() %></div>
 
    <% 
        }
    }
  
    %>
        </form>

        <!-- Comment List End -->

        <!-- Comment Form Start -->
        <div class="bg-light rounded p-5">
            <h3 class="text-uppercase border-start border-5 border-primary ps-3 mb-4">Bình luận</h3>
            <form>
                <div class="row g-3">
                    <div class="col-12 col-sm-4">
                        <input type="text" class="form-control bg-white border-0" placeholder="Tên của bạn" style="height: 55px;">
                    </div>
                    <div class="col-12 col-sm-4">
                        <input type="email" class="form-control bg-white border-0" placeholder="Email của bạn" style="height: 55px;">
                    </div>
                    <div class="col-12 col-sm-8">
                        <input type="text" class="form-control bg-white border-0" placeholder="Website" style="height: 55px;">
                    </div>
                    <div class="col-12 col-sm-8">
                        <textarea class="form-control bg-white border-0" rows="5" placeholder="Bình luận"></textarea>
                    </div>
                    <div class="col-12 col-sm-8">
                        <button class="btn btn-primary w-100 py-3" type="submit">Bình luận</button>
                    </div>
                </div>
            </form>
        </div>
    


    <!-- Comment Form End -->


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
                        <a class="text-body mb-2" href="index.html"><i class="bi bi-arrow-right text-primary me-2"></i>Trang chủ</a>

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
                    <p class="mb-md-0">&copy; <a class="text-white" href="index.html">Trang web được thiết kế bởi nhóm 3 </a> </p>
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <p class="mb-0">Nguồn <a class="text-white" href="https://htmlcodex.com">HTML Codex</a></p>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->

    <script>
        let bigImg = document.querySelector('.big-img img');
        function showImg(pic) {
            bigImg.src = pic;
        }
    </script>
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
    .url{
        display: flex;
        align-content: space-between;
    }
    .url1:hover{
        color: green;
    }
    .avatar {
        width: 50px;
        height: 50px;

        border-radius: 50%;
        -moz-border-radius:50%;
        -webkit-border-radius: 50%;
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
        width: 100%;
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
